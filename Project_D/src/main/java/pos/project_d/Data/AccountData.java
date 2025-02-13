package pos.project_d.Data;

import pos.project_d.config.DatabaseConfig;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountData {
    private List<Account> accounts;

    public AccountData() {
        accounts = new ArrayList<>();
        loadAccounts();
    }

    private void loadAccounts() {
        String dbUrl = DatabaseConfig.getDbUrl();
        String dbUser = DatabaseConfig.getDbUser();
        String dbPass = DatabaseConfig.getDbPass(); 

        try (Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPass);
             Statement stmt = conn.createStatement();
             ResultSet rows = stmt.executeQuery("SELECT account_id, first_name, last_name, password, role FROM AccountS")) {

            while (rows.next()) {
                Account account = new Account(
                        rows.getInt("account_id"),
                        rows.getString("first_name"),
                        rows.getString("last_name"),
                        rows.getString("password"),
                        rows.getString("role")
                );
                accounts.add(account);
            }
        } catch (SQLException e) {
            System.out.println("Failed to load accounts: " + e.getMessage());
        }
    }

    // New optimized method for direct database validation
    public boolean validateLogin(String username, String password) {
        String dbUrl = DatabaseConfig.getDbUrl();
        String dbUser = DatabaseConfig.getDbUser();
        String dbPass = DatabaseConfig.getDbPass();

        try (Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPass);
             PreparedStatement stmt = conn.prepareStatement(
                 "SELECT * FROM AccountS WHERE first_name = ? AND password = ?")) {

            stmt.setString(1, username);
            stmt.setString(2, password);

            try (ResultSet rs = stmt.executeQuery()) {
                return rs.next(); // If a row exists, login is valid
            }
        } catch (SQLException e) {
            System.out.println("Login failed: " + e.getMessage());
        }
        return false;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public static class Account {
        private int accountId;
        private String firstName;
        private String lastName;
        private String password;
        private String role;

        public Account(int accountId, String firstName, String lastName, String password, String role) {
            this.accountId = accountId;
            this.firstName = firstName;
            this.lastName = lastName;
            this.password = password;
            this.role = role;
        }

        public int getAccountId() { return accountId; }
        public String getFirstName() { return firstName; }
        public String getLastName() { return lastName; }
        public String getPassword() { return password; }
        public String getRole() { return role; }
    }
}
