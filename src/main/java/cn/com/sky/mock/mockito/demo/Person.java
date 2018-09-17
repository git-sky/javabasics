package cn.com.sky.mock.mockito.demo;

public class Person {

    private final Integer personId;
    private final String personName;

    public Person(Integer personId, String personName) {
        this.personId = personId;
        this.personName = personName;
    }

    public Integer getPersonId() {
        return personId;
    }

    public String getPersonName() {
        return personName;
    }
}
