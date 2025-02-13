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
        String dbUser  = DatabaseConfig.getDbUser ();
        String dbPass = DatabaseConfig.getDbPass(); // Decode if using Base64

        try (Connection conn = DriverManager.getConnection(dbUrl, dbUser , dbPass)) {
            try (Statement stmt = conn.createStatement();
                 ResultSet rows = stmt.executeQuery("SELECT * FROM AccountS")) {

                while (rows.next()) {
                    Account account = new Account(
                            rows.getInt("account_id"),
                            rows.getString("first_name"),
                            rows.getString("last_name"),
                            rows.getString("password"),
                            rows.getString("contact_num"),
                            rows.getString("address"),
                            rows.getDate("date_created"), // Assuming this is a Date type
                            rows.getString("created_by"),
                            rows.getString("role")
                    );
                    accounts.add(account);
                }
            }
        } catch (SQLException e) {
            System.out.println("Failed to load accounts: " + e.getMessage());
        }
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public static class Account {
        private int accountId;
        private String firstName;
        private String lastName;
        private String password;
        private String contactNum;
        private String address;
        private Date dateCreated; // Assuming this is a Date type
        private String createdBy;
        private String role;

        public Account(int accountId, String firstName, String lastName, String password, String contactNum, String address, Date dateCreated, String createdBy, String role) {
            this.accountId = accountId;
            this.firstName = firstName;
            this.lastName = lastName;
            this.password = password;
            this.contactNum = contactNum;
            this.address = address;
            this.dateCreated = dateCreated;
            this.createdBy = createdBy;
            this.role = role;
        }

        public int getAccountId() {
            return accountId;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public String getPassword() {
            return password;
        }

        public String getContactNum() {
            return contactNum;
        }

        public String getAddress() {
            return address;
        }

        public Date getDateCreated() {
            return dateCreated;
        }

        public String getCreatedBy() {
            return createdBy;
        }

        public String getRole() {
            return role;
        }
    }
}