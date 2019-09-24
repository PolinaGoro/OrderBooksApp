import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Order {
    public Order() {
    }

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
    public void setBooks(Book book)
    {
        this.books.add(book);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Order) {
            Order other = (Order) obj;
            return this.books == other.books && this.clientNumber.equals(other.clientNumber) && this.inProgress.equals(other.inProgress);
        }
        return false;
    }

    @Override
    public String toString() {
        String info = "";
        info += (this.clientNumber.toString() + this.inProgress.toString());
        for (int i = 0; i < books.size(); i++) {
            info += books.get(i).toString();
        }
        return info;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    public static void createOrder(HashSet<Book> baseOfbooks, Order order) {
        //System.out.println("");
        Scanner scan = new Scanner(System.in);

        while (true) {

            try {
                System.out.println("Введите номер телефона: ");
                String number = scan.nextLine();

                if (number.length() < 13 ) {
                    parseInt(number);
                } else throw new Exception();

                System.out.println("Введите автора книги: ");
                String author = scan.nextLine();

                System.out.println("Произведения данного автора: ");
               /* for (Iterator<Book> it = baseOfbooks.iterator(); it.hasNext(); ) {
                    Book searchPoint = it.next();
                    if (searchPoint.getAuthor() == author) {
                       if (searchPoint.getAuthor() == author) {
                        System.out.println(searchPoint.toString());
                        }
                    }
                }*/
                for (Book s : baseOfbooks) {
                    if(s.getAuthor().equals(author))
                    {
                        System.out.println("Автор: " + s.getAuthor() + " Название: " + s.getName() + " Цена: " + s.getPrice());
                    }
                }

                System.out.println("А теперь введите название: ");
                String name = scan.nextLine();
                Book orderBook = new Book(author, name);
                Iterator <Book> iter = baseOfbooks.iterator();
                boolean out = false;
                while (iter.hasNext()) {
                    if (iter.next().equals(orderBook)) {
                        System.out.println("Книга по данному запросу найдена!\n" + orderBook.toString());
                       order.setBooks(orderBook);
                        out = true;
                        break;
                    }
                }
                if (out != true) throw (new Exception());
                else break;
            } catch (Exception a) {
                System.out.println("Некорректные данные! Желаете попробовать снова?(Введите Y/N)");

                String but = scan.nextLine();
                if (but.equals("N")) break;
            }
        }
    }
}
