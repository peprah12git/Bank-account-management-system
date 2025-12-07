package account;

public class AccountManager {
    private Account[] accounts;
    private int accountCount;

    // Constructor
    public AccountManager() {
        this.accounts = new Account[50];  // capacity
        this.accountCount = 0;
    }

    // add account method
    public void addAccount(Account account) {
        if (accountCount < accounts.length) {
            accounts[accountCount] = account;
            accountCount++;
        } else {
            System.out.println("Account list is full.");
        }
    }

    // find account method
    public Account findAccount(String accountNumber) {
        for (int i = 0; i < accountCount; i++) {
            if (accounts[i].getAccountNumber().equals(accountNumber)) {
                return accounts[i];
            }
        }
        return null;  // no match found
    }

    // view all accounts
    public void viewAllAccounts() {
        if (accountCount == 0) {
            System.out.println("No accounts available.");
            return;
        }

        for (int i = 0; i < accountCount; i++) {
            accounts[i].displayAccountDetails();
            System.out.println("--------------------------------");
        }
    }

    // sum of all balances
    public double getTotalBalance() {
        double total = 0;

        for (int i = 0; i < accountCount; i++) {
            total += accounts[i].getBalance();
        }

        return total;
    }

    // number of accounts
    public int getAccountCount() {
        return accountCount;
    }
}
