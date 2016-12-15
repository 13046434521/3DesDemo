package com.jtl.a3desdemo;

import android.util.Log;

import java.io.UnsupportedEncodingException;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 * Created by jtlpc on 2016/12/15.
 */

public class DesUtils {
    private static final String Algorithm = "DESede";
    private String mKey="JTL&YB12";


    // 加密 src为源数据的字节数组
    public byte[]  encryptMode(byte[] src){
        try {
            // 生成密钥
            SecretKey deskey = new SecretKeySpec(Build3DesKey(mKey), Algorithm);
            // 实例化cipher
            Cipher cipher = Cipher.getInstance(Algorithm);
            cipher.init(Cipher.ENCRYPT_MODE, deskey);
            Log.i("aaa","加密返回"+cipher.doFinal(src).toString());
            return cipher.doFinal(src);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public byte[]  decryptMode(byte[] src){
        try {
            SecretKey  deskey=new SecretKeySpec(Build3DesKey(mKey),Algorithm);
            Cipher cipher= Cipher.getInstance(Algorithm);
            cipher.init(Cipher.DECRYPT_MODE,deskey);
            Log.i("aaa","解密返回"+src);
            Log.i("aaa","解密返回"+cipher.doFinal(src).toString());
            byte [] a=cipher.doFinal(src);
            return cipher.doFinal(src);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public byte[] Build3DesKey(String keyStr) {
        try {
            byte[] key = new byte[24];
            byte[] temp = keyStr.getBytes("UTF-8");
            if (key.length > temp.length) {
                System.arraycopy(temp, 0, key, 0, temp.length);
            } else {
                System.arraycopy(temp, 0, key, 0, key.length);
            }
            Log.i("test","key---的值"+new String(key));
            return key;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
