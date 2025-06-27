package database;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

import exceptions.DatabaseException;

public class DB {

    public static DBTransaction beginTransaction(Runnable... operations) {
        return new DBTransaction(operations);
    }

    public static class DBTransaction {

        private final List<Runnable> operations = new ArrayList<>();
        private Consumer<Exception> errorHandler = null;

        public DBTransaction(Runnable... ops) {
            operations.addAll(Arrays.asList(ops));
        }

        public DBTransaction then(Runnable nextOp) {
            operations.add(nextOp);
            return this;
        }

        public DBTransaction onError(Consumer<Exception> handler) {
            this.errorHandler = handler;
            return this;
        }

        public void execute() throws DatabaseException {
            Connection conn = null;
            try {
                conn = ConnectionFactory.getConnection();
                conn.setAutoCommit(false);

                DBContext.setConnection(conn);

                for (Runnable op : operations) {
                    op.run();
                }

                conn.commit();
            } catch (SQLException e) {
                if (conn != null) {
                    try {
                        conn.rollback();
                    } catch (SQLException rollbackEx) {
                        throw new DatabaseException("Erro ao executar transação", rollbackEx);
                    }
                }
                if (errorHandler != null) {
                    errorHandler.accept(e);
                } else {
                    throw new DatabaseException("Erro ao executar transação", e);
                }
            } finally {
                DBContext.clear();
                if (conn != null) {
                    try {
                        conn.close();
                    } catch (SQLException e) {
                        throw new DatabaseException("Erro ao executar transação", e);
                    }
                }
            }
        }
    }
}
