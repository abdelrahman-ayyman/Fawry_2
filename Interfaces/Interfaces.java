package Interfaces;

import Abstracts.FileType;
public class Interfaces {
    public interface Shippable {
        // Assuming weight is in grams and immutable
        Double getWeight();
    }

    // Not included in showcase books
    public interface Purchasable {
        Double getPrice();
        void setPrice(Double price);
    }

    // Assuming demo books can be physical or electronic in future updates
    public interface Electronic {
        FileType getFileType();
        void setFileType(FileType fileType);
    }

}