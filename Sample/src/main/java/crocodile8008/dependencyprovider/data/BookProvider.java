package crocodile8008.dependencyprovider.data;

import java.util.ArrayList;
import java.util.List;

import crocodile8008.dependencyprovider.data.model.Book;
import crocodile8008.dependencyprovider.helpers.Lo;

/**
 * Created by Andrey Riik in 2015
 */
public class BookProvider {

    // test 3Mb data for fast memory-leaks detection
    private final byte[] testPayload = new byte[3000000];

    public BookProvider() {
        Lo.w(getClass().getSimpleName() + " new BookProvider");
    }

    public List<Book> getBooks() {
        List<Book> list = new ArrayList<>();
        list.add(new Book("Book 1", 1954, 293));
        list.add(new Book("Book 2", 1998, 213));
        return list;
    }

}
