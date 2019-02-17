package cardsCards;

import java.util.Arrays;

public class VisaElectron extends CreditCard {

    public VisaElectron() {
        super(Arrays.asList(

                new StartsWithValidator(Arrays.asList("4026", "417500", " 4508", "4844", "4913", "4917")),
                new LengthValidator(Arrays.asList("16"))
        ));
    }

    @Override
    public String getName() {
        return "cardsCards.VisaElectron";
    }

}




