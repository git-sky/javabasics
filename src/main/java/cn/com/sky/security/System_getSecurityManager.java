package cn.com.sky.security;

public class System_getSecurityManager {
    public static void main(String[] args) throws Exception {
        SecurityManager sm = System.getSecurityManager();
        if (sm != null)
            sm.checkRead("howsoftworks_temp");
        else
            System.out.println("SecurityManager is null");
    }
}
