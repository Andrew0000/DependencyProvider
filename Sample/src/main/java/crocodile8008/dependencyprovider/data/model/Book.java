package crocodile8008.dependencyprovider.data.model;

/**
 * Created by Andrey Riik in 2015
 */
public class Book {

    public final String name;
    public final int year;
    public final int pagesCnt;

    public Book(String name, int year, int pagesCnt) {
        this.name = name;
        this.year = year;
        this.pagesCnt = pagesCnt;
    }
}
