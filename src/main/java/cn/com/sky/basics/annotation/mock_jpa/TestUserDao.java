package cn.com.sky.basics.annotation.mock_jpa;

public class TestUserDao {

    public static void main(String[] args) {
        UserDao userDao = new UserDao();
        User user = new User("hell", 20);
        userDao.add(user);
    }

}