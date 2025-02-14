package pos.project_d.utils;

import pos.project_d.Data.AccountData;

/**
 * SessionManager - Handles logged-in user and shared data.
 */
public class SessionManager {
    private static AccountData.Account loggedInUser = null;
    private static AccountData accountData = new AccountData(); // ✅ Stores shared AccountData

    public static void setLoggedInUser(AccountData.Account user) {
        loggedInUser = user;
    }

    public static AccountData.Account getLoggedInUser() {
        return loggedInUser;
    }

    public static void logout() {
        loggedInUser = null; // Clears session
    }

    public static AccountData getAccountData() { // ✅ Provides global AccountData
        return accountData;
    }
}
