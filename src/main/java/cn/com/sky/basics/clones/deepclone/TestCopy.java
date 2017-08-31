package cn.com.sky.basics.clones.deepclone;

public class TestCopy {

	public static void main(String args[]) {
		Book b1 = new Book("java", 30, new Person("zhang", 34));
		Book b2 = (Book) b1.clone();

		System.out.println(b1 == b2);
		System.out.println();

		b1.display();
		b2.display();
		System.out.println();

		b1.bookName = "vb";
		b1.price = 50;
		b1.author.setName("li");
		b1.author.setAge(10);

		b1.display();
		b2.display();
	}
}
