package me.imyu.home.security;

import org.apache.shiro.authc.credential.DefaultPasswordService;
import org.junit.Test;

/**
 * Created by imyu on 2017/12/9.
 */
public class SecurityTest {
    @Test
    public void f0() {
        DefaultPasswordService service = new DefaultPasswordService();
        System.out.println(service.encryptPassword("12sdf会计师考虑到付sdfsdf34").length());
        System.out.println(service.encryptPassword("1234"));
    }
}
