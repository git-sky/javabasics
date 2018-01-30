package cn.com.sky.collections.map;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.commons.lang3.StringUtils;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class TestSort {

    public static void main(String[] args) {

        String kid = "kid1111";
        Integer rank = 2;
        String retailId = "1111";

        List<ShareUrlDto> list = new TestSort().getList(kid, rank, retailId);

        for (ShareUrlDto dto:list){
            System.out.println(dto.getUserid());
        }
    }


    private List<ShareUrlDto> getList(String kid, Integer rank, String retailId) {

        List<ShareUrlDto> list = Lists.newArrayList();
        ShareUrlDto dto1 = new ShareUrlDto();
        dto1.setLevel("1");
        dto1.setRowKey("kid222");
        dto1.setUserid("2222");
        list.add(dto1);

        ShareUrlDto seedUser = new ShareUrlDto();
        if (StringUtils.isNotBlank(retailId)) {// 如果存在美店店主，则美店店主是种子用户。
            seedUser.setLevel("0");
            seedUser.setRowKey(kid);
            seedUser.setUserid(retailId);
        } else {
            seedUser = list.get(0);// 如果不存在美店店主，则第一个分享者就是种子用户
        }

        // 排序
        sortDesc(list);

        // 去重
        Map<String, ShareUrlDto> map = Maps.newLinkedHashMap();
        map.put(seedUser.getUserid(), seedUser);
        for (ShareUrlDto dto : list) {
            if (dto != null && seedUser != null && !seedUser.getUserid().equals(dto.getUserid())) {
                putShareUserLarger(map, dto);
                if (map.size() == rank) {// 种子用户rank是0，则需要加1，如果种子用户rank是1，则不需要加1.
                    break;
                }
            }
        }
        List<ShareUrlDto> sortList = Lists.newLinkedList(map.values());

        // 排序
        sortAsc(sortList);

        return sortList;
    }


    /**
     * 降序排序
     */
    private void sortDesc(List<ShareUrlDto> list) {
        Collections.sort(list, new Comparator<ShareUrlDto>() {
            @Override
            public int compare(ShareUrlDto o1, ShareUrlDto o2) {
                return Integer.valueOf(o2.getLevel()) - Integer.valueOf(o1.getLevel());
            }
        });
    }

    /**
     * 升序排序
     */
    private void sortAsc(List<ShareUrlDto> list) {
        Collections.sort(list, new Comparator<ShareUrlDto>() {
            @Override
            public int compare(ShareUrlDto o1, ShareUrlDto o2) {
                return Integer.valueOf(o1.getLevel()) - Integer.valueOf(o2.getLevel());
            }
        });
    }

    /**
     * 无限极，链条后面覆盖前面。
     */
    private void putShareUserLarger(Map<String, ShareUrlDto> map, ShareUrlDto dto) {
        if (map.containsKey(dto.getUserid())) {
            ShareUrlDto shareUrlDto = map.get(dto.getUserid());
            if (Integer.parseInt(dto.getLevel()) > Integer.parseInt(shareUrlDto.getLevel())) {
                map.put(dto.getUserid(), dto);
            }
        } else {
            map.put(dto.getUserid(), dto);
        }
    }

}


