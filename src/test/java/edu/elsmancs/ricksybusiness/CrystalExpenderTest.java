package edu.elsmancs.ricksybusiness;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CrystalExpenderTest {

    @Test
    public void createCrystalExpender() {
        CrystalExpender crystalExpender = new CrystalExpender(20, 500.0);
        assertNotNull(crystalExpender);
        assertEquals(20, crystalExpender.stock(), 0);
    }

    @Test
    public void dispatchCreditCard() {
        CrystalExpender crystalExpender = new CrystalExpender(20, 500.0);
        assertNotNull(crystalExpender);
        CreditCard creditCard = new CreditCard("Julio", "262645486");
        crystalExpender.dispatch(creditCard);
        assertEquals(2500.0, creditCard.credit(), 0);
        assertEquals(19, crystalExpender.stock(), 0);
    }

    @Test
    public void toStringCrystalExpender() {
        CrystalExpender crystalExpender = new CrystalExpender(20, 500.0);
        assertNotNull(crystalExpender);
        assertNotNull(crystalExpender.toString());
    }
}
