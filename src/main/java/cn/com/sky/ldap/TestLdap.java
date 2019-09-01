package cn.com.sky.ldap;

import org.junit.Test;

public class TestLdap {

    private static String base = "dc=company,dc=com";
    private static String filter = "sAMAccountName=john";
    private static String resultElements[] = null;
    private static int scope = 0;

    @Test
    public void testQuery() {
        LdapUtils test = new LdapUtils();
        resultElements = new String[]{"sAMAccountName", "msExchVersion", "memberOf"};
        test.Ldapbyuserinfo(base, scope, resultElements, filter);
        test.close();
    }
}