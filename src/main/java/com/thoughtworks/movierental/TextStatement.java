package com.thoughtworks.movierental;

class TextStatement {

    private final RentalDetails rentalDetails;
    private final String name;

    public TextStatement(RentalDetails rentalDetails, String name) {
        this.rentalDetails = rentalDetails;
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
        for (Rental rental : rentalDetails.getRentals()) {
            result += "\t" + rental.getMovie().getTitle() + "\t" +
                    rental.amount() + "\n";
        }
        return result;
    }

    private String footer() {
        String result = "";
        result += "Amount owed is " + rentalDetails.getTotalAmount() + "\n";
        result += "You earned " + rentalDetails.getFrequentRenterPoints()
                + " frequent renter points";
        return result;
    }
}
