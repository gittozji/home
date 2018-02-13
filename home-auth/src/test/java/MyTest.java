import me.imyu.home.auth.jwt.Jwt;
import me.imyu.home.auth.jwt.JwtParser;
import me.imyu.home.auth.jwt.JwtValidator;
import org.junit.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by imyu on 2018-01-03.
 */
public class MyTest {
    @Test
    public void f0() {
        Map header = new HashMap();
        header.put("expireAt", new Date().getTime() + 2 * 60 * 60 * 1000);
        Map payload = new HashMap();
        payload.put("username", "张三");
        payload.put("role", "管理员");
        Jwt jwt = new Jwt(header, payload, null);
        String token = JwtParser.parseStr(jwt);
        System.out.println(token);
        Jwt jwt1 = JwtParser.parseJWT(token);
        System.out.println(jwt1);
        JwtValidator.validate(token);
    }

    @Test
    public void f1() {
        String src = "12345";
        System.out.println(src.substring(0, src.length()));
    }
}
