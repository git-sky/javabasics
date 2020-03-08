package cn.com.lombok.demo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
@ToString
public class Player {

//    @Getter
//    @Setter
    private int goldAmount;

//    @Getter
//    @Setter
    private Integer amount;

}