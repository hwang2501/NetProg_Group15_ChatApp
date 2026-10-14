/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.chat.security;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class AESUtil {
    private static final String ALGORITHM = "AES";
    // Khóa bí mật 16 bytes (128-bit) dùng chung cho Client & Server
    private static final String SECRET_KEY = "Group15SecretKey"; 

    // Hàm mã hóa chuỗi tin nhắn
    public static String encrypt(String value) throws Exception {
        SecretKeySpec key = new SecretKeySpec(SECRET_KEY.getBytes("UTF-8"), ALGORITHM);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encrypted = cipher.doFinal(value.getBytes("UTF-8"));
        return Base64.getEncoder().encodeToString(encrypted);
    }

    // Hàm giải mã chuỗi tin nhắn
    public static String decrypt(String encryptedValue) throws Exception {
        SecretKeySpec key = new SecretKeySpec(SECRET_KEY.getBytes("UTF-8"), ALGORITHM);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] original = cipher.doFinal(Base64.getDecoder().decode(encryptedValue));
        return new String(original, "UTF-8");
    }
}