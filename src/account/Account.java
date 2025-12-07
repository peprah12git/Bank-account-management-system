package account;

import customers.Customer;

public abstract class Account {
    private String accountNumber;
    private Customer customer;
    private double balance;
    private String status;

    private static int accountCounter= 0;

    // Contructor
    public Account( Customer customer, double balance) {
        this.accountNumber = generate() ;
        this.customer = customer;
        this.balance = balance;
        this.status = "Active";
        //this.accountNumber= accountCounter;
    }

    static String generate() {
        return  String.format("ACC%03d", ++accountCounter);
    }

    // Getters for account number
    public String getAccountNumber() {
        return accountNumber;
    }
    // getter for customer
    public Customer getCustomer() {
        return customer;
    }
    // setter for customer
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    //-------getter for balance------
    public double getBalance() {
        return balance;
    }
    //-------getter for Status------
    public String getStatus() {
        return status;
    }

    // setter for status
    public void setStatus(String status) {
        this.status = status;
    }

    // Setters for balance
    public double setBalance(double balance) {
        return balance;
    }
    // get accounts.Account method & Display Account method
    public abstract void displayAccountDetails();
    public abstract String getAccountType();

    // Deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful. Balance: " + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }
    // Withdraw Money
    public  boolean withdraw(double amount){
        if (amount > balance){
            System.out.println("Insufficient funds withdrawer can not be made");
        }else {
            balance-=amount;
            System.out.println("Withdrawal made successfully");
        }
        return true;
    }

    public abstract boolean processTransaction(double amount, String type);

}
