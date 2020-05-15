package com.deere.applicaionSpecific;
 
import java.security.Key;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class decode {
	private static final String ALGO = "AES";
	private static final byte[] keyValue = 
			new byte[] { 'T', 'h', 'e', 'B', 'e', 's', 't',

		'S', 'e', 'c', 'r','e', 't', 'K', 'e', 'y' };
	
	public static String decrypt(String encryptedData) throws Exception {
		Key key = generateKey();
		Cipher c = Cipher.getInstance(ALGO);
		c.init(Cipher.DECRYPT_MODE, key);
		byte[] decordedValue = Base64.getDecoder().decode(encryptedData);
		byte[] decValue = c.doFinal(decordedValue);
		String decryptedValue = new String(decValue);
		return decryptedValue;
	}
	private static Key generateKey() throws Exception {
		Key key = new SecretKeySpec(keyValue, ALGO);
		return key;
	}
 
	public static String encrypt(String Data) throws Exception {
        Key key = generateKey();
        Cipher c = Cipher.getInstance(ALGO);
        c.init(Cipher.ENCRYPT_MODE, key);
        byte[] encVal = c.doFinal(Data.getBytes());
       String encryptedValue = new String(Base64.getEncoder().encode(encVal));
        return encryptedValue;
    }
	
	 public static void main(String[] args) throws Exception {
		 String credentials = "SaiRam_881984";
		 String passwordEnc = decode.encrypt(credentials);
	     String passwordDec = decode.decrypt(passwordEnc);
	     System.out.println("Plain Text : " + credentials);
	     System.out.println("Encrypted Text : " + passwordEnc);

	       System.out.println("Decrypted Text : " + passwordDec);
	    }
}