package me.imyu.home.auth.jwt;

import org.apache.shiro.codec.Base64;
import org.apache.shiro.crypto.AesCipherService;
import org.apache.shiro.crypto.hash.Sha256Hash;

import java.security.Key;

/**
 * Created by imyu on 2018-01-31.
 */
public class Crypto {
    private static AesCipherService aesCipherService = new AesCipherService();
    private static Key key = aesCipherService.generateNewKey();

    private Crypto(){}

    public static String encrypt(String src) {
        return aesCipherService.encrypt(src.getBytes(), key.getEncoded()).toBase64();
    }

    public static String decrypt(String src) {
        return new String(aesCipherService.decrypt(Base64.decode(src), key.getEncoded()).getBytes());
    }

    public static String sign(String src) {
        return new Sha256Hash(src).toString();
    }
}
