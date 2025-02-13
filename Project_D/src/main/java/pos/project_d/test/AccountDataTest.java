package pos.project_d.test;


import java.util.Scanner;
import pos.project_d.Data.AccountData;
import pos.project_d.utils.SessionManager;

public class AccountDataTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        AccountData accountData = new AccountData();
        for (AccountData.Account account : accountData.getAccounts()) {
            if (account.getFirstName().equals(username) && account.getPassword().equals(password)) {
                SessionManager.setLoggedInUser(account); // ✅ Store user
                System.out.println("\n✅ Login successful for user: " + username);
                break;
            }
        }

        if (SessionManager.getLoggedInUser() == null) {
            System.out.println("\n❌ Invalid username or password.");
        }

        scanner.close();
    }
}
