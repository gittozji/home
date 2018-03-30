package me.imyu;

import org.junit.Test;

import java.util.UUID;

/**
 * Unit test for simple App.
 */
public class AppTest {
    @Test
    public void uuidLength() {
        System.out.println(UUID.randomUUID().toString().replace("-", ""));
        System.out.println(UUID.randomUUID().toString().replace("-", "").length());
    }
}
