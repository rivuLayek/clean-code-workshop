package com.thoughtworks.movierental;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private final String name;
    private final List<Rental> rentals = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental arg) {
        rentals.add(arg);
    }

    public String getName() {
        return name;
    }

    public String statement() {
        return header() + body() + footer();
    }

    public String htmlStatement() {
        return "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\" />\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />\n" +
                "    <title>Document</title>\n" +
                "</head>\n" +
                "<body>\n" +
                htmlHeader() +
                htmlBody() +
                htmlFooter()+
                "</body>\n" +
                "</html>\n";
    }

    private String htmlFooter() {
        return "<div>Amount owed is <b>" + getTotalAmount()+ "</b></div>\n" +
                "<div>You earned <b>" + getFrequentRenterPoints() +"</b> frequent renter points</div>\n";
    }

    private String htmlBody() {
        String result = "<table>\n";
        for( Rental rental : rentals ) {
            result += "<tr>\n<td>" + rental.getMovie().getTitle() + "&emsp;</td>\n<td>" + rental.amount() + "</td>\n</tr>\n";
        }
        return result + "</table>\n";
    }

    private String htmlHeader() {
        return "<h1>Rental Record for <b>"+ getName() +"</b></h1>\n";
    }

    private String footer() {
        String result = "";
        double totalAmount = getTotalAmount();
        int totalFrequentRenterPoints = getFrequentRenterPoints();
        result += "Amount owed is " + totalAmount + "\n";
        result += "You earned " + totalFrequentRenterPoints
                + " frequent renter points";
        return result;
    }

    private String body() {
        String result = "";
        for (Rental rental : rentals) {
            result += "\t" + rental.getMovie().getTitle() + "\t" +
                    rental.amount() + "\n";
        }
        return result;
    }

    private String header() {
        return "Rental Record for " + getName() + "\n";
    }

    private int getFrequentRenterPoints() {
        int frequentRenterPoints = 0;
        for (Rental rental : rentals) {
                frequentRenterPoints += rental.renterPoints();
            }
        return frequentRenterPoints;
    }

    private double getTotalAmount() {
        double totalAmount = 0;
        for (Rental rental : rentals) {
            totalAmount += rental.amount();
        }
        return totalAmount;
    }
}
