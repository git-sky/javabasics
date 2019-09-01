package cn.com.sky.basics.clones.lowclone;

public class Book implements Cloneable {

    private String bookName;
    private double price;
    private Person author;

    public Book(String bookName, double price, Person author) {
        this.bookName = bookName;
        this.price = price;
        this.author = author;

    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Person getAuthor() {
        return author;
    }

    public void setAuthor(Person author) {
        this.author = author;
    }

    @Override
    public Book clone() {
        Book b = null;
        try {
            b = (Book) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
//         b.author=(Person)author.clone();
        return b;
    }

    public void display() {
        System.out.println("bookName:" + bookName + ", price:" + price + ", author:" + author.getName() + " " + author.getAge());
    }

}
