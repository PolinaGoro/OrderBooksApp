import java.util.*;

public class Main {

    private static String path = "popka.txt";

    public static void main(String[] args) {
        FileManager manager = new FileManager(path);
         HashMap <String, Order> orders = new HashMap<>();
         Order order = new Order();
//
        HashSet<Book> books = manager.getData().getBooks();

        System.out.println("Добрый День!\nВас приветствует консольный книжный магазин.");
        Scanner scan = new Scanner(System.in);
        String opinion = "";
        int i = 0;
        while (i == 0) {
            System.out.println("Выберете нужную опцию:\n1 - просмотреть список книг\n2 - заказать книгу \n3 - просмотреть все заказы\n4 - выйти");
            opinion = scan.nextLine();

            switch (opinion.trim()) {
                case "1":
                    for (Book s : books) {
                        System.out.println("Автор: " + s.getAuthor() + " Название: " + s.getName() + " Цена: " + s.getPrice());
                    }
                    break;
                case "2": Order.createOrder(books,order);
                   orders.put(order.getClientNumber(), order);
                    break;
                case "3": Order.watchOrders(orders);
                    break;
                    case "4":
                    i = 1;break;
                default:
                   break;
            }
        }
        manager.save(path);

    }

}
