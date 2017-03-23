package db;

import java.security.MessageDigest;
/**
 * Class for hashing the passwords (NYI)
 * @author Liam Walsh & Seán Scott
 *
 */
public class hashpassword {
	
	public static void main(String[] args)throws Exception
    {
    	String password = "123456";

        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(password.getBytes());

        byte byteData[] = md.digest();

        //convert the byte to hex format
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < byteData.length; i++) {
         sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
        }

        System.out.println("Digest(in hex format):: " + sb.toString());

    }
}
