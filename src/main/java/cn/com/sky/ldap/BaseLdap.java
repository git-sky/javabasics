package cn.com.sky.ldap;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;

/**
 * ldap基础类
 */
public class BaseLdap {

    // 上下文，可由此进行简单操作
    public static DirContext dc = null;

    static {
        Hashtable<String, String> env = new Hashtable<>();
        String LDAP_URL = "********";
        String adminName = "*******";
        String adminPassword = "******";
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.PROVIDER_URL, LDAP_URL);
        env.put(Context.SECURITY_AUTHENTICATION, "simple");
        env.put(Context.SECURITY_PRINCIPAL, adminName);
        env.put(Context.SECURITY_CREDENTIALS, adminPassword);
        try {
            dc = new InitialDirContext(env);
            System.out.println("账户认证成功！");
        } catch (javax.naming.AuthenticationException e) {
            System.out.println("账户认证失败，账号或密码不正确！");
        } catch (Exception e) {
            System.out.println("账户认证出错：" + e);
        }
    }
}