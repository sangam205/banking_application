package com.bankApp;

public class User {
    private String username;
    private String userId;
    private String password;
    private double balance;

    public User(String username, String userId, String password) {
        this.username = username;
        this.userId = userId;
        this.password = password;
        this.balance = 0.0;
    }

    public String getUsername() {
        return username;
    }

    public String getUserId() {
        return userId;
    }

    public String getPassword() {
        return password;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful..! New balance: Rs " + balance);
        } else {
            System.out.println("Invalid deposit amount..!");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful..! New balance: Rs " + balance);
        }  else if (amount > balance){
            System.out.println("Insufficient balance..!");
        } else {
            System.out.println("Invalid withdrawal amount..!");
        }
    }

    public void balanceEnquiry() {
        System.out.println("Your current balance is: Rs " + balance);
    }
}
