package edu.elsmancs.ricksybusiness;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CreditCardTest {

    @Test
    public void createCreditCard() {
        CreditCard creditCard = new CreditCard("Julio", "262645486");
        assertNotNull(creditCard);
        assertEquals(3000.0, creditCard.credit(), 0);
    }

    @Test
    public void payCreditCard() {
        CreditCard creditCard = new CreditCard("Julio", "262645486");
        assertNotNull(creditCard);
        creditCard.pay(2000.0);
        assertEquals(1000.0, creditCard.credit(), 0);
    }

    @Test
    public void gettersCreditCard() {
        CreditCard creditCard = new CreditCard("Julio", "262645486");
        assertNotNull(creditCard);
        creditCard.pay(2000.0);
        assertEquals(creditCard.number(), "262645486");
    }
}

