package cardsCards;


import org.junit.jupiter.api.Assertions;

class LuhnsAlgorithmTest {

    private LuhnsAlgorithm algorithm = new LuhnsAlgorithm();

    @org.junit.jupiter.api.Test
    void testCalculate() {
        String number = "378281";
        int checksum = algorithm.calculate(number);
        Assertions.assertEquals(30, checksum);
    }

}