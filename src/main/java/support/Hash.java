package support;

import org.mindrot.jbcrypt.BCrypt;

public class Hash {

    public static String hash(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public static boolean verify(String password, String storedHash) {
        try {

            if (storedHash == null || storedHash.length() == 0) {
                return false;
            }

            return BCrypt.checkpw(password, storedHash);
        } catch (Exception e) {
            return false;
        }
    }
}
