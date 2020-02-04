package cn.com.sky.security;

public class System_setSecurityManager {
    public static void main(String[] args) throws Exception {
        SecurityManager securityManager = new SecurityManager();
        System.setSecurityManager(securityManager);
        System.out.println("setSecurityManager... ");
    }
}