package cardsCards;

import java.util.List;

public class LengthValidator extends Validator {

    LengthValidator(List<String> possibilities) {
        super(possibilities);
    }

    @Override
    public boolean isValid(String cardNumber) {
        String length = String.valueOf(cardNumber.length());
        return getPossibilities().contains(length);
    }
}
