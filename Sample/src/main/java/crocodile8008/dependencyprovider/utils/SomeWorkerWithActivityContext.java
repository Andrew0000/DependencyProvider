package crocodile8008.dependencyprovider.utils;

import android.app.Activity;

import java.util.List;

import crocodile8008.dependencyprovider.data.BookProvider;
import crocodile8008.dependencyprovider.data.model.Book;
import crocodile8008.dependencyprovider.helpers.Lo;
import crocodile8008.dlibrary.SingletonContainer;

/**
 * Created by Andrey Riik in 2015
 */
public class SomeWorkerWithActivityContext {

    private final Activity activity;
    private final BookProvider bookProvider;

    // test 3Mb data for fast memory-leaks detection
    private final byte[] testPayload = new byte[3000000];

    public SomeWorkerWithActivityContext(Activity activity) {
        Lo.w(getClass().getSimpleName() + " new SomeWorkerWithActivityContext");
        this.activity = activity;
        bookProvider = SingletonContainer.get(BookProvider.class);
        if (bookProvider == null) {
            throw new IllegalStateException("bookProvider is null");
        }
    }

    public String getBooksString() {
        String result = "";
        List<Book> bookList = bookProvider.getBooks();
        for (Book book : bookList) {
            result += book.name + " (" + book.year + ")\n";
        }
        return result;
    }
}
