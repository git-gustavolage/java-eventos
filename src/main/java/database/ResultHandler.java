package database;

import java.sql.ResultSet;
import java.sql.SQLException;

import exceptions.DatabaseException;

@FunctionalInterface
public interface ResultHandler<T> {

    T handle(ResultSet rs) throws SQLException, DatabaseException;
}
