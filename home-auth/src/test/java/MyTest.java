import com.sun.org.apache.xpath.internal.SourceTree;
import me.imyu.home.auth.jwt.DefaultJWTManager;
import me.imyu.home.auth.jwt.JWT;
import me.imyu.home.auth.jwt.JWTManager;
import org.apache.shiro.codec.Hex;
import org.apache.shiro.crypto.AesCipherService;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.junit.Test;
import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.security.Key;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

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
        DefaultJWTManager manager = new DefaultJWTManager();
        Map header = new HashMap();
        header.put("createAt", new Date());
        Map payload = new HashMap();
        payload.put("username", "张三");
        payload.put("role", "管理员");
        String secret = "1234";
        JWT jwt = new JWT(header, payload, secret);
        String tokenStr = manager.parseStr(jwt);
        System.out.println(tokenStr);


        JWT jwt1 = manager.parseJWT(tokenStr);
        System.out.println(jwt1);
    }

    @Test
    public void f2() {
        String s = "123.456.789";
        System.out.println(s.substring(s.lastIndexOf(".") + 1, s.length()));
    }

    @Test
    public void f3() throws UnsupportedEncodingException {
        AesCipherService aesCipherService = new AesCipherService();
        aesCipherService.setKeySize(128); //设置key长度
//生成key
        Key key = aesCipherService.generateNewKey();
        String text = "hello5635463456几点开始发3456334";
//加密
        String encrptText =
                aesCipherService.encrypt(text.getBytes(), key.getEncoded()).toBase64();
        System.out.println(encrptText);
//解密
        String text2 =
                new String(aesCipherService.decrypt(org.apache.shiro.codec.Base64.decode(encrptText), key.getEncoded()).getBytes());
        System.out.println(text2);
    }

}
