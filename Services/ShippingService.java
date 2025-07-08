package Services;

import java.util.HashMap;

import Abstracts.Book;
import Abstracts.Validator;
import Interfaces.Interfaces.Shippable;

public class ShippingService {

    // private String shippingInfo;
    private StringBuilder shippingDetails;
    private HashMap<Book, Integer> shippableBooks;
    private double totalWeight;
    private double shippingPrice;

    public ShippingService(/* Customer customer, */ HashMap<Book, Integer> shippableBooks) throws IllegalArgumentException { // Might be expaned in future to include customer details
        // this.shippingInfo = customer.getAddress();
        Validator.checkIfEmptyMap(shippableBooks, "Shippable books");

        this.totalWeight = 0;
        this.shippingPrice = 0;
        this.shippableBooks = shippableBooks;
        setBooksWeights();
        generateNotice();
        setShippingPrice();
    }

    public ShippingService(Book shippableBook) throws IllegalArgumentException { // Might be expaned in future to include customer details
        // this.shippingInfo = customer.getAddress();
        Validator.checkIfNull(shippableBook, "Shippable books");

        this.totalWeight = 0;
        this.shippingPrice = 0;
        this.shippableBooks = new HashMap<>();
        shippableBooks.put(shippableBook, 1);
        setBooksWeights();
        generateNotice();
        setShippingPrice();
    }

    public void generateNotice() {
        shippingDetails = new StringBuilder("** Shipment notice **\n");
        for (Book book : shippableBooks.keySet()) {
            shippingDetails.append(shippableBooks.get(book))
                            .append("x ")
                            .append(book.toString())
                            .append(formattedWeight(Shippable.class.cast(book).getWeight() * shippableBooks.get(book)))
                           .append("\n");
        }

        shippingDetails.append("Total package weight:\t").append(formattedWeight(totalWeight));
    }

    public void setBooksWeights() {
        for (Book book : shippableBooks.keySet()) {
            this.totalWeight += Shippable.class.cast(book).getWeight() * shippableBooks.get(book);
        }
    }

    public static HashMap<Book, Integer> getShippableBooks(HashMap<Book, Integer> books) {
        HashMap<Book, Integer> shippableBooks = new HashMap<>();
        for (HashMap.Entry<Book, Integer> entry : books.entrySet()) {
            Book book = entry.getKey();
            if (checkIfShippable(book)) {
                shippableBooks.put(book, entry.getValue());
            }
        }
        return shippableBooks;
    }

    public static boolean checkIfShippable(Book book) {
        return book instanceof Shippable;
    }

    public double getShippingPrice() {
        return shippingPrice;
    }

    public double getTotalWeight() {
        return totalWeight;
    }

    public void setShippingPrice() {
        if (this.totalWeight < 1000) { // Assuming flat rates
            this.shippingPrice = 10;
        } else {
            this.shippingPrice = 20;
        }
    }

    public String formattedWeight(double weight) {
        if (weight < 1000) {
            return String.format("%.2fg", weight);
        } else {
            return String.format("%.2fkg", weight / 1000);
        }
    }

    @Override
    public String toString() {
        return shippingDetails.toString();
    }
    
}
