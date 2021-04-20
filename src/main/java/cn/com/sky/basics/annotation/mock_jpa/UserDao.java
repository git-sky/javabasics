package cn.com.sky.basics.annotation.mock_jpa;

public class UserDao extends BaseDao<User> {

    @Override
    public void add(User bean) {
        super.add(bean);
    }

}