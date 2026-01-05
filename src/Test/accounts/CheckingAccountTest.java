package Test.accounts;

import account.CheckingAccount;
import customers.Customer;
import customers.RegularCustomer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CheckingAccountTest {

    @Test
    void displayAccountDetails() {
    }


    @Test
    void withdraw_withinOverdraftLimit_shouldSucceed() throws Exception {
        Customer customer = new RegularCustomer("Peprah",34,"058 44 5758","Kumasi");
        CheckingAccount account = new CheckingAccount(customer, 500);

        boolean result = account.withdraw(800);

        assertTrue(result);
        assertEquals(-300, account.getBalance());
    }


    @Test
    void processTransaction() {
    }

    @Test
    void getAccountType() {
    }

    @Test
    void applyMonthlyFee() {
    }
}