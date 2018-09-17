package cn.com.sky.collections.list;

import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class TestListSort {

    @Test
    public void tst() {

        List compRoomResultList = Lists.newArrayList();

        CompRoomResult compRoomResult3 = new CompRoomResult();
        compRoomResult3.setSiteId(2);
        compRoomResult3.setCompRoomId(1L);

        CompRoomResult compRoomResult1 = new CompRoomResult();
        compRoomResult1.setSiteId(1);
        compRoomResult1.setCompRoomId(456L);

        CompRoomResult compRoomResult2 = new CompRoomResult();
        compRoomResult2.setSiteId(1);
        compRoomResult2.setCompRoomId(12L);

        CompRoomResult compRoomResult4 = new CompRoomResult();
        compRoomResult4.setSiteId(2);
        compRoomResult4.setCompRoomId(33L);


        compRoomResultList.add(compRoomResult3);
        compRoomResultList.add(compRoomResult1);
        compRoomResultList.add(compRoomResult2);
        compRoomResultList.add(compRoomResult4);


        System.out.println(compRoomResultList);


        //按照siteId排序，
        Collections.sort(compRoomResultList, new Comparator<CompRoomResult>() {
            @Override
            public int compare(CompRoomResult o1, CompRoomResult o2) {
                if (Objects.equals(o1.getSiteId(), o2.getSiteId())) {
                    return o1.getCompRoomId().compareTo(o2.getCompRoomId());
                } else {
                    return o1.getSiteId().compareTo(o2.getSiteId());
                }
            }
        });

        System.out.println(compRoomResultList);

    }

}
