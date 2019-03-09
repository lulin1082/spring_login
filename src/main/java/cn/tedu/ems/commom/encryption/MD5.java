package cn.tedu.ems.commom.encryption;

import com.sun.xml.internal.fastinfoset.util.CharArray;
import org.apache.commons.codec.binary.Hex;
import org.junit.Test;

import java.lang.reflect.Array;
import java.security.MessageDigest;
import java.util.Random;
import java.util.UUID;

/**
 * @Author: lulin
 * @Date: 3/7/2019 2:57 PM
 * @Version 1.0
 */
public class MD5 {





    @Test
    public   void decode() {
        String src = "password";
        //String salt = UUID.randomUUID().toString();
        System.out.println(src.getBytes());
        String code = src ;
        try {
            MessageDigest md = MessageDigest.getInstance("md5");
            byte[] md5Bytes = md.digest(src.getBytes());

            //字节数组转换为字符串
            String ss= Hex.encodeHexString(md5Bytes);
            System.out.println(md5Bytes.toString());
            System.out.print(Hex.encodeHexString(md5Bytes));
          //  System.out.print(Hex.decodeHex(ss));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
