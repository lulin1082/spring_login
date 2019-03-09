package cn.tedu.ems.commom.encryption;

import cn.tedu.ems.system.service.ls.NumberService;
import com.sun.corba.se.impl.orbutil.concurrent.Sync;
import org.apache.commons.codec.binary.Hex;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.locks.Lock;

/**
 * @Author: lulin
 * @Date: 3/8/2019 12:10 AM
 * @Version 1.0
 */

public class SaltMd5 implements Runnable{
    @Override
    public void run() {
    MessageDigest md = null;
     String salt = NumberService.getRandomCode(8);
    //salt="123456";
      //  System.out.print("___"+salt+"____");
    String passowrd = "123456";
    //e10adc3949ba59abbe56e057f20f883e
    //ca21c5549328b9ab0c198bd9fb8ed207
    String result = "     ";
      try {
          synchronized(this) {

              md = MessageDigest.getInstance("md5");
              md.update(salt.getBytes());
                md.update(passowrd.getBytes());
              result = Hex.encodeHexString(md.digest());
              md.reset();
          }
    } catch (NoSuchAlgorithmException e) {
        e.printStackTrace();
    }
      ///  System.out.println(salt.getBytes() + "  " + passowrd.getBytes());
        System.out.println("salt=" +salt + "   " + "password=" + passowrd + "    " + "result=" + result);
    }
}


