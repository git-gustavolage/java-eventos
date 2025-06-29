package database;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Interface para preencher o Statement.
 * 
 */
@FunctionalInterface
public interface StatementSetter {

    void setValues(PreparedStatement stmt) throws SQLException;
}
