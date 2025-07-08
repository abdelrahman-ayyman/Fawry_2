package Abstracts;

import java.time.Year;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

public class Inventory {
    private HashMap<Book, Integer> bookStock;

    public Inventory() {
        bookStock = new HashMap<>();
    }

    public void addBook(Book book, int quantity) throws IllegalArgumentException {
        Validator.checkIfNull(book, "Book");
        Validator.validateAmount(quantity, 0, true);
        bookStock.put(book, bookStock.getOrDefault(book, 0) + quantity);
    }
    
    public void removeBook(Book book, int quantity) throws IllegalArgumentException {
        if (bookStock.get(book) == null) {
            throw new IllegalArgumentException("The book is not found.");
        } else {
            Validator.checkIfNull(book, "Book");
            Validator.validateAmount(quantity, bookStock.getOrDefault(book, 0), false);
            bookStock.put(book, bookStock.get(book) - quantity);
        }
    }

    public void removeBooks(HashMap<Book, Integer> books) throws IllegalArgumentException {
        for (Map.Entry<Book, Integer> entry : books.entrySet()) {
            Book book = entry.getKey();
            int quantity = entry.getValue();
            removeBook(book, quantity);
        }
    }

    public Book getBookByISPN(String ISBN) {
        Validator.checkEmptyString(ISBN, "ISBN");
        for (Map.Entry<Book, Integer> entry : bookStock.entrySet())
        {
            Book book = entry.getKey();
            if (book.getISBN() == ISBN)
            {
                return book;
            }
        }
        throw new IllegalArgumentException("Sorry, ISBN is not found.");
    }

    public void checkAvailabilityByISBN(String ISBN, int requestedQuantity) {
        Book requestedBook = getBookByISPN(ISBN);
        int availableQuantity = getBookQuantity(requestedBook);
        if (availableQuantity < requestedQuantity) {
            throw new IllegalArgumentException("Insufficient stock for " + requestedBook.getTitle() + ". Available: " + availableQuantity + ", Requested: " + requestedQuantity);
        }
        throw new IllegalArgumentException("Sorry, ISBN is not found.");
    }

    public int getBookQuantity(Book book) {
         Validator.checkIfNull(book, "Book");
        return bookStock.getOrDefault(book, 0);
    }

    public void checkAvailability(HashMap<Book, Integer> books) throws IllegalArgumentException {
        for (Map.Entry<Book, Integer> entry : books.entrySet()) {
            Book book = entry.getKey();
            int requestedQuantity = entry.getValue();
            int availableQuantity = getBookQuantity(book);
            if (availableQuantity < requestedQuantity) {
                System.out.println(this);
                throw new IllegalArgumentException("Insufficient stock for " + book.getTitle() + ". Available: " + availableQuantity + ", Requested: " + requestedQuantity);
            }
        }
    }

    public Vector<Book> getExpiringBooks(HashMap<Book, Integer> books, Year invalidYear) throws IllegalArgumentException {
        Vector<Book> expiredBooks = new Vector<Book>();
        for (Map.Entry<Book, Integer> entry : books.entrySet()) {
            Book book = entry.getKey();
            if (book.isExpired(invalidYear)) {
                expiredBooks.add(book);
            }
        }
        return expiredBooks;
    }

    public Vector<Book> cleanInventory(Year invalidYear) {
        Vector<Book> expiredBooks = getExpiringBooks(bookStock, invalidYear);
        for (Book book : expiredBooks) {
            bookStock.remove(book);
        }
        return expiredBooks;
    }

    @Override
    public String toString() {
        StringBuilder inventoryDetails = new StringBuilder("Inventory:\n");
        for (Map.Entry<Book, Integer> entry : bookStock.entrySet()) {
            inventoryDetails.append("Book: ").append(entry.getKey().getTitle())
                            .append(", Quantity: ").append(entry.getValue()).append("\n");
        }
        return inventoryDetails.toString();
    }
}
