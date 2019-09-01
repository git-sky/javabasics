package cn.com.sky.basics.clones.deepclone;

public class TestDeepClone {

    public static void main(String args[]) {
        Book b1 = new Book("java", 30, new Person("zhang", 34));
        Book b2 = (Book) b1.clone();

        System.out.println(b1 == b2);

        b1.display();
        b2.display();
        System.out.println("=====================================");

        b1.setBookName("vb");
        b1.setPrice(50);
        b1.getAuthor().setName("li");
        b1.getAuthor().setAge(10);

        b1.display();
        b2.display();
    }
}
