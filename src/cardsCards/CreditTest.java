package cardsCards;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CreditTest {

    private Credit credit = new Credit();

    @Test
    void testAmericanExpress() {
        Long number = 378282246310005L;
        String creditCard = credit.getType(number);
        Assertions.assertEquals("American Express", creditCard);
    }

    @Test
    void testMaestro() {
        Long number = 6304507658064955L;
        String creditCard = credit.getType(number);
        Assertions.assertEquals("Maestro", creditCard);
    }

    @Test
    void visaElectron() {
        Long number = 4913887400644462L;
        String creditCard = credit.getType(number);
        Assertions.assertEquals("cardsCards.VisaElectron", creditCard);
    }

    @Test
    void testInvalid() {
        Long number = 4509671981460741L;
        String creditCard = credit.getType(number);
        Assertions.assertEquals("INVALID", creditCard);
    }

    @Test
    void testInstaPayment() {
        Long number = 6391611587726074L;
        String creditCard = credit.getType(number);
        Assertions.assertEquals("InstaPayment", creditCard);
    }

    @Test
    void testDiscover() {
        Long number = 6229241541591768L;
        String creditCard = credit.getType(number);
        Assertions.assertEquals("Discover", creditCard);
    }
}