package cn.com.a_temp;

/**
 *
 */
public class Testxxx {

    public static void main(String[] args) {
        String a = "/api/v1/a/b";
        Integer gameType = 9999;
//        String rhinoKey = "Rhino_" + a.replaceAll("/", "\\.");
        String rhinoKey = "Rhino" + a.replaceAll("/", "_");
        if (gameType != null) {
            rhinoKey = rhinoKey + "_" + gameType;
        }

        System.out.println(rhinoKey);

        System.out.println(("bugfix：【玩法点击】禁止多点触控 feat：【新手引导】替换转盘spine bugfix：【person吃饭动作】修复吃饭后无待机 bugfix： 【新手】cache最后删除 feat：【新手引导】替换转盘spine bugfix： 【新手】删除无用cache，修改钻石领取移动地址 feat：【新手引导】修改引导顺序，添加财神动作笑 feat：【新手引导】修改第一个引导，点击任何区域可以通过，并且点击后可以中断文字特效 feat：【新手引导】修改第一个引导，点击任何区域可以通过，并且点击后可以中断文字特效").length());
    }
}