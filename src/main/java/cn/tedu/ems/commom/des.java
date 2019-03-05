package cn.tedu.ems.commom;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.net.util.Base64;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.crypto.*;
import javax.crypto.interfaces.DHPublicKey;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.DHParameterSpec;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Objects;
import java.util.UUID;

/**
 *
 * asymmetric_encryption
 * symmetric_encryption
 *
 * digest
 * signaure
 *
 * 非对称加密 RSA DSA ECDSA
 *
 * 对称加密 DES 3DES AES PBE
 *
 * 摘要算法 MD SHA
 *
 * 编码 base64
 *
 * 数字签名 RSA DSA　ECDSA
 */

/**
 * @author lulin
 * @param
 */
public class des {

    @Before
    public void perMethod(){

    }

    @Test
    public void md5(){
        String src="password";
        String salt = UUID.randomUUID().toString();
        String code=src+salt;
        try{
         MessageDigest md =MessageDigest.getInstance("md5");
         byte[] md5Bytes = md.digest(src.getBytes());
         //字节数组转换为字符串
            // String ss= Hex.encodeHexString(md5Bytes);
            System.out.println(md5Bytes.toString());
            System.out.print(Hex.encodeHexString(md5Bytes));

        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void jdkDES(){
        String src="today is nice";
        try
        {
            //Security.addProvider(new BouncyCastleProvider());
            // 生成KEY
            // KeyGenerator keyGenerator = KeyGenerator.getInstance("DES","BC");
            // keyGenerator.getProvider();
            KeyGenerator keyGenerator = KeyGenerator.getInstance("DES");
            keyGenerator.init(56);
            // 产生密钥
            SecretKey secretKey = keyGenerator.generateKey();
            // 获取密钥
            byte[] bytesKey = secretKey.getEncoded();
            // KEY转换
            DESKeySpec desKeySpec = new DESKeySpec(bytesKey);
            SecretKeyFactory factory = SecretKeyFactory.getInstance("DES");
            Key convertSecretKey = factory.generateSecret(desKeySpec);

            // 加密
            Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, convertSecretKey);
            byte[] result = cipher.doFinal(src.getBytes());
            System.out.println("jdk des encrypt:" + Hex.encodeHexString(result));

            // 解密
            cipher.init(Cipher.DECRYPT_MODE, convertSecretKey);
            result = cipher.doFinal(result);
            System.out.println("jdk des decrypt:" + new String(result));



        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        }


    }

    @Test
    public void jdkAes(){
        //生成key

    }


    @Test
    public void DH(){
        try {
            String src="imooc";
            // 1.初始化发送方公钥
            KeyPairGenerator senderKeyPairGenerator = KeyPairGenerator.getInstance("DH");
            senderKeyPairGenerator.initialize(512);
            KeyPair senderKeyPair = senderKeyPairGenerator.generateKeyPair();
            // 发送方公钥，发送给接收方（网络、文件。。。）
            byte[] senderPublicKeyEnc = senderKeyPair.getPublic().getEncoded();
            // 2.接收公钥并生成接收方公钥
            KeyFactory receiverKeyFactory = KeyFactory.getInstance("DH");
            X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(senderPublicKeyEnc);
            PublicKey receiverPublicKey = receiverKeyFactory.generatePublic(x509EncodedKeySpec);
            DHParameterSpec dhParameterSpec = ((DHPublicKey) receiverPublicKey).getParams();
            KeyPairGenerator receiverKeyPairGenerator = KeyPairGenerator.getInstance("DH");
            receiverKeyPairGenerator.initialize(dhParameterSpec);
            KeyPair receiverKeypair = receiverKeyPairGenerator.generateKeyPair();
            PrivateKey receiverPrivateKey    = receiverKeypair.getPrivate();
            //发送接收方公钥
            byte[]     receiverPublicKeyEnc  = receiverKeypair.getPublic().getEncoded();
            // 3.共同密钥构建
            KeyAgreement receiverKeyAgreement = KeyAgreement.getInstance("DH");
            receiverKeyAgreement.init(receiverPrivateKey);
            receiverKeyAgreement.doPhase(receiverPublicKey, true);
            SecretKey  receiverDesKey= receiverKeyAgreement.generateSecret("DES");
            KeyFactory senderKeyFactory = KeyFactory.getInstance("DH");
            x509EncodedKeySpec = new X509EncodedKeySpec(receiverPublicKeyEnc);
            PublicKey senderPublicKey = senderKeyFactory.generatePublic(x509EncodedKeySpec);
            KeyAgreement senderKeyAgreement = KeyAgreement.getInstance("DH");
            senderKeyAgreement.init(senderKeyPair.getPrivate());
            senderKeyAgreement.doPhase(senderPublicKey, true);
            SecretKey senderDesKey = senderKeyAgreement.generateSecret("DES");
            if(Objects.equals(receiverDesKey, senderDesKey))//必须相同
            {
                System.out.println("双方密钥相同。");
            }
            // 4.用共同的密钥加解密
            Cipher cipher = Cipher.getInstance("DES");
            cipher.init(Cipher.ENCRYPT_MODE, senderDesKey);
            byte[] result = cipher.doFinal(src.getBytes());
            System.out.println("bc dh encrypt:" + Base64.encodeBase64String(result));

            Cipher cipher2 = Cipher.getInstance("DES");
            cipher2.init(Cipher.DECRYPT_MODE, receiverDesKey);
            byte[] result2 = cipher.doFinal(result);
            System.out.println("bc dh decrypt:" + new String(result2));
        } catch (Exception e) {
            e.printStackTrace();
        }



    }


    @Test
    public void RAS(){
        String src="demo";
            try
            {
                // 1.初始化发送方密钥
                KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
                keyPairGenerator.initialize(512);
                KeyPair keyPair = keyPairGenerator.generateKeyPair();
                RSAPublicKey rsaPublicKey = (RSAPublicKey) keyPair.getPublic();
                RSAPrivateKey rsaPrivateKey = (RSAPrivateKey) keyPair.getPrivate();
                System.out.println("Public Key:" + Base64.encodeBase64String(rsaPublicKey.getEncoded()));
                System.out.println("Private Key:" + Base64.encodeBase64String(rsaPrivateKey.getEncoded()));

                // 2.私钥加密、公钥解密 ---- 加密
                PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(rsaPrivateKey.getEncoded());
                KeyFactory keyFactory = KeyFactory.getInstance("RSA");
                PrivateKey privateKey = keyFactory.generatePrivate(pkcs8EncodedKeySpec);
                Cipher cipher = Cipher.getInstance("RSA");
                cipher.init(Cipher.ENCRYPT_MODE, privateKey);
                byte[] result = cipher.doFinal(src.getBytes());
                System.out.println("私钥加密、公钥解密 ---- 加密:" + Base64.encodeBase64String(result));

                // 3.私钥加密、公钥解密 ---- 解密
                X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(rsaPublicKey.getEncoded());
                keyFactory = KeyFactory.getInstance("RSA");
                PublicKey publicKey = keyFactory.generatePublic(x509EncodedKeySpec);
                cipher = Cipher.getInstance("RSA");
                cipher.init(Cipher.DECRYPT_MODE, publicKey);
                result = cipher.doFinal(result);
                System.out.println("私钥加密、公钥解密 ---- 解密:" + new String(result));



                // 4.公钥加密、私钥解密 ---- 加密
                X509EncodedKeySpec x509EncodedKeySpec2 = new X509EncodedKeySpec(rsaPublicKey.getEncoded());
                KeyFactory keyFactory2 = KeyFactory.getInstance("RSA");
                PublicKey publicKey2 = keyFactory2.generatePublic(x509EncodedKeySpec2);
                Cipher cipher2 = Cipher.getInstance("RSA");
                cipher2.init(Cipher.ENCRYPT_MODE, publicKey2);
                byte[] result2 = cipher2.doFinal(src.getBytes());
                System.out.println("公钥加密、私钥解密 ---- 加密:" + Base64.encodeBase64String(result2));

                // 5.私钥解密、公钥加密 ---- 解密
                PKCS8EncodedKeySpec pkcs8EncodedKeySpec5 = new PKCS8EncodedKeySpec(rsaPrivateKey.getEncoded());
                KeyFactory keyFactory5 = KeyFactory.getInstance("RSA");
                PrivateKey privateKey5 = keyFactory5.generatePrivate(pkcs8EncodedKeySpec5);
                Cipher cipher5 = Cipher.getInstance("RSA");
                cipher5.init(Cipher.DECRYPT_MODE, privateKey5);
                byte[] result5 = cipher5.doFinal(result2);
                System.out.println("公钥加密、私钥解密 ---- 解密:" + new String(result5));

            } catch (Exception e) {

                e.printStackTrace();
            }

        }


    @After
    public void finish(){

    }

    }



