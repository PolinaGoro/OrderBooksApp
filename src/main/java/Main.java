import java.util.*;

public class Main {

    private static String path = "popka.txt";

    public static void main(String[] args) {
        FileManager manager = new FileManager(path);
        //Data data = new Data();
         Map <String, Order> orders = new HashMap<>();
         Order order = new Order();
//        manager.getData().getBooks().add(new Book("Author 1", "Vasya 1"));
      /*  manager.getData().getBooks().add(new Book("Author 1", "Vasya 1"));
        manager.getData().getBooks().add(new Book("Author 2", "Vasya 2"));
        manager.getData().getBooks().add(new Book("Author 3", "Vasya 3"));
        manager.getData().getBooks().add(new Book("Author 1", "Vasya 1111"));
        manager.getData().getBooks().add(new Book("Author 2", "Vasya 22222"));
        manager.getData().getBooks().add(new Book("Author 2", "Vasya 333333"));
        */
      //manager.getData().getOrders().add(new Order("7788", "in progress", new ArrayList<>()));
        HashSet<Book> books = manager.getData().getBooks();

        System.out.println("Добрый День!\nВас приветствует консольный книжный магазин.");
        Scanner scan = new Scanner(System.in);
        String opinion = "";
        Integer i = new Integer(0);
        while (i == 0) {
            System.out.println("Выберете нужную опцию:\n1 - просмотреть список книг\n2 - заказать книгу \n3 - выйти");
            opinion = scan.nextLine();

            switch (opinion) {
                case "1":
                    for (Book s : books) {
                        System.out.println("Автор: " + s.getAuthor() + " Название: " + s.getName() + " Цена: " + s.getPrice());
                    }
                    break;
                case "2": Order.createOrder(books,order);
                    break;
                case "3":
                    i = 1;break;
                default:
                    i = 1;
                    break;
            }
        }
        manager.save(path);

    }

}
