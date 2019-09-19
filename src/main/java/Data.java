import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Data {

    private HashSet<Book> books = new HashSet<>();
    private HashMap<String,Order> orders = new HashMap<>();

    public HashSet<Book> getBooks() {
        return books;
    }

    public void setBooks(HashSet<Book> books) {
        this.books = books;
    }

    public HashMap<String,Order> getOrders() {
        return orders;
    }

    public void setOrders(HashMap<String,Order> orders) {
        this.orders = orders;
    }
}
