package cn.com.java8;

import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.collections.CollectionUtils;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 *
 */
public class Testq {

    public static void main(String[] args) {

        String msgType="1";

        List<ConnectConfig> list = Lists.newArrayList();
        list.stream()
                .filter(config -> Objects.equals(config.getMsgType(), msgType))
                .collect(Collectors.toList());

    }

    public class ConnectConfig {
        private Long msgType;

        public Long getMsgType() {
            return msgType;
        }

        public void setMsgType(Long msgType) {
            this.msgType = msgType;
        }
    }
}