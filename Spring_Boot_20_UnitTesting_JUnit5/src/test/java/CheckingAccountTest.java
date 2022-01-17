import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheckingAccountTest {

    CheckingAccount checkingAccount;

    @BeforeEach
    void setUp() {
        checkingAccount=new CheckingAccount();
        checkingAccount.setInfo(100,12345476L,"Ozzy");
    }

    @Test
    void deposit() {
        assertEquals(200,checkingAccount.deposit(100));
    }

    @Test
    void withdraw() {
        assertEquals(80,checkingAccount.withdraw(20));
    }

    @Test
    void purchase() {
        assertEquals(-65,checkingAccount.purchase("Shoes",130));
    }

    @Test
    void withdraw_branch(){
        assertThrows(IllegalArgumentException.class,() ->{
            checkingAccount.withdraw_branch(600,false);
        });
    }
}