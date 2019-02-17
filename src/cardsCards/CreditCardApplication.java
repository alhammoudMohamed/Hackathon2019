package cardsCards;

import cardsCards.FilleInformation.PaymentInformation;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CreditCardApplication {


    public static void main(String[] args) {

        FileReader fileReader = new FileReader();

        List<String> lines = fileReader.asList("cardsCards/buterfly-business.txt");

        List<String> parsedLines = IntStream.iterate(0, i -> i + 3).limit(lines.size() / 3)
                .mapToObj(i -> {
                    return translateStrangeDigits(lines, i);
                })
                .collect(Collectors.toList());

        List<CreditCardInformation> paymentOperations = getPaymentOperations(parsedLines);

        paymentOperations.forEach(CreditCardInformation::getIssuer);

        paymentOperations.sort(Comparator.comparing(CreditCardInformation::getDateOfPayment));

        createDir("output");

        PaymentInformation.writeCSV(paymentOperations, "output/Payments.csv");

        IntellegentQuestionsWriter.writeBusinessIntelligenceReport(paymentOperations, "output/Report.txt");
    }

    private static void createDir(String filePath) {
        try {
            Path dir = Paths.get(filePath);
            if (!Files.exists(dir))
                Files.createDirectory(dir);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String translateStrangeDigits(List<String> lines, int i) {
        List<String> partition0 = partition(lines.get(i), 3);
        List<String> partition1 = partition(lines.get(i + 1), 3);
        List<String> partition2 = partition(lines.get(i + 2), 3);

        List<String> strangeList = IntStream.range(0, partition0.size())
                .mapToObj(index -> partition0.get(index) + partition1.get(index) + partition2.get(index))
                .collect(Collectors.toList());

        return strangeList.stream()
                .map(LcdConverter.strangeDigits::get)
                .collect(Collectors.joining());
    }

    private static List<CreditCardInformation> getPaymentOperations(List<String> parts) {
        return parts.stream()
                .map(line -> line.split(" "))
                .map(columns -> new CreditCardInformation(
                        LocalDate.parse(
                                columns[0]),
                        Integer.valueOf(columns[1]),
                        Double.valueOf(columns[2]),
                columns[3]))
                .collect(Collectors.toList());
    }

    private static List<String> partition(String line, int size) {
        return IntStream.iterate(0, i -> i + size).limit(line.length() / size)
                .mapToObj(index -> line.substring(index, index + size))
                .collect(Collectors.toList());
    }


}