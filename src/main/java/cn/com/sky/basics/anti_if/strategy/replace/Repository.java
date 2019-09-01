package cn.com.sky.basics.anti_if.strategy.replace;


public class Repository {
    public String getRecord(int id, String defaultValue) {
        String result = null;//Db.getRecord(id);

        if (result != null) {
            return result;
        }

        return defaultValue;
    }
}
