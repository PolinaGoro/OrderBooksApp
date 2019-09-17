import java.util.ArrayList;
import java.util.HashSet;

public class Data {

    private HashSet<Book> books = new HashSet<>();
    private ArrayList<Order> orders = new ArrayList<>();

    public HashSet<Book> getBooks() {
        return books;
    }

    public void setBooks(HashSet<Book> books) {
        this.books = books;
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

    public void setOrders(ArrayList<Order> orders) {
        this.orders = orders;
    }
}
