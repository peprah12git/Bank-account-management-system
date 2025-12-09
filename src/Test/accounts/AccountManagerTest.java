package Test.accounts;

import account.*;
import customers.Customer;
import customers.RegularCustomer;
import exception.ViewAccountException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import exception.AccountNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class AccountManagerTest {
    private AccountManager accountManager;
    private Customer customer;

    @BeforeEach
    void setUp() {
        accountManager = new AccountManager();
        customer = new RegularCustomer("Alice", 28, "555-0101", "321 Pine St");
    }


    @Test
    void testAddAccount() {
        Account account = new CheckingAccount(customer, 500.0);
        accountManager.addAccount(account);
        assertEquals(1, accountManager.getAccountCount());
    }
    //Test method for when the account does not exist
//    @Test
//    void testFindAccountExists() throws AccountNotFoundException {
//        Account found = accountManager.findAccount("12345");
//        assertNotNull(found);
//        assertEquals("12345", found.getAccountNumber());
//    }
    @Test
    void testViewAllAccountsThrowsExceptionWhenEmpty()  throws ViewAccountException{
        AccountManager manager = new AccountManager(); // no Test.accounts added
        // Check that the exception is thrown
        assertThrows(ViewAccountException.class, () -> {
            manager.viewAllAccounts();
        });
    }

    @Test
    void getTotalBalance() {
    }

    @Test
    void getAccountCount() {
    }
}