package cardsCards.FilleInformation;

import cardsCards.CreditCardInformation;

import java.util.List;
import java.util.stream.Collectors;

public class PaymentInformation {


    public static void writeCSV(List<CreditCardInformation> paymentOperations, String filePath) {
        List<String> csvLines = paymentOperations.stream().map(CreditCardInformation::toCSV).collect(Collectors.toList());

        System.out.println(String.join("\n", csvLines));

        csvLines.add(0, "Date, Credit-Card-Number, Credit-Card-Issuer, Amount-Paid");
        FileWriter.write(csvLines, filePath);
    }
}
