import Abstracts.Book;
import Abstracts.BookStore;
import Abstracts.FileType;
import Books.DemoBook;
import Books.EBook;
import Books.PaperBook;

public class tb {
    BookStore bookStore;
    public tb () {
        bookStore = new BookStore();
    }

    // Adding of books 1
    public void testCase_1() {
        System.out.println("\nAdding books to stock...");
        bookStore.getStock();

        Book OOPHeadFirst = new PaperBook("OOP Head First", "A1234", 2020, true,200.0, 15.0);
        Book HighPerformanceMySQL = new EBook("High Performance MySQL", "A2345", 2023, true, FileType.PDF, 20.0);
        Book DemoBook = new DemoBook("Demo: High Performance MySQL", "A2346", 2023, false,200.0);

        bookStore.addBookToStock(OOPHeadFirst, 10);
        bookStore.addBookToStock(HighPerformanceMySQL, 15);
        bookStore.addBookToStock(DemoBook, 5);

        bookStore.getStock();
    }

    // Adding of books 2
    public void testCase_2() {
        System.out.println("\nAdding null book to stock...");
        bookStore.addBookToStock(null, 10);
        bookStore.getStock();
    }

    // Adding of books 3
    public void testCase_3() {
        System.out.println("\nAdding book with negative quantity to stock...");
        Book DatabaseIntro = new PaperBook("Introduction to DB", "A1258", 2019, true,300.0, 10.0);
        bookStore.addBookToStock(DatabaseIntro, -5);
        bookStore.getStock();
    }

    // selling books 1
    public void testCase_4() {
        System.out.println("\nSelling books 1 (EBook)");
        bookStore.getStock();
        System.out.println("Total paid: " + bookStore.sellElectronicBook("A2345", 3, "abdelrahman.akefafy@gmail.com"));
        bookStore.getStock();
    }

    // selling books 2 (Physical Book)
    public void testCase_6() {
        System.out.println("\nSelling books 2 (Physical Book)");
        bookStore.getStock();
        System.out.println("Total paid: " + bookStore.sellAndShipBook( "A1234", 3));
        bookStore.getStock();
    }

    // selling books 3 (Insufficient stock)
    public void testCase_66() {
        System.out.println("\nSelling books 3 (Insufficient stock)");
        bookStore.getStock();
        System.out.println("Total paid: " + bookStore.sellAndShipBook( "A1234", 30));
        bookStore.getStock();
    }

    // selling books 4 (Missing ISBN)
    public void testCase_5() {
        System.out.println("\nSelling books 3 (Missing ISBN)");
        bookStore.getStock();
        System.out.println("Total paid: " + bookStore.sellBook( "A25", 3));
        bookStore.getStock();
    }

    // Removing books 1
    public void testCase_7() {
        System.out.println("\nRemoving books 1");
        bookStore.getStock();
        Book DemoBook = bookStore.checkBookBYISBN("A2346");
        bookStore.removeBookFromStock(DemoBook, 2);
        bookStore.getStock();
    }

    // Removing books 2
    public void testCase_8() {
        System.out.println("\nRemoving books 2 (Insufficient stock)");
        bookStore.getStock();
        Book DemoBook = bookStore.checkBookBYISBN("A2346");
        bookStore.removeBookFromStock(DemoBook, 200);
        bookStore.getStock();
    }

    // Removing books 3
    public void testCase_9() {
        System.out.println("\nRemoving books 3 (Missing ISBN)");
        Book MissingBook = bookStore.checkBookBYISBN("A46");
        bookStore.getStock();
        bookStore.removeBookFromStock(MissingBook, 20);
        bookStore.getStock();
    }
}
