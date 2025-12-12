package account;

import customers.Customer;
import exceptions.InsufficientFundsException;
import exceptions.InvalidAmountException;

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

    /**
     * Validates that a withdrawal amount does not breach the minimum balance requirement.
     *
     * @param amount
     * @return
     * @throws InsufficientFundsException when the withdrawal would result in a balance below the minimum
     * @throws InvalidAmountException
     */

    @Override
    public boolean withdraw(double amount)  throws InsufficientFundsException {
        if (getBalance() - amount < minimumBalance) {
            System.out.println(" Withdrawal denied! Balance cannot go below minimum: $" + minimumBalance);
            return false;
        }
        this.setBalance(getBalance() - amount);
        return true;  //  Return true on success
    }

    @Override
    public boolean processTransaction(double amount, String type) throws InvalidAmountException {
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
            try {
                this.withdraw(amount);
            }catch (InsufficientFundsException e){
                return false;
            }
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
