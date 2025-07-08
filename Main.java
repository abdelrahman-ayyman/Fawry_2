// Assumptions
/**
 * I assume that Ebooks have quantity as well as an indicator to number of licenses the store has to sell the ebook. If not, an interface might be introducted instead.
 * Assuming DemoBooks are not electronic.
 * Assuming weight is in grams and immutable
 */


import Abstracts.Book;
import Abstracts.BookStore;
import Books.PaperBook;
import Books.EBook;
import Books.DemoBook;
import Abstracts.FileType;

class Main
{
    public static void main(String[] args)
    {
        BookStore bookStore = new BookStore();

        Book OOPHeadFirst = new PaperBook("OOP Head First", "A1234", 2020, true,200.0, 15.0);
        Book HighPerformanceMySQL = new EBook("High Performance MySQL", "A2345", 2023, true, FileType.PDF, 20.0);
        Book DemoBook = new DemoBook("Demo: High Performance MySQL", "A2346", 2023, false,200.0);

        try {
            bookStore.addBookToStock(OOPHeadFirst, 10);
            bookStore.addBookToStock(HighPerformanceMySQL, 15);
            bookStore.addBookToStock(DemoBook, 5);

            bookStore.getStock();

            bookStore.removeBookFromStock(DemoBook, 2);

            bookStore.getStock();

            System.out.println("Total paid: " + bookStore.sellBook( "A2345", 3));

            bookStore.getStock();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}