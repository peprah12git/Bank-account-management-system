package account;

import customers.Customer;

public class CheckingAccount extends Account {

    private double overdraftLimit;
    private double monthlyFee;

    // Constructor
    public CheckingAccount( Customer customer, double balance) {
        super(customer, balance);
        this.overdraftLimit = 1000.0;
        this.monthlyFee = 10.0;
    }

    @Override
    public void displayAccountDetails() {
        System.out.println("---------------------------------------------");
        System.out.println( "Account Number: " + getAccountNumber() +
                "| |Customer Name: " + getCustomer().getName() +
                "| |Account Type: Checking" +
                "| |Balance: $" + getBalance() +
                "| |Overdraft Limit: $" + overdraftLimit

        );
        System.out.println("---------------------------------------------");
    }

    @Override
    public boolean withdraw(double amount) {
        double allowedLimit = -overdraftLimit; // balance can go down to -1000

        if (getBalance() - amount < allowedLimit) {
            System.out.println("Withdrawal denied! Exceeds overdraft limit of $" + overdraftLimit);
            return false;
        }

        return super.withdraw(amount); // uses parent logic for updating balance
    }

    @Override
    public boolean processTransaction(double amount, String type) {
        if (type.equalsIgnoreCase("Deposit")) {
            if (amount <= 0) {
                return false;
            }
            this.deposit(amount);
            return true;
        } else if (type.equalsIgnoreCase("Withdrawal")) {
            if (amount <= 0) {
                return false;
            }
            double oldBalance = this.getBalance();
            this.withdraw(amount);
            return this.getBalance() != oldBalance;
        }
        return false;
    }

    @Override
    public String getAccountType() {
        return "Checking";
    }

    public void applyMonthlyFee() {
        System.out.println("Monthly fee of $" + monthlyFee + " applied.");
        setBalance(getBalance() - monthlyFee);
    }
}
