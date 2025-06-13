package gerant_connection;
import Gui_Package.*;

public class Password_Verification {
    private static final String CORRECT_PASSWORD = "0000";

    // Method to verify the password
    public static boolean verify(String password) {
        return CORRECT_PASSWORD.equals(password);
    }
}

