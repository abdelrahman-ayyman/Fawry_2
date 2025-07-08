package Books;

import Abstracts.Book;
import Abstracts.Validator;
import Interfaces.Interfaces.Purchasable;
import Interfaces.Interfaces.Shippable;

public class PaperBook extends Book implements Shippable, Purchasable {
    private Double weight;
    private Double price;

    public PaperBook(String title, String ISBN, Integer publicationYear, Boolean forSale, Double weight, Double price) throws IllegalArgumentException {
        super(title, ISBN, publicationYear, forSale);

        Validator.validateWeight(weight);
        Validator.checkIfPositive(price, true, "Price");
        this.weight = weight;
        this.price = price;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        Validator.checkIfPositive(price, true, "Price");
        this.price = price;
    }

    public Double getWeight() {
        return this.weight;
    }
}
