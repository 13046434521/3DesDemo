package com.jtl.a3desdemo;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 * Created by jtlpc on 2016/12/15.
 */

public class Des3Utils {

    private static final String  Algorithm="DESede";
    private static  final String Key="JTL&YU";
    public byte[] encriptMode(String content){
        try {
            SecretKey secretKey=new SecretKeySpec(build3Deskey(Key),Algorithm);
            Cipher cipher=Cipher.getInstance(Algorithm);
            cipher.init(Cipher.ENCRYPT_MODE,secretKey);
            return cipher.doFinal(content.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String decryptMode(byte[] src){
        try {
            SecretKey secretKey=new SecretKeySpec(build3Deskey(Key),Algorithm);
            Cipher cipher=Cipher.getInstance(Algorithm);
            cipher.init(Cipher.DECRYPT_MODE,secretKey);
            return new String(cipher.doFinal(src));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public byte[] build3Deskey(String keyStr){
        byte[] key=new byte[24];
        byte[] temp=keyStr.getBytes();
        if (key.length>temp.length){
            System.arraycopy(key,0,temp,0,temp.length);
        }else {
            System.arraycopy(key,0,temp,0,key.length);
        }
        return key;
    }
}
