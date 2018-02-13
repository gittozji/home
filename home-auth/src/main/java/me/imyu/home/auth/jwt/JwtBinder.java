package me.imyu.home.auth.jwt;

/**
 * Created by imyu on 2018-02-13.
 */
public class JwtBinder {
    private static final ThreadLocal<Jwt> jwtLocal = new ThreadLocal<Jwt>();

    public static void bind(Jwt jwt) {
        jwtLocal.set(jwt);
    }

    public static void unbind() {
        jwtLocal.remove();
    }

    public static Jwt get() {
        Jwt jwt = jwtLocal.get();

        if (jwt == null) {
            throw new IllegalArgumentException("Please use get after bind !");
        }

        return jwt;
    }
}
