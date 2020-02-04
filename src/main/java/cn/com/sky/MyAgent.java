package cn.com.sky;

import java.lang.instrument.Instrumentation;

public class MyAgent {
    public static void premain(String agentOps, Instrumentation inst) {
        System.out.println(agentOps);
    }
}
