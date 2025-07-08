package Books;

import Abstracts.Book;
import Abstracts.FileType;
import Abstracts.Validator;
import Interfaces.Interfaces.Electronic;
import Interfaces.Interfaces.Purchasable;

public class EBook extends Book implements Electronic, Purchasable{
    private Double price;
    private FileType fileType;

    public EBook(String title, String ISBN, Integer publicationYear, Boolean forSale, FileType fileType, Double price) throws IllegalArgumentException {
        super(title, ISBN, publicationYear, forSale);

        Validator.checkIfPositive(price, true, "Price");
        this.price = price;
        this.fileType = fileType;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        Validator.checkIfPositive(price, true, "Price");
        this.price = price;
    }

    public FileType getFileType() {
        return this.fileType;
    }

    public void setFileType(FileType fileType) {
        this.fileType = fileType;
    }
}
