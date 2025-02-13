package pos.project_d.utils;

import pos.project_d.Data.AccountData;

public class SessionManager {
    private static AccountData.Account loggedInUser = null;

    public static void setLoggedInUser(AccountData.Account user) {
        loggedInUser = user;
    }

    public static AccountData.Account getLoggedInUser() {
        return loggedInUser;
    }

    public static void logout() {
        loggedInUser = null; // Clears session
    }
}
