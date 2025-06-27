package database;

import java.sql.Connection;

public class DBContext {

    private static final ThreadLocal<Connection> context = new ThreadLocal<>();

    public static void setConnection(Connection conn) {
        context.set(conn);
    }

    public static Connection getConnection() {
        return context.get();
    }

    public static void clear() {
        context.remove();
    }
}
