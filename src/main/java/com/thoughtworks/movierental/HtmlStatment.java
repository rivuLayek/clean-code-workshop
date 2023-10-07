package com.thoughtworks.movierental;

import java.util.List;

class HtmlStatment {

    private final String name;
    private final List<Rental> rentals;
    private final double totalAmount;
    private final int frequentRenterPoints;

    public HtmlStatment(List<Rental> rentals, double totalAmount, int frequentRenterPoints, String name) {
        this.name = name;
        this.rentals = rentals;
        this.totalAmount = totalAmount;
        this.frequentRenterPoints = frequentRenterPoints;
    }

    public String generate() {
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
                htmlFooter() +
                "</body>\n" +
                "</html>\n";
    }

    private String htmlHeader() {
        return "<h1>Rental Record for <b>" + name + "</b></h1>\n";
    }

    private String htmlBody() {
        String result = "<table>\n";
        for (Rental rental : rentals) {
            result += "<tr>\n<td>" + rental.getMovie().getTitle() + "&emsp;</td>\n<td>" + rental.amount() + "</td>\n</tr>\n";
        }
        return result + "</table>\n";
    }

    private String htmlFooter() {
        return "<div>Amount owed is <b>" + totalAmount + "</b></div>\n" +
                "<div>You earned <b>" + frequentRenterPoints + "</b> frequent renter points</div>\n";
    }
}
