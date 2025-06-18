package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import database.ConnectionFactory;

public abstract class Dao {

    public static boolean execute(String sql, StatementSetter setter, String errorMessage, Class<?> clazz) {
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement(sql);
            setter.setValues(stmt);
            return stmt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(clazz.getName()).log(Level.SEVERE, errorMessage, ex);
            return false;
        } finally {
            ConnectionFactory.close(conn, stmt);
        }
    }

    public static <T> T executeQueryForSingleResult(String sql, StatementSetter setter, ResultParser<T> parser, String errorMessage, Class<?> clazz) {
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement(sql);
            setter.setValues(stmt);
            ResultSet result = stmt.executeQuery();

            if (!result.next()) {
                return null;
            }

            return parser.parse(result);
        } catch (SQLException ex) {
            Logger.getLogger(clazz.getName()).log(Level.SEVERE, errorMessage, ex);
            return null;
        } finally {
            ConnectionFactory.close(conn, stmt);
        }
    }

    public static <T> List<T> executeQueryForMultipleResults(String sql, StatementSetter setter, ResultParser<T> parser, String errorMessage, Class<?> clazz) {
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        List<T> results = new ArrayList<>();

        try {
            stmt = conn.prepareStatement(sql);
            setter.setValues(stmt);
            ResultSet result = stmt.executeQuery();

            while (result.next()) {
                results.add(parser.parse(result));
            }

            return results;
        } catch (SQLException ex) {
            Logger.getLogger(clazz.getName()).log(Level.SEVERE, errorMessage, ex);
            return Collections.emptyList();
        } finally {
            ConnectionFactory.close(conn, stmt);
        }
    }

}
