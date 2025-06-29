package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import exceptions.DatabaseException;

public class DB {

    /**
     * Inicia uma transação, executando as operações passadas por parâmetro, e em caso de erro,
     * aciona o handler de erro.
     * 
     * @see DBTransaction
     * 
     * @param operations as operações que serão executadas na transação
     * @return a transação iniciada
     * 
     */
    public static DBTransaction beginTransaction(DBOperation... operations) {
        return new DBTransaction(operations);
    }

    /**
     * Executa um comando SQL.
     *
     * @param conn uma conexão previamente estabelecida
     * @param sql o SQL statement
     * @param setter o StatementSetter, responsavel por preencher o statement
     * (stmt) com os parâmetros da query
     *
     * @throws DatabaseException caso ocorra algum erro
     * @return true se o statement foi executado com sucesso ou false caso
     * contrário
     */
    public boolean execute(Connection conn, String sql, StatementSetter setter) throws DatabaseException {
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            setter.setValues(stmt);
            return stmt.execute();
        } catch (SQLException ex) {
            throw new DatabaseException(ex.getMessage(), ex);
        }
    }


    /**
     * Executa um comando SQL.
     * Inicia e finaliza uma conexão com o banco.
     *
     * 
     * @param sql o SQL statement
     * @param setter o StatementSetter, responsavel por preencher o statement
     * (stmt) com os parâmetros da query
     *
     * @throws DatabaseException caso ocorra algum erro
     * @return true se o statement foi executado com sucesso ou false caso
     * contrário
     */
    public boolean execute(String sql, StatementSetter setter) throws DatabaseException {
        try (Connection conn = ConnectionFactory.getNewConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            setter.setValues(stmt);
            return stmt.execute();
        } catch (SQLException ex) {
            throw new DatabaseException(ex.getMessage(), ex);
        }
    }

    /**
     * Executa um update SQL.
     *
     * @param conn uma conexão previamente estabelecida
     * @param sql o SQL statement
     * @param setter o StatementSetter, responsavel por preencher o statement
     * (stmt) com os parâmetros da query
     *
     * @throws DatabaseException caso ocorra algum erro
     * @return o numero de linhas afetadas
     */
    public int executeUpdate(Connection conn, String sql, StatementSetter setter) throws DatabaseException {
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            setter.setValues(stmt);
            return stmt.executeUpdate();
        } catch (SQLException ex) {
            throw new DatabaseException(ex.getMessage(), ex);
        }
    }


    /**
     * Executa um update SQL.
     * Inicia e finaliza uma conexão com o banco.
     *
     * 
     * @param sql o SQL statement
     * @param setter o StatementSetter, responsavel por preencher o statement
     * (stmt) com os parâmetros da query
     *
     * @throws DatabaseException caso ocorra algum erro
     * @return o numero de linhas afetadas
     */
    public int executeUpdate(String sql, StatementSetter setter) throws DatabaseException {
        try (Connection conn = ConnectionFactory.getNewConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            setter.setValues(stmt);
            return stmt.executeUpdate();
        } catch (SQLException ex) {
            throw new DatabaseException(ex.getMessage(), ex);
        }
    }


    /**
     * Executa uma query SQL.
     *
     * @param conn uma conexão previamente estabelecida
     * @param sql o SQL statement
     * @param setter o StatementSetter, responsavel por preencher o statement
     * (stmt) com os parâmetros da query
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
            throw new DatabaseException(ex.getMessage(), ex);
        }
    }


    /**
     * Executa uma query SQL.
     * Inicia e finaliza uma conexão com o banco.
     * 
     * @param sql o SQL statement
     * @param setter o StatementSetter, responsavel por preencher o statement
     * (stmt) com os parâmetros da query
     * @param handler o ResultHandler, responsavel por processar o ResultSet
     *
     * @throws DatabaseException caso ocorra algum erro
     * @return o resultado da query
     */
    public <T> T executeQuery(String sql, StatementSetter setter, ResultHandler<T> handler) throws DatabaseException {
        try (Connection conn = ConnectionFactory.getNewConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            setter.setValues(stmt);
            try (ResultSet rs = stmt.executeQuery()) {
                return handler.handle(rs);
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex.getMessage(), ex);
        }
    }

}
