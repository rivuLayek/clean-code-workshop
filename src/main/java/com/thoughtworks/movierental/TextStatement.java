package com.thoughtworks.movierental;

import java.util.List;

class TextStatement {

    private final double totalAmount;
    private final int frequentRenterPoints;
    private final List<Rental> rentals;
    private final String name;

    public TextStatement(List<Rental> rentals, double totalAmount, int frequentRenterPoints, String name) {
        this.totalAmount = totalAmount;
        this.frequentRenterPoints = frequentRenterPoints;
        this.rentals = rentals;
        this.name = name;
    }

    public String generate() {
        return header() + body() + footer();
    }

    private String header() {
        return "Rental Record for " + name + "\n";
    }

    private String body() {
        String result = "";
        for (Rental rental : rentals) {
            result += "\t" + rental.getMovie().getTitle() + "\t" +
                    rental.amount() + "\n";
        }
        return result;
    }

    private String footer() {
        String result = "";
        result += "Amount owed is " + totalAmount + "\n";
        result += "You earned " + frequentRenterPoints
                + " frequent renter points";
        return result;
    }
}
