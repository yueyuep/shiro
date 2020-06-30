package group.yueyue.Utils;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

/**
 * Create by lp on 2020/6/28
 */
public class MD5utils {
    private static final String SALT = "mrbird";



    private static final String ALGORITH_NAME = "md5";



    private static final int HASH_ITERATIONS = 2;



    public static String encrypt(String pswd) {

        String newPassword = new SimpleHash(ALGORITH_NAME, pswd, ByteSource.Util.bytes(SALT), HASH_ITERATIONS).toHex();

        return newPassword;

    }



    public static String encrypt(String username, String pswd) {

        String newPassword = new SimpleHash(ALGORITH_NAME, pswd, ByteSource.Util.bytes(username + SALT),

                HASH_ITERATIONS).toHex();

        return newPassword;

    }

}
