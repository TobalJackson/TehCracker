import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Object which has a single method, hashTheString, which will accept a string argument and return the hash String.
 * @author TobalJackson
 *
 */

public class StringHasher {
	
	public StringHasher(){
	}
	
	public String hashTheString(String inputString){
		byte[] inputBytes = inputString.getBytes();
		byte[] hashedBytes = null;
		StringBuilder md5String = new StringBuilder();
		
		try{
			MessageDigest md = MessageDigest.getInstance("MD5");
			hashedBytes = md.digest(inputBytes);
			String hexByte = "";
			for (byte b : hashedBytes){
				hexByte = Integer.toHexString(b & 0xff);
				if (hexByte.length() == 1){
					md5String.append("0");
				}
				md5String.append(hexByte);
			}
		}
		catch (NoSuchAlgorithmException e){
			e.printStackTrace();
		}
		return md5String.toString();
	}
}