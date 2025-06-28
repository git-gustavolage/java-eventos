package database;

import java.sql.Connection;

import exceptions.DatabaseException;

@FunctionalInterface
public interface DBOperation {

    void run(Connection conn) throws DatabaseException;
}
