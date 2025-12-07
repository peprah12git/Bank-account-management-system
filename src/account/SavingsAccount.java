package account;

import customers.Customer;

public class SavingsAccount extends Account{

    // private fields
    private double interestRate;
    private double minimumBalance;

    // Setting constructor
    public SavingsAccount( Customer customer, double balance) {
        super( customer, balance);
        this.interestRate = 3.5;
        this.minimumBalance = 500;
    }

    @Override
    public void displayAccountDetails() {
        System.out.println( "Account Number: " + getAccountNumber() +
                "| |Customer Name: " + getCustomer().getName() +
                "| |Account Type: Savings" +
                "| |Balance: $" + getBalance() +
                "| | Interest Rate: " + interestRate + "%" +
                "| | Minimum Balance: $" + minimumBalance);

    }

    @Override
    public boolean withdraw(double amount) {
        if (getBalance() - amount < minimumBalance) {
            System.out.println(" Withdrawal denied! Balance cannot go below minimum: $" + minimumBalance);
            return false;
        }
        return super.withdraw(amount);
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
        return "Savings";
    }

    // Calculating interest method
    public double calculateInterest() {
        return (getBalance() + interestRate) / 100;
    }
// process t

}
