package cardsCards;

import java.time.LocalDate;
import java.time.YearMonth;

public class CreditCardInformation {


    private LocalDate dateOfPayment;
    private Integer creditCardNumber;
    private Double amountPaid;
    private String issuer;

    public CreditCardInformation(LocalDate dateOfPayment, Integer creditCardNumber, Double amountPaid, String issuer) {
        this.dateOfPayment = dateOfPayment;
        this.creditCardNumber = creditCardNumber;
        this.amountPaid = amountPaid;
        this.issuer = issuer;
    }

    public Integer getCreditCardNumber() {
        return creditCardNumber;
    }


    public LocalDate getDateOfPayment() {
        return dateOfPayment;
    }

    public YearMonth getYearMonth() {
        return YearMonth.from(dateOfPayment);
    }


    public Double getAmountPaid() {
        return amountPaid;
    }


    @Override
    public String toString() {
        return "CreditCardInformation{" +
                "dateOfPayment='" + dateOfPayment + '\'' +
                ", creditCardNumber=" + creditCardNumber +
                ", amountPaid=" + amountPaid +
                '}';
    }

    public String getIssuer() {
        return issuer;
    }


    public String toCSV() {
        return dateOfPayment + ", " + creditCardNumber + ", " + issuer + ", " + amountPaid;
    }
}