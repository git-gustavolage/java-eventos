package database;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

import exceptions.DatabaseException;

public class DBTransaction {

    private final List<DBOperation> operations = new ArrayList<>();
    private Consumer<Exception> errorHandler = null;
    private Connection conn = null;

    public DBTransaction(DBOperation... ops) {
        operations.addAll(Arrays.asList(ops));
    }

    public DBTransaction then(DBOperation nextOp) {
        operations.add(nextOp);
        return this;
    }

    public DBTransaction then(DBOperation... ops) {
        operations.addAll(Arrays.asList(ops));
        return this;
    }

    public void execute() throws DatabaseException {
        try {
            conn = new ConnectionFactory().open();
            conn.setAutoCommit(false);

            DBContext.setConnection(conn);

            for (DBOperation op : operations) {
                op.run(conn);
            }

            conn.commit();
        } catch (DatabaseException | SQLException e) {
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException rollbackEx) {
                    throw new DatabaseException("Erro ao executar transação:\n" + e.getMessage(), rollbackEx);
                }
            }
            if (errorHandler != null) {
                errorHandler.accept(e);
            } else {
                throw new DatabaseException("Erro ao executar transação:\n" + e.getMessage(), e);
            }
        } finally {
            DBContext.clear();
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    throw new DatabaseException("Erro ao executar transação:\n" + e.getMessage(), e);
                }
            }
        }
    }

    public DBTransaction onError(Consumer<Exception> handler) {
        this.errorHandler = handler;
        return this;
    }
}
