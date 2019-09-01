package cn.com.sky.basics.anti_if.strategy.replace;

import java.util.HashMap;
import java.util.Map;

/**
 * 解决方案：针对被调用代码，给出应对策略。Ruby的Hash#fetch就是很好的案例，Java也用到了类似的方法。这种模式也可以用在删除例外情况时。
 */
public class Finder {

    public String displayRecord(Repository repository) {
        return repository.getRecord(12,"Not found");
    }

    //Java也用到了类似的方法,如下getOrDefault
    public String javaDemo() {
        Map<String, String> map = new HashMap<>();
        return map.getOrDefault("key", "default");
    }
}