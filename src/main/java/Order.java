import java.util.*;

import static java.lang.Integer.parseInt;

public class Order {
    public Order() {
    }

    private String clientNumber = "";
    private String inProgress = "Ждет обработки";
    private ArrayList<Book> books = new ArrayList();

    public Order(String clientNumber, String inProgress, ArrayList<Book> books) {
        this.clientNumber = clientNumber;
        this.inProgress = inProgress;
        this.books = books;
    }
    public Order(String clientNumber, ArrayList<Book> books) {
        this.clientNumber = clientNumber;
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
    public int hashCode() {

        int rezult = 0;
        for (Book a : books)
        {
            rezult += a.hashCode();
        }
        for(int i = 0; i < clientNumber.length();i++)
        {
            rezult += (int)clientNumber.charAt(i);
        }
        for(int i = 0; i < inProgress.length();i++)
        {
            rezult += (int)inProgress.charAt(i);
        }
        return rezult;
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
        info += (this.clientNumber.toString() + "\n" + this.inProgress.toString() + "\n");
        for (int i = 0; i < books.size(); i++) {
            info += books.get(i).toString();
        }
        return info;
    }

    public static void createOrder(HashSet<Book> baseOfbooks, Order order) {
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
                    Book a = iter.next();
                    if (a.equals(orderBook)) {
                        orderBook.setPrice(a.getPrice());
                        order.setBooks(orderBook);
                        order.setClientNumber(number);
                        System.out.println("Книга по данному запросу найдена!\n" + orderBook.toString());
                        out = true;
                        break;
                    }
                }
                if (out != true) throw (new Exception());
                else break;
            } catch (Exception a) {
               String but;
                while(true) {
                    System.out.println("Некорректные данные! Желаете попробовать снова?(Введите Y/N)");

                    but = scan.nextLine().toUpperCase().trim();
                    if (but.equals("N") || but.equals("Y")) break;
                }
                if (but.equals("N")) break;
            }
        }
    }

    public static void watchOrders( HashMap <String, Order> orders)
    {

        for( Order obj : orders.values())
        {
            System.out.println(obj.toString());
        }
    }

    public static void watchOrders( Map <String, Order> orders, String number)
    {
        for( Order obj : orders.values())
        {
            if(obj.getClientNumber().equals(number))
            System.out.println(obj.toString());
        }
    }
}
