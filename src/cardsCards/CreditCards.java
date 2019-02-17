package cardsCards;


import java.util.Arrays;
import java.util.List;

public class CreditCards {

    private static List<CreditCard> creditCards = Arrays.asList(
            new AmericanExpress(),
            new Maestro(),
            new VisaElectron(),
            new Discover(),
            new InstaPayment()
    );

    public static String getCreditCard(String cardNumber) {
        return creditCards.stream()
                .filter(creditCard -> creditCard.isValid(cardNumber))
                .findFirst()
                .map(creditCard -> creditCard.getName())
                .orElse("Unknown");
    }
}
