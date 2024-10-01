package com.example.tao_ma_hoa;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class AESCrypto {
    public static String encrypt(String data, String secretKey) throws Exception {
        SecretKeySpec keySpec = new SecretKeySpec(secretKey.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, keySpec);
        byte[] encrypted = cipher.doFinal(data.getBytes());
        return Base64.getEncoder().encodeToString(encrypted);
    }

    // Giải mã chuỗi
    public static String decrypt(String encryptedData, String secretKey) throws Exception {
        SecretKeySpec keySpec = new SecretKeySpec(secretKey.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, keySpec);
        byte[] decrypted = cipher.doFinal(Base64.getDecoder().decode(encryptedData));
        return new String(decrypted);
    }

    public static void main(String[] args) {
        try {
            String secretKey = "TranBinh23022000"; // Secret key cần đủ 16, 24 hoặc 32 byte
            String username = "Anhyeuem3";

            String encryptedUsername = encrypt(username, secretKey);
            System.out.println("Encrypted: " + encryptedUsername);

            String decryptedUsername = decrypt(encryptedUsername, secretKey);
            System.out.println("Decrypted: " + decryptedUsername);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
