package com.thoughtworks.movierental;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CustomerTest {

    @Test
    public void checkStatementWhenEachMovieRentedFor5Days() {
        Movie firstMovie = new Movie("Asteroid City",Movie.NEW_RELEASE);
        Movie secondMovie = new Movie("Spidey Verse",Movie.CHILDREN);
        Movie thirdMovie = new Movie("DDLJ",Movie.REGULAR);

        Rental firstRental = new Rental(firstMovie,5);
        Rental secondRental = new Rental(secondMovie,5);
        Rental thirdRental = new Rental(thirdMovie,5);

        Customer customer = new Customer("Virat Kohli");
        customer.addRental(firstRental);
        customer.addRental(secondRental);
        customer.addRental(thirdRental);

        String actualResponse = customer.statement();
        String expectedResponse = "Rental Record for Virat Kohli\n" +
                "\tAsteroid City\t15.0\n" +
                "\tSpidey Verse\t4.5\n" +
                "\tDDLJ\t6.5\n" +
                "Amount owed is 26.0\n" +
                "You earned 4 frequent renter points";
        assertEquals(actualResponse, expectedResponse);
    }

    @Test
    public void checkStatementWhenEachMovieRentedFor2Days() {
        Movie firstMovie = new Movie("Asteroid City",Movie.NEW_RELEASE);
        Movie secondMovie = new Movie("Spidey Verse",Movie.CHILDREN);
        Movie thirdMovie = new Movie("DDLJ",Movie.REGULAR);

        Rental firstRental = new Rental(firstMovie,2);
        Rental secondRental = new Rental(secondMovie,2);
        Rental thirdRental = new Rental(thirdMovie,2);

        Customer customer = new Customer("Virat Kohli");
        customer.addRental(firstRental);
        customer.addRental(secondRental);
        customer.addRental(thirdRental);

        String actualResponse = customer.statement();
        String expectedResponse = "Rental Record for Virat Kohli\n" +
                "\tAsteroid City\t6.0\n" +
                "\tSpidey Verse\t1.5\n" +
                "\tDDLJ\t2.0\n" +
                "Amount owed is 9.5\n" +
                "You earned 4 frequent renter points";
        assertEquals(actualResponse, expectedResponse);
    }
}