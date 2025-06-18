package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

@FunctionalInterface
public interface ResultParser<T> {
    T parse(ResultSet result) throws SQLException;
}