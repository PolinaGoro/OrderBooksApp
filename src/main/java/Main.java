import java.util.*;

public class Main {

    private static String path = "popka.txt";

    public static void main(String[] args) {
        FileManager manager = new FileManager(path);
        //Data data = new Data();
        HashSet <Book> books = new HashSet<Book>();
        books = manager.getData().getBooks();
        Iterator <Book> iter = books.iterator();
        while(iter.hasNext())
        {
            System.out.println(iter.next().getAuthor() + iter.next().getName() + iter.next().getPrice());
        }

        HashMap<String, Order> arrayOrders = new HashMap<>();


        //manager.getData().getBooks().add(new Book("Author 13", "Vasya 3"));

        //manager.getData().getOrders().add(new Order("7788", "in progress", new ArrayList<>()));
        manager.save(path);

        System.out.println("Добрый День!\nВас приветствует консольный книжный магазин.\nВыберете нужную опцию:");
        System.out.println("1 - просмотреть список книг\n2 - заказать книгу \n3 - выйти");
        Scanner scan = new Scanner(System.in);
        String opinion = "";
        opinion = scan.nextLine();
        Integer i = new Integer(0);
        while(i == 0)
        {
        switch(opinion)
        {
            case "1":
                break;
            case "2": break;
            case "3": System.exit(0); break;
            default:  i = 1;
        }
        }
    }

}
