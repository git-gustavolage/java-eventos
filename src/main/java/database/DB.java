package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import exceptions.DatabaseException;

public class DB {

    private static DB instance;
    private final Connection conn;
    private boolean inTransaction = false;


    private DB() {
        this.conn = ConnectionFactory.getInstance().getConnection();
    }


    /**
     * Retorna a instância da própria classe.
     * 
     * @return a instância
     */
    public static synchronized DB getInstance() {
        if (instance == null) {
            instance = new DB();
        }
        return instance;
    }


    /**
     * Inicia uma transação no banco de dados.
     * 
     * @throws SQLException caso ocorra algum erro
     */
    public void beginTransaction() throws SQLException {
        if (inTransaction) {
            throw new IllegalStateException("Transação já iniciada.");
        }
        conn.setAutoCommit(false);
        inTransaction = true;
    }


    /**
     * Finaliza uma transação no banco de dados, commitando as alterações.
     * 
     * @throws SQLException caso ocorra algum erro
     */
    public void commit() throws SQLException {
        if (!inTransaction) {
            throw new IllegalStateException("Nenhuma transação ativa.");
        }
        conn.commit();
        conn.setAutoCommit(true);
        inTransaction = false;
    }


    /**
     * Finaliza uma transação no banco de dados, desfazendo as alterações.
     * 
     * @throws SQLException caso ocorra algum erro
     */
    public void rollback() {
        try {
            if (inTransaction) {
                conn.rollback();
                conn.setAutoCommit(true);
                inTransaction = false;
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao fazer rollback da transação", e);
        }
    }


    /**
     *  Executa um comando SQL.
     * 
     * @param sql o SQL statement
     * @param setter o StatementSetter, responsavel por preencher o statement (stmt) com os parâmetros da query
     * 
     * @throws DatabaseException caso ocorra algum erro
     * @return true se o statement foi executado com sucesso ou false caso contrário
     */
    public boolean execute(String sql, StatementSetter setter) throws DatabaseException {
        try (Connection localConn = ConnectionFactory.getInstance().open(); PreparedStatement stmt = localConn.prepareStatement(sql)) {
            setter.setValues(stmt);
            return stmt.execute();
        } catch (SQLException ex) {
            throw new DatabaseException("Erro ao executar SQL", ex);
        }
    }


    /**
     *  Executa um comando SQL.
     * 
     * @param conn uma conexão previamente estabelecida
     * @param sql o SQL statement
     * @param setter o StatementSetter, responsavel por preencher o statement (stmt) com os parâmetros da query
     * 
     * @throws DatabaseException caso ocorra algum erro
     * @return true se o statement foi executado com sucesso ou false caso contrário
     */
    public boolean execute(Connection conn, String sql, StatementSetter setter) throws DatabaseException {
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            setter.setValues(stmt);
            return stmt.execute();
        } catch (SQLException ex) {
            throw new DatabaseException("Erro ao executar SQL", ex);
        }
    }


    /**
     * Executa um update SQL.
     * 
     * @param sql o SQL statement
     * @param setter o StatementSetter, responsavel por preencher o statement (stmt) com os parâmetros da query
     * 
     * @throws DatabaseException caso ocorra algum erro
     * @return o numero de linhas afetadas
     */
    public int executeUpdate(String sql, StatementSetter setter) throws DatabaseException {
        try (Connection localConn = ConnectionFactory.getInstance().open(); PreparedStatement stmt = localConn.prepareStatement(sql)) {
            setter.setValues(stmt);
            return stmt.executeUpdate();
        } catch (SQLException ex) {
            throw new DatabaseException("Erro ao executar update", ex);
        }
    }


    /**
     * Executa um update SQL.
     * 
     * @param conn uma conexão previamente estabelecida
     * @param sql o SQL statement
     * @param setter o StatementSetter, responsavel por preencher o statement (stmt) com os parâmetros da query
     * 
     * @throws DatabaseException caso ocorra algum erro
     * @return o numero de linhas afetadas
     */
    public int executeUpdate(Connection conn, String sql, StatementSetter setter) throws DatabaseException {
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            setter.setValues(stmt);
            return stmt.executeUpdate();
        } catch (SQLException ex) {
            throw new DatabaseException("Erro ao executar update", ex);
        }
    }


    /**
     * Executa uma query SQL.
     * 
     * @param sql o SQL statement
     * @param setter o StatementSetter, responsavel por preencher o statement (stmt) com os parâmetros da query
     * @param handler o ResultHandler, responsavel por processar o ResultSet
     * 
     * @throws DatabaseException caso ocorra algum erro
     * @return o resultado da query
     */
    public <T> T executeQuery(String sql, StatementSetter setter, ResultHandler<T> handler) throws DatabaseException {
        try (Connection localConn = ConnectionFactory.getInstance().open(); PreparedStatement stmt = localConn.prepareStatement(sql)) {
            setter.setValues(stmt);
            try (ResultSet rs = stmt.executeQuery()) {
                return handler.handle(rs);
            }
        } catch (SQLException ex) {
            throw new DatabaseException("Erro ao executar query", ex);
        }
    }


    /**
     * Executa uma query SQL.
     * 
     * @param conn uma conexão previamente estabelecida
     * @param sql o SQL statement
     * @param setter o StatementSetter, responsavel por preencher o statement (stmt) com os parâmetros da query
     * @param handler o ResultHandler, responsavel por processar o ResultSet
     * 
     * @throws DatabaseException caso ocorra algum erro
     * @return o resultado da query
     */
    public <T> T executeQuery(Connection conn, String sql, StatementSetter setter, ResultHandler<T> handler) throws DatabaseException {
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            setter.setValues(stmt);
            try (ResultSet rs = stmt.executeQuery()) {
                return handler.handle(rs);
            }
        } catch (SQLException ex) {
            throw new DatabaseException("Erro ao executar query", ex);
        }
    }


    /**
     * Retorna a conexão.
     * 
     * @return a conexão
     */
    public Connection getConnection() {
        return conn;
    }


    /**
     * Fecha a conexão.
     * 
     * @return a conexão
     */
    public void close() {
        ConnectionFactory.getInstance().closeConnection();
        instance = null;
    }
}
