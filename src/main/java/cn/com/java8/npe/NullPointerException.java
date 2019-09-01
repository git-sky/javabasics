package cn.com.java8.npe;


/**
 * npe问题
 * <p>
 * 可以通过optional解决这个问题。参考 @see cn.com.java8.optional.OptionalInAction。
 */
public class NullPointerException {

    public static void main(String[] args) {
        //空指针异常；
//        String insuranceName = getInsuranceName(new Person());

        //多层嵌套，判断空指针问题；
        System.out.println(getInsuranceNameByDeepDoubts(new Person()));

        //if+return，判断空指针问题，避免了多层嵌套
        System.out.println(getInsuranceNameByMultExit(new Person()));

    }

    private static String getInsuranceNameByDeepDoubts(Person person) {
        if (null != person) {
            Car car = person.getCar();
            if (null != car) {
                Insurance insurance = car.getInsurance();
                if (null != insurance) {
                    return insurance.getName();
                }
            }
        }

        return "UNKNOWN";
    }

    private static String getInsuranceNameByMultExit(Person person) {
        final String defaultValue = "UNKNOWN";
        if (null == person) {
            return defaultValue;
        }
        Car car = person.getCar();
        if (null == car) {
            return defaultValue;
        }
        Insurance insurance = car.getInsurance();
        if (null == insurance) {
            return defaultValue;
        }
        return insurance.getName();
    }

    private static String getInsuranceName(Person person) {
        return person.getCar().getInsurance().getName();
    }
}
