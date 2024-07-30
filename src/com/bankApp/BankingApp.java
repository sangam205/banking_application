package com.bankApp;
import java.util.Scanner;

public class BankingApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        User[] users = {
                new User("Rio Raj", "rio123", "raj321"),
                new User("Manisha Rani", "Mani123", "rani321"),
                new User("Shreya Shalini", "shreya123", "Shalini321"),
                new User("Akash Singh", "akash123", "singh321")
        };

        Bank bank = new Bank(users);

        System.out.println("\nWelcome to the Bank of India...!!!");

        int attempts = 0;
        User authenticatedUser = null;

        while (attempts < 5 && authenticatedUser == null) {
            System.out.print("Enter User ID: ");
            String userId = scanner.nextLine();
            System.out.print("Enter Password: ");
            String password = scanner.nextLine();

            authenticatedUser = bank.authenticate(userId, password);

            if (authenticatedUser == null) {
                attempts++;
                if (bank.isBlocked(attempts)) {
                    System.out.println("Account is blocked. Kindly visit the bank.");
                    return;
                } else {
                    System.out.println("Incorrect User ID or Password. Attempts remaining: " + (5 - attempts));
                    System.out.print("Do you want to continue? [ Yes (Y) / No (N) ]: ");
                    String continueChoice = scanner.nextLine();
                    if (!continueChoice.equalsIgnoreCase("Y")) {
                        return;
                    }
                }
            }
        }

        System.out.println("Welcome, " + authenticatedUser.getUsername() + "..!");

        boolean exit = false;
        while (!exit) {
            System.out.println("Please select an option:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Balance Enquiry");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    authenticatedUser.deposit(depositAmount);
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    authenticatedUser.withdraw(withdrawAmount);
                    break;
                case 3:
                    authenticatedUser.balanceEnquiry();
                    break;
                case 4:
                    exit = true;
                    System.out.println("Thank you for using the Banking Application. See you soon..!!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}
