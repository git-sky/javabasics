package cn.com.sky.mock.mockito.demo;

public interface PersonDao {

	public Person fetchPerson(Integer personID);

	public void update(Person person);
}