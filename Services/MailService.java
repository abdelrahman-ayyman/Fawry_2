package Services;

import Abstracts.Book;
import Interfaces.Interfaces.Electronic;

public class MailService {
    public static boolean checkIfMailed(Book book) {
        return book instanceof Electronic;
    }
}
