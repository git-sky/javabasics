package cn.com.lombok.demo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class Player {

    //    Assert.assertEquals
//    @Setter
    private int goldAmount;

    //    @Getter
//    @Setter
    private Integer amount;

//    public static void main(String[] args) {
//
//        System.exit(0);
//
//        Object obj = null;
//        System.out.println(obj);
//        log.info("sdfasdf a={}", obj.toString());
//
//    }

}