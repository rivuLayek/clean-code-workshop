package com.thoughtworks.movierental;

public class Customer {
    private final String name;
    private final RentalDetails rentalDetails;

    public Customer(String name, RentalDetails rentalDetails) {
        this.name = name;
        this.rentalDetails = rentalDetails;
    }

    public String getName() {
        return name;
    }

    public String statement() {
        return new TextStatement(rentalDetails, getName()).generate();
    }

    public String htmlStatement() {
        return new HtmlStatment(rentalDetails, getName()).generate();
    }



}
