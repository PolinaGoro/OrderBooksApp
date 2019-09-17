import java.util.ArrayList;

public class Order {
    private String clientNumber = "";
    private String inProgress = "";
    private ArrayList<Book> books = new ArrayList();

    public Order(String inProgress, ArrayList<Book> books) {
        this.inProgress = inProgress;
        this.books = books;
    }

    public Order(String clientNumber, String inProgress, ArrayList<Book> books) {
        this.clientNumber = clientNumber;
        this.inProgress = inProgress;
        this.books = books;
    }

    public String getClientNumber() {
        return clientNumber;
    }

    public void setClientNumber(String clientNumber) {
        this.clientNumber = clientNumber;
    }

    public String getInProgress() {
        return inProgress;
    }

    public void setInProgress(String inProgress) {
        this.inProgress = inProgress;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }

    public void Order ()
    {

    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Order)
        {
            Order other = (Order) obj;
            return this.books == other.books && this.clientNumber.equals(other.clientNumber) && this.inProgress.equals(other.inProgress);
        }
        return false;
    }

    @Override
    public String toString() {
        String info = "";
        info += (this.clientNumber.toString() + this.inProgress.toString());
        for (int i = 0; i < books.size(); i++)
        {
            info += books.get(i).toString();
        }
        return info;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
