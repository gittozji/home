import me.imyu.home.auth.jwt.Crypto;
import org.junit.Test;

/**
 * Created by imyu on 2018-02-28.
 */
public class BaseTest {
    @Test
    public void f0() {
        System.out.println(Crypto.sign("admin"));
    }
}
