package pos.project_d;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import pos.project_d.config.DatabaseConfig;


public class ConnectionTest {
    static String DB_URL = DatabaseConfig.getDbUrl();
    static String DB_USER  = DatabaseConfig.getDbUser ();
    static String DB_PASS = DatabaseConfig.getDbPass();
;

    public static void main(String[] args) {
        
        try (var conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS)) {
            System.out.println("Database connection successful!");

            // Get all table names
            try (Statement tableStmt = conn.createStatement();
                 ResultSet tables = tableStmt.executeQuery("SHOW TABLES")) {

                while (tables.next()) {
                    String tableName = tables.getString(1);
                    System.out.println("\nTable: " + tableName);

                    // Fetch the first row from the table using a NEW Statement
                    try (Statement rowStmt = conn.createStatement();
                         ResultSet row = rowStmt.executeQuery("SELECT * FROM " + tableName + " LIMIT 1")) {

                        ResultSetMetaData metaData = row.getMetaData();
                        int columnCount = metaData.getColumnCount();

                        if (row.next()) {
                            for (int i = 1; i <= columnCount; i++) {
                                System.out.println(metaData.getColumnName(i) + ": " + row.getString(i));
                            }
                        } else {
                            System.out.println("No data found in this table.");
                        }
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("Connection failed: " + e.getMessage());
        }
    }
}
