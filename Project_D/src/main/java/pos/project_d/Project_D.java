/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package pos.project_d;

/**
 *
 * @author Nathan
 */

import java.sql.*;

public class Project_D {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        String url = "jdbc:mysql://127.0.0.1:3306/wtf";
        String user = "root";
        String password = "HAHAgoatmilk123!";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            System.out.println("✅ Connection to MySQL is successful!");
        } catch (SQLException e) {
            System.out.println("❌ Connection failed!");
            e.printStackTrace();
        }
        
        String query = "SELECT * FROM customer";
        
        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            // Print column headers
            System.out.println("+----------------------+----------------------+------------+");
            System.out.printf("| %-20s | %-20s | %-10s |\n", "Name", "Address", "Contact Num");
            System.out.println("+----------------------+----------------------+------------+");

            // Print each row from the table
            while (rs.next()) {
                String name = rs.getString("name");
                String address = rs.getString("address");
                int contactNum = rs.getInt("contact_num");

                System.out.printf("| %-20s | %-20s | %-10d |\n", name, address, contactNum);
            }

            System.out.println("+----------------------+----------------------+------------+");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
