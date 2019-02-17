package cardsCards;

import cardsCards.FilleInformation.FileWriter;

import java.time.YearMonth;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class IntellegentQuestionsWriter {


    public static void writeBusinessIntelligenceReport(List<CreditCardInformation> paymentOperations, String filePath) {
        double totalAmount = BusinessQuestions.getTotalAmount(paymentOperations);

        Map.Entry<YearMonth, Double> mostProfitableMonth = BusinessQuestions.getMostProfitableMonth(paymentOperations);

        double averagePaidAmountPerMonth = BusinessQuestions.getAverageAmountPerMonth(paymentOperations);

        Map.Entry<String, Long> mostUsedCreditCardIssuer = BusinessQuestions.getMostUsedIssuer(paymentOperations);

        List<String> resultLines = new ArrayList<>();
        resultLines.add("The total is " + totalAmount);
        resultLines.add("The most profitable month is " + getNameOfMonth(mostProfitableMonth.getKey()) + " with a total of " + mostProfitableMonth.getValue());
        resultLines.add("The average amount per month is " + averagePaidAmountPerMonth);
        resultLines.add("The most used issuer is " + mostUsedCreditCardIssuer.getKey() + " was used " + mostUsedCreditCardIssuer.getValue() + " times");

        System.out.println(String.join("\n", resultLines));

        FileWriter.write(resultLines, filePath);
    }

    private static String getNameOfMonth(YearMonth yearMonth) {
        return yearMonth.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
    }
}
