package auth;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import model.bean.User;

public class Session {

    private static final Map<String, String> session = new HashMap<>();
    private static User user;

    private static LocalDateTime createdAt;
    private static final Duration SESSION_TIMEOUT = Duration.ofMinutes(30); // 30 minutos

    public static User user() {
        if (isExpired()) {
            expire();
            return null;
        }
        return Session.user;
    }

    public static void set(User user) {
        Session.user = user;
        if (user != null) {
            createdAt = LocalDateTime.now();
        } else {
            createdAt = null;
        }
    }

    public static void set(String key, String value) {
        if (!isExpired()) {
            Session.session.put(key, value);
        }
    }

    public static String get(String key) {
        if (!isExpired()) {
            return Session.session.get(key);
        }
        return null;
    }

    public static void regenerate() {
        createdAt = LocalDateTime.now();
    }

    public static void expire() {
        Session.user = null;
        Session.session.clear();
        createdAt = null;
        Auth.logout();
    }

    private static boolean isExpired() {
        if (createdAt == null) return true;
        Duration elapsed = Duration.between(createdAt, LocalDateTime.now());
        return elapsed.compareTo(SESSION_TIMEOUT) > 0;
    }

}
