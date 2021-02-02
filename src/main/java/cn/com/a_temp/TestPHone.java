package cn.com.a_temp;

/**
 *
 */
public class TestPHone {

    public static void main(String[] args) {
        String phone = "13511115678";
        String newphone = phone.substring(0, 3) + "****" + phone.substring(phone.length() - 4);
        System.out.println(newphone);


        System.out.println("{\"bizId\":21,\"chgValue\":\"addcoin,value=10000\",\"mgcId\":1280041249788657718,\"operateTime\":1600659125000,\"operatorMis\":\"fupeng04\"}");
    }
}