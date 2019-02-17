package cardsCards;

import java.time.YearMonth;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BusinessQuestions {


    public static double getTotalAmount(List<CreditCardInformation> paymentOperations) {
        return paymentOperations.stream()
                .mapToDouble(CreditCardInformation::getAmountPaid)
                .sum();
    }

    public static Map<YearMonth, Double> getGroupSumByMonth(List<CreditCardInformation> paymentOperations) {
        return paymentOperations.stream()
                .collect(Collectors.groupingBy(CreditCardInformation::getYearMonth, Collectors.summingDouble(CreditCardInformation::getAmountPaid)));
    }

    public static Map.Entry<YearMonth, Double> getMostProfitableMonth(List<CreditCardInformation> paymentOperations) {
        return getGroupSumByMonth(paymentOperations).entrySet().stream()
                .max(Comparator.comparingDouble(Map.Entry::getValue))
                .get();

    }

    public static double getAverageAmountPerMonth(List<CreditCardInformation> paymentOperations) {
        return getTotalAmount(paymentOperations) / getNumberOfMonths(paymentOperations);
    }

    public static Map.Entry<String, Long> getMostUsedIssuer(List<CreditCardInformation> paymentOperations) {
        return paymentOperations.stream()
                .collect(Collectors.groupingBy(CreditCardInformation::getIssuer, Collectors.counting()))
                .entrySet()
                .stream()
                .max(Comparator.comparingLong(Map.Entry::getValue))
                .get();
    }

    public static int getNumberOfMonths(List<CreditCardInformation> paymentOperations) {
        return paymentOperations.stream()
                .map(CreditCardInformation::getYearMonth)
                .collect(Collectors.toSet())
                .size();
    }

}
