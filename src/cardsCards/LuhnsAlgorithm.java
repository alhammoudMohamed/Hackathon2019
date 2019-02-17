package cardsCards;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LuhnsAlgorithm {

    public Integer calculate(String cardNumber) {
        List<Integer> digits = getDigits(cardNumber);
        Collections.reverse(digits);
        return accumulate(digits);
    }


    private List<Integer> getDigits(String carNumber) {
        return Stream.of(carNumber)
                .map(e -> e.split(""))
                .flatMap(Stream::of)
                .map(Integer::valueOf)
                .collect(Collectors.toList());
    }


    private Integer accumulate(List<Integer> digits) {
        List<Operator> operators = Arrays.asList(
                new StayOperator(), new MultiplyOperator()
        );

        Integer total = 0;
        for (Integer digit : digits) {
            Operator operator = operators.get(0);
            total = total + operator.operate(digit);
            Collections.rotate(operators, -1);
        }
        return total;
    }


}