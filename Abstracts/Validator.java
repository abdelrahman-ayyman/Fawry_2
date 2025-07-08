package Abstracts;
import java.time.Year;
import java.util.Collection;
import java.util.Map;

public class Validator {

    public static void checkIfNull(Object value, String property) throws IllegalArgumentException{
        if (value == null) {
            throw new IllegalArgumentException(property + " cannot be null.");
        }
    }

    public static void checkIfEmptyList(Collection<?> value, String property) throws IllegalArgumentException{ // For lists
        checkIfNull(value, property);
        if (value.isEmpty()) {
            throw new IllegalArgumentException(property + " cannot be empty.");
        }
    }

    public static void checkIfEmptyMap(Map<?, ?> map, String property) throws IllegalArgumentException{
    checkIfNull(map, property);
    if (map.isEmpty()) {
        throw new IllegalArgumentException(property + " cannot be empty.");
    }
}
    
    public static void checkEmptyString(String value, String property) throws IllegalArgumentException{
        checkIfNull(value, property);
        if (value.isEmpty()) {
            throw new IllegalArgumentException(property + " cannot be empty.");
        }
    }

    public static void checkIfPositive(Double value, boolean zeroIncluded, String property) throws IllegalArgumentException {
        checkIfNull(value, property);

        if (zeroIncluded && value < 0) {
            throw new IllegalArgumentException(property + " must be greater than or equal to zero.");
        } else if (value <= 0) {
            throw new IllegalArgumentException(property + " must be greater than zero.");
        }
    }

    public static void checkIfNegative(Double value, boolean zeroIncluded, String property) throws IllegalArgumentException {
        checkIfNull(value, property);

        if (zeroIncluded && value > 0) {
            throw new IllegalArgumentException(property + " must be less than or equal to zero.");
        } else if (value >= 0) {
            throw new IllegalArgumentException(property + " must be less than zero.");
        }
    }

    public static void validateEmail(String email) throws IllegalArgumentException{
        checkIfNull(email, "Email");
        if (!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
            throw new IllegalArgumentException("Invalid email format.");
        }
    }

    public static void validateAmount(int amount, int currentAmount, boolean isAddition) throws IllegalArgumentException {
        checkIfPositive(Double.valueOf(amount), true, "Amount");
        if (!isAddition && amount > currentAmount) {
            throw new IllegalArgumentException("Amount to remove must be between 0 and " + currentAmount + ".");
        }
    }

    public static void validateWeight(Double weight) throws IllegalArgumentException {
        checkIfNull(weight, "Weight");
        checkIfPositive(weight, false, "Weight");
    }

    public static void validatePublicationYear(Year publicationYear) throws IllegalArgumentException {
        checkIfNull(publicationYear, "Publication year");
        if (publicationYear.isAfter(Year.now())) {
            throw new IllegalArgumentException("Publication year must be in the future.");
        }
    }
}