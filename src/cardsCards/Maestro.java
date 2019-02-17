package cardsCards;

import java.util.Arrays;

public class Maestro extends CreditCard {

    public Maestro() {
        super(Arrays.asList(
                new LengthValidator(Arrays.asList("19","16")),
                new StartsWithValidator(Arrays.asList("67", "63"))
        ));
    }

    @Override
    public String getName() {
        return "Maestro";
    }

}
