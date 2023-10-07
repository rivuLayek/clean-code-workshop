package com.thoughtworks.movierental;

class HtmlStatment {

    private final RentalDetails rentalDetails;
    private final String name;

    public HtmlStatment(RentalDetails rentalDetails, String name) {
        this.rentalDetails = rentalDetails;
        this.name = name;
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
        for (Rental rental : rentalDetails.getRentals()) {
            result += "<tr>\n<td>" + rental.getMovie().getTitle() + "&emsp;</td>\n<td>" + rental.amount() + "</td>\n</tr>\n";
        }
        return result + "</table>\n";
    }

    private String htmlFooter() {
        return "<div>Amount owed is <b>" + rentalDetails.getTotalAmount() + "</b></div>\n" +
                "<div>You earned <b>" + rentalDetails.getFrequentRenterPoints() + "</b> frequent renter points</div>\n";
    }
}
