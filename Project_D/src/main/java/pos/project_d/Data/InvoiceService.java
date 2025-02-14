package pos.project_d.data;

import pos.project_d.model.Invoice;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;
import pos.project_d.config.DatabaseConfig;

/**
 * Invoice Service - Handles database operations for invoices.
 */
public class InvoiceService {
    String DB_URL = DatabaseConfig.getDbUrl();
    String DB_USER = DatabaseConfig.getDbUser();
    String DB_PASS = DatabaseConfig.getDbPass(); 


    /**
     * Fetches invoices created today.
     */
    public List<Invoice> getDailyInvoices() {
        List<Invoice> invoices = new ArrayList<>();
        String query = "SELECT * FROM invoice WHERE DATE(created_at) = CURDATE()";

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                invoices.add(new Invoice(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("amount"),
                        rs.getBigDecimal("price"),
                        rs.getBigDecimal("total"),
                        rs.getString("status"),
                        rs.getBoolean("picked_up")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return invoices;
    }

    /**
     * Inserts a new invoice into the database.
     */
    public boolean insertInvoice(Invoice invoice) {
        String query = "INSERT INTO invoice (name, amount, price, status, picked_up) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, invoice.getName());
            stmt.setInt(2, invoice.getAmount());
            stmt.setBigDecimal(3, invoice.getPrice());
            stmt.setString(4, invoice.getStatus());
            stmt.setBoolean(5, invoice.isPickedUp());

            return stmt.executeUpdate() > 0; // ✅ Returns true if insertion is successful
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
