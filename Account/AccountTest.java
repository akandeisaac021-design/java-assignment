import java.math.BigDecimal;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class AccountTest {

    private Account myAccount; // Make this a class-level field

    @BeforeEach
    public void setUp(){
        myAccount = new Account(true, true, BigDecimal.ZERO);
    }

    @Test
    public void testThatMoneyWasDeposited(){

        myAccount.deposit(new BigDecimal("200"));
        assertEquals(new BigDecimal("200"), myAccount.getBalance(true, true));
    }

    @Test
    public void testNegativeDepositDoesNotChangeBalance(){

        myAccount.deposit(new BigDecimal("-200"));
        assertEquals(BigDecimal.ZERO, myAccount.getBalance(true, true));
    }

    @Test
    public void testThatAmountWasWithdrawledSuccessfully(){

        myAccount.deposit(new BigDecimal("500"));
        myAccount.withdrawal(new BigDecimal("200"));
        assertEquals(new BigDecimal("300"), myAccount.getBalance(true, true));
    }

    @Test
    public void testOverdrawReturnsBalanceMinusOne(){

        myAccount.deposit(new BigDecimal("100"));
        myAccount.withdrawal(new BigDecimal("200"));
        assertEquals(new BigDecimal("100"), myAccount.getBalance(true, true));
    }

    @Test
    public void testValidateUserMethod(){

        assertTrue(myAccount.validateUser(true, true));
        assertFalse(myAccount.validateUser(false, true));
    }

    @Test
    public void testUpdatePin(){

        myAccount.updatePin(true, true);
        assertTrue(myAccount.validateUser(true, true));
    }
}

