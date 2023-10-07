package com.thoughtworks.movierental;

import java.util.ArrayList;
import java.util.List;

public class RentalDetails {
    private final List<Rental> rentals = new ArrayList<>();

    public void addRental(Rental arg) {
        rentals.add(arg);
    }

    public int getFrequentRenterPoints() {
        int frequentRenterPoints = 0;
        for (Rental rental : rentals) {
            frequentRenterPoints += rental.renterPoints();
        }
        return frequentRenterPoints;
    }

    public double getTotalAmount() {
        double totalAmount = 0;
        for (Rental rental : rentals) {
            totalAmount += rental.amount();
        }
        return totalAmount;
    }

    public List<Rental> getRentals() {
        return rentals;
    }
}
