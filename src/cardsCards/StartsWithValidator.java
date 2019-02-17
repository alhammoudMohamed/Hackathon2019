package cardsCards;

import java.util.List;

public class StartsWithValidator extends Validator {

    public StartsWithValidator(List<String> possibilities) {
        super(possibilities);
    }

    @Override
    public boolean isValid(String cardNumber) {
        List<String> beginnings = getPossibilities();
        return beginnings.stream()
                .map(e -> e.startsWith(e))
                .anyMatch(Boolean::booleanValue);

    }


}
