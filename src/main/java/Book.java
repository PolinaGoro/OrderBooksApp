public class Book {
    private String author;
    private String name;
    private int price;

    public Book(String author, String name, int price) {
        this.author = author;
        this.name = name;
        this.price = price;
    }

    public Book(String author, String name) {
        this.author = author;
        this.name = name;
    }

    public Book() {
        this.author = "";
        this.name = "";
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        String info = "";
        info +=  this.author + "/n" + this.name + "/n" + this.price;
        return info;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Book)
        {
            Book other = (Book) obj;
            return (this.name == other.name && this.author == other.author && this.price == other.price);
        }
        return false;
    }
}