package test.common;

import cn.tedu.ems.commom.encryption.SaltMd5;
import cn.tedu.ems.system.service.ls.NumberService;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.cli.Digest;
import org.junit.Test;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @Author: lulin
 * @Date: 3/8/2019 12:11 AM
 * @Version 1.0
 */
public class TestSaltMd5 {

    @Test //线程安全， 打印到的是地址
    public void getIt(){
        SaltMd5 saltMd5=new SaltMd5();
        saltMd5.run();
        Thread t1 = new Thread(saltMd5);
        t1.start();
        Thread threads[]=new Thread[10];
        for (Thread thread : threads) {
            Thread t=new Thread(saltMd5);
            t.start();
        }

       /* for(int i=0;i<threads.length;i++){
            threads[i]=new Thread(saltMd5);
            threads[i].start();
        }*/
        }

    @Test
    public void cc( ){

      //  salt=742SA8I8   password=123456    result=f5fbac704214b6cc1e9a38b1979d38a8
        MessageDigest md = null;
        String salt = "A6SIV1ID";
        String passowrd = "123456";
        //c69ee7d94730045cebf2f2c582f437d6
        //e6bb0e754a91201aba3856f689b19424
        String result = "     ";
        try {
                md = MessageDigest.getInstance("md5");
                md.update(salt.getBytes());
                md.update(passowrd.getBytes());
                result = Hex.encodeHexString(md.digest());
                System.out.println(result + " " + salt);
                md.reset();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }


    }




}
