package cn.com.java8.optional;

import java.util.Optional;


public class OptionalInAction {

    public static void main(String[] args) {
        System.out.println(getInsuranceNameByOptional(null));
        Optional.ofNullable(getInsuranceNameByOptional(null)).ifPresent(System.out::println);
    }

    private static String getInsuranceNameByOptional(Person person) {
        return Optional.ofNullable(person)
                .flatMap(Person::getCar).flatMap(Car::getInsurance)
                .map(Insurance::getName).orElse("Unknown");
    }
}
