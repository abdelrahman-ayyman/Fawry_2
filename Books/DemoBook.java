package Books;

import Abstracts.Book;
import Abstracts.Validator;
import Interfaces.Interfaces.Shippable;

// Assuming DemoBooks are not electronic for now. If yes, another class can inherint DemoBooks and implement the Electronic interface. Shippable will be removed as well and added to PaperDemoBook
public class DemoBook extends Book implements Shippable {
    private Double weight;
    public DemoBook(String title, String ISBN, Integer publicationYear, Boolean forSale, Double weight) throws IllegalArgumentException {
        super(title, ISBN, publicationYear, forSale);

        Validator.validateWeight(weight);
        this.weight = weight;
    }

    public Double getWeight() {
        return this.weight;
    }
}
