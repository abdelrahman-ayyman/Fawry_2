package Abstracts;

import java.time.Year;

public abstract class Book {
    protected String title;
    protected String ISBN;
    protected Year publicationYear;
    protected Boolean forSale;

    public Book(String title, String ISBN, Integer publicationYear, Boolean forSale) throws IllegalArgumentException {
        
        Validator.checkEmptyString(title, "Title");
        Validator.checkEmptyString(ISBN, "ISBN");
        Validator.validatePublicationYear(Year.of(publicationYear));
        Validator.checkIfNull(forSale, "Purchasable");

        this.title = title;
        this.ISBN  = ISBN;
        this.publicationYear = Year.of(publicationYear);
        this.forSale = forSale;
    }

    public String getTitle() {
        return title;
    }

    public String getISBN() {
        return ISBN;
    }

    public Year getPublicationYear() {
        return publicationYear;
    }

    // Assuming publication year and ISBN are immutable
    public void setTitle(String title) {
        Validator.checkEmptyString(title, "Title");
        this.title = title;
    }
    
    public boolean isExpired(Year invalidYear) {
        return publicationYear.isBefore(invalidYear);
    }

    @Override
    public String toString() {
        return title + ", " + publicationYear + " edition\t\t";
    }
}