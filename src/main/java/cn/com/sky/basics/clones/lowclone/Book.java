package cn.com.sky.basics.clones.lowclone;

public class Book implements Cloneable {
	String bookName;
	double price;
	Person author;

	public Book(String bn, double price, Person author) {
		this.bookName = bn;
		this.price = price;
		this.author = author;

	}

	public Book clone() {
		Book b = null;
		try {
			b = (Book) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		// b.author=(Person)author.clone();
		return b;
	}

	public void display() {
		System.out.println("bookName:" + bookName + " price:" + price + " author:" + author.getName() + " " + author.getAge());
	}

}
