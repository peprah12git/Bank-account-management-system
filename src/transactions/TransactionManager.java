package transactions;

public class TransactionManager {

    // Fields
    private Transaction[] transactions;
    private int transactionCount;

    // Constructor
    public TransactionManager() {
        this.transactions = new Transaction[200];
        this.transactionCount = 0;
    }

    // Add a new transaction
    public void addTransaction(Transaction transaction) {
        if (transactionCount < transactions.length) {
            transactions[transactionCount] = transaction;
            transactionCount++;
        } else {
            System.out.println("Transaction list is full.");
        }
    }

    // View transactions for specific account
    public void viewTransactionsByAccount(String accountNumber) {
        boolean found = false;

        for (int i = 0; i < transactionCount; i++) {
            if (transactions[i].getAccountNumber().equals(accountNumber)) {
                transactions[i].displayTransactionDetails();
                System.out.println("------------------------------");
                found = true;
            }
        }

        if (!found) {
            System.out.println("No transactions found for account: " + accountNumber);
        }
    }

    // Sum of all deposits for a given account
    public double calculateTotalDeposits(String accountNumber) {
        double total = 0;

        for (int i = 0; i < transactionCount; i++) {
            Transaction t = transactions[i];

            if (t.getAccountNumber().equals(accountNumber)
                    && t.getType().equalsIgnoreCase("DEPOSIT")) {
                total += t.getAmount();
            }
        }

        return total;
    }

    // Sum of all withdrawals for a given account
    public double calculateTotalWithdrawals(String accountNumber) {
        double total = 0;

        for (int i = 0; i < transactionCount; i++) {
            Transaction t = transactions[i];

            if (t.getAccountNumber().equals(accountNumber)
                    && t.getType().equalsIgnoreCase("WITHDRAWAL")) {
                total += t.getAmount();
            }
        }

        return total;
    }

    // Number of transactions
    public int getTransactionCount() {
        return transactionCount;
    }
}
