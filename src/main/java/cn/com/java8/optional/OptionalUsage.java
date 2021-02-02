package cn.com.java8.optional;

import java.util.Optional;


public class OptionalUsage {

    public static void main(String[] args) {
//
//        Optional<Insurance> insuranceOptional = Optional.empty();
//
////        insuranceOptional.get(); //java.util.NoSuchElementException: No value present
//
//        Optional<Insurance> insuranceOptional1 = Optional.of(new Insurance());
//
//        Insurance insurance3 = insuranceOptional1.get();
//        System.out.println(insurance3);
//
//        Optional<Insurance> objectOptional = Optional.ofNullable(null);
////        System.out.println(objectOptional.get());
//
//        Insurance insurance1 = objectOptional.orElseGet(Insurance::new);
////        System.out.println(insurance1);
////        System.out.println(objectOptional.get());
//
//        objectOptional.orElse(new Insurance());
////        System.out.println(objectOptional.get());
//
////        objectOptional.orElseThrow(RuntimeException::new);
////
////        objectOptional.orElseThrow(() -> new RuntimeException("Not have reference"));
//
//        Insurance insurance = insuranceOptional1.filter(i -> i.getName() != null).get();
//        System.out.println(insurance);
//
//        Optional<String> nameOptional = insuranceOptional1.map(i -> i.getName());
//
//        System.out.println(nameOptional.orElse("empty Value"));
//
//        System.out.println(nameOptional.isPresent());
//
//        nameOptional.ifPresent(System.out::println);
//

        System.out.println(getInsuranceName(null));
        System.out.println(getInsuranceNameByOptional(null));
    }


    private static String getInsuranceName(Insurance insurance) {
        if (null == insurance) {
            return "unknown";
        }
        return insurance.getName();
    }

    private static String getInsuranceNameByOptional(Insurance insurance) {
        return Optional.ofNullable(insurance).map(Insurance::getName).orElse("abc");
    }
}