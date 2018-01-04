import me.imyu.home.auth.util.SHA256Utils;
import org.junit.Test;
import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

/**
 * Created by imyu on 2018-01-03.
 */
public class MyTest {
    @Test
    public void f0() throws UnsupportedEncodingException {
        String text = "hello world + 你好，世界";
        String en = Base64.getUrlEncoder().encodeToString(text.getBytes("UTF-8"));
        String de = new String(Base64.getUrlDecoder().decode(en), "UTF-8");
        System.out.println(en);
        System.out.println(de);
    }

    @Test
    public void f1() {
        System.out.println(SHA256Utils.sha256("123456", "324").length());
    }

    @Test
    public void f2() {
        String s = "123.456.789";
        System.out.println(s.substring(s.lastIndexOf(".") + 1, s.length()));
    }

}
