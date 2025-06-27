package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import database.ConnectionFactory;
import exceptions.DatabaseException;

public class QueryExecutor {

    // public static boolean execute(Connection conn, String sql, StatementSetter setter) throws DatabaseException {

    //     try (PreparedStatement stmt = conn.prepareStatement(sql)) {
    //         setter.setValues(stmt);
    //         return stmt.execute();
    //     } catch (SQLException ex) {
    //         throw new DatabaseException(ex.getMessage(), ex);
    //     }
    // }

    // public static boolean execute (String sql, StatementSetter setter) throws DatabaseException {
    //     Connection conn = ConnectionFactory.getConnection();

    //     try (PreparedStatement stmt = conn.prepareStatement(sql)) {
    //         setter.setValues(stmt);
    //         return stmt.execute();
    //     } catch (SQLException ex) {
    //         throw new DatabaseException(ex.getMessage(), ex);
    //     } finally {
    //         ConnectionFactory.close(conn);
    //     }
    // }

    // public static int executeUpdate(Connection conn, String sql, StatementSetter setter) throws DatabaseException {

    //     try (PreparedStatement stmt = conn.prepareStatement(sql)) {
    //         setter.setValues(stmt);
    //         return stmt.executeUpdate();
    //     } catch (SQLException ex) {
    //         throw new DatabaseException(ex.getMessage(), ex);
    //     }
    // }

    // public static int executeUpdate(String sql, StatementSetter setter) throws DatabaseException {
    //     Connection conn = ConnectionFactory.getConnection();

    //     try (PreparedStatement stmt = conn.prepareStatement(sql)) {
    //         setter.setValues(stmt);
    //         return stmt.executeUpdate();
    //     } catch (SQLException ex) {
    //         throw new DatabaseException(ex.getMessage(), ex);
    //     } finally {
    //         ConnectionFactory.close(conn);
    //     }
    // }
}
