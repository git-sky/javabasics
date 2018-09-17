package cn.com.sky.alpha_work;


public class User {

    private String name;
    private String height;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", height='" + height + '\'' +
                '}';
    }


    public static void main(String[] args) {
        User user = new User();
        user.setName("zhang");
        user.setHeight("abc");
        System.out.println(user);
    }
}
