package Test;

import account.SavingsAccount;
import customers.Customer;
import customers.RegularCustomer;
import exception.InvalidAmountException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {
    Customer customer;
    @BeforeEach
    void initializeData(){
        customer = new RegularCustomer("Peprah",23, "0593334545","kumasi");
    }

    @Test
    void generate() {
    }

    @Test
    void getAccountNumber() {
    }

    @Test
    void getCustomer() {
    }

    @Test
    void setCustomer() {
    }

    @Test
    void getBalance() {
    }

    @Test
    void getStatus() {
    }

    @Test
    void setStatus() {
    }

    @Test
    void setBalance() {
    }

    @Test
    void displayAccountDetails() {
    }

    @Test
    void getAccountType() {
    }

    @Test
    public void testdeposit() throws InvalidAmountException {
        SavingsAccount account = new SavingsAccount(customer,1000);
        account.deposit(500);
        assertEquals(500,account.getBalance());
    }


    @Test
    public void testInvalidWithdrawal()  {
        SavingsAccount account = new SavingsAccount(customer, 1000);
        assertThrows(InvalidAmountException.class, () -> account.withdraw(0));
    }



    @Test
    void processTransaction() {
    }
}