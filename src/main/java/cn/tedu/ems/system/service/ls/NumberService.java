package cn.tedu.ems.system.service.ls;

import java.util.Random;

/**
 * @Author: lulin
 * @Date: 3/7/2019 10:20 PM
 * @Version 1.0
 */
public class NumberService {

    public static String getRandomCode(int size){
        String chars="ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789";
        String code="";
        Random r=new Random();
        for(int i=0;i<size;i++){
            code += chars.charAt(
                    r.nextInt(chars.length()));
        }
        return code;
    }


}
