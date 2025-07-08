package Abstracts;

import java.time.Year;
import java.util.HashMap;
import java.util.Vector;

import Interfaces.Interfaces.Purchasable;
import Services.MailService;
import Services.ShippingService;

// BookStore will be considered the Management Tool. It will be as the responsible for the coordination of inventory, shipping, and selling 
public class BookStore {
    private Inventory stock;
    private ShippingService shipper;
    private MailService emailSender;
    // private static BookStore BookStoreInstance;

    public BookStore() {
        this.stock = new Inventory();
    }

    // public BookStore getBookStore() {
    //     // Singleton pattern
    //     if (BookStoreInstance != null) {
    //         return BookStoreInstance;
    //     }
    //     BookStoreInstance = new BookStore();
    //     return BookStoreInstance;
    // }

    // Selling
    public double sellBook(String ISBN, int quantity)
    {
        double shippingPrice = 0;
        double totalPrice = 0;
        Book requestedBook = stock.getBookByISPN(ISBN);

        // Initiate shipping service if there are shippable products
        if (ShippingService.checkIfShippable(requestedBook)) {
            initiateShippingService(requestedBook);
            shippingPrice = shipper.getShippingPrice();
            totalPrice += shippingPrice;
        }

        if (requestedBook instanceof Purchasable)
        {
            totalPrice += ((Purchasable) requestedBook).getPrice() * quantity;
        }

        // Update inventory
        stock.removeBook(requestedBook, quantity);

        return totalPrice;
    }

    public double sellElectronicBook(String ISBN, int quantity, String email) {
        Book requestedBook = stock.getBookByISPN(ISBN);
        
        // Initiate shipping service if there are electronic products
        if (MailService.checkIfMailed(requestedBook)) {
            initiateEmailingService(requestedBook, email);
        }

        return sellBook(ISBN, quantity);
    }

    // Shipping
    private void initiateShippingService(HashMap<Book, Integer> shippableProducts) {
        Validator.checkIfEmptyMap(shippableProducts, "Shippable books");
        this.shipper = new ShippingService(shippableProducts);
    }

    private void initiateShippingService(Book shippableBook) {
        Validator.checkIfNull(shippableBook, "Shippable books");
        this.shipper = new ShippingService(shippableBook);
    }

    // Email service
    private void initiateEmailingService(HashMap<Book, Integer> mailingPacket, String email) {
        Validator.checkIfEmptyMap(mailingPacket, "Shippable books");
        this.emailSender = new MailService();
    }

    private void initiateEmailingService(Book mailingPacket, String email) {
        Validator.checkIfNull(mailingPacket, "Shippable books");
        this.emailSender = new MailService();
    }

    // Stock
    public void getStock()
    {
        System.out.println(stock);
    }

    public void addBookToStock(Book book, int quantity) {
        stock.addBook(book, quantity);
    }

    public void removeBookFromStock(Book book, int quantity) {
        stock.removeBook(book, quantity);
    }

    public void removeBooks(HashMap<Book, Integer> books) {
        stock.removeBooks(books);
    }

    public Vector<Book> cleanStock(Year invalidYear) {
        return stock.cleanInventory(invalidYear);
    }
    
}
