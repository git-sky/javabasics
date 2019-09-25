package cn.com.sky.lamda;


import cn.com.sky.tools.json.jackson.JsonUtils;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.commons.collections.MapUtils;
import org.junit.Test;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class TestForEachMap {

    @Test
    public void test() {
        Map<String, List<RealRoomMatchResult>> allRelationMap = Maps.newHashMap();

        for (int i = 0; i < 10; i++) {
            allRelationMap.put("a" + i, Lists.newArrayList(new RealRoomMatchResult(i), new RealRoomMatchResult(i + 1), new RealRoomMatchResult(i + 2)));
        }

        System.out.println(JsonUtils.object2Json(allRelationMap));

        System.out.println("-------------------------------");

        List<Integer> realRoomIds = Lists.newArrayList();
        if (MapUtils.isNotEmpty(allRelationMap)) {
            allRelationMap.forEach((key, value) -> value.forEach(s -> realRoomIds.add(s.getRealRoomId())));
        }

        System.out.println(JsonUtils.object2Json(realRoomIds));

    }

    public static class RealRoomMatchResult {

        private Integer realRoomId;

        private String realRoomName;

        private Integer matchType;

        private Integer operatorId;

        private String operatorName;

        private Date operatorTime;


        public RealRoomMatchResult(Integer realRoomId) {
            this.realRoomId = realRoomId;
        }

        public Integer getRealRoomId() {
            return realRoomId;
        }

        public void setRealRoomId(Integer realRoomId) {
            this.realRoomId = realRoomId;
        }

        public String getRealRoomName() {
            return realRoomName;
        }

        public void setRealRoomName(String realRoomName) {
            this.realRoomName = realRoomName;
        }

        public Integer getMatchType() {
            return matchType;
        }

        public void setMatchType(Integer matchType) {
            this.matchType = matchType;
        }

        public Integer getOperatorId() {
            return operatorId;
        }

        public void setOperatorId(Integer operatorId) {
            this.operatorId = operatorId;
        }

        public String getOperatorName() {
            return operatorName;
        }

        public void setOperatorName(String operatorName) {
            this.operatorName = operatorName;
        }

        public Date getOperatorTime() {
            return operatorTime;
        }

        public void setOperatorTime(Date operatorTime) {
            this.operatorTime = operatorTime;
        }
    }
}