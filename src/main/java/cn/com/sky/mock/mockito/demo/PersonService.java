package cn.com.sky.mock.mockito.demo;

public class PersonService {

    private final PersonDao personDao;

    public PersonService(PersonDao personDao) {
        this.personDao = personDao;
    }

    public boolean update(Integer personId, String name) {
        Person person = personDao.fetchPerson(personId);
        if (person != null) {
            Person updatedPerson = new Person(person.getPersonId(), name);
            personDao.update(updatedPerson);
            return true;
        } else {
            return false;
        }
    }
}