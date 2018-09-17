package cn.com.sky.mock.mockito.demo;

public interface PersonDao {

    Person fetchPerson(Integer personId);

    void update(Person person);
}