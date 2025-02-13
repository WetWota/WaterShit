package pos.project_d.test;

import pos.project_d.Data.AccountData;

import java.util.List;

public class AccountDataTest {
    public static void main(String[] args) {
        AccountData accountData = new AccountData();
        List<AccountData.Account> accounts = accountData.getAccounts();

        if (accounts.isEmpty()) {
            System.out.println("No accounts found.");
        } else {
            for (AccountData.Account account : accounts) {
                System.out.println("Account ID: " + account.getAccountId());
                System.out.println("First Name: " + account.getFirstName());
                System.out.println("Last Name: " + account.getLastName());
                System.out.println("Password: " + account.getPassword());
                System.out.println("Contact Number: " + account.getContactNum());
                System.out.println("Address: " + account.getAddress());
                System.out.println("Date Created: " + account.getDateCreated());
                System.out.println("Created By: " + account.getCreatedBy());
                System.out.println("Role: " + account.getRole());
                System.out.println("---------------------------");
            }
        }
    }
}