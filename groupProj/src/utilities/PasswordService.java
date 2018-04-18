package utilities;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Base64.Encoder;

public final class PasswordService {
	
//this class converts plaintext passwords into a SHA256 hash.
	
	public String encrypt(String pass)
	{
		MessageDigest md = null;
		
		try {
			md = MessageDigest.getInstance("SHA-256");
			
		}
		catch(NoSuchAlgorithmException e)
			{
				e.printStackTrace();
			}
		
		
		try {
			md.update(pass.getBytes("UTF-8"));
		}
		catch(UnsupportedEncodingException e){
			e.printStackTrace();
		}
		
		byte raw[] = md.digest();
		Base64.Encoder encoder = Base64.getEncoder();
		
		String hash = encoder.encodeToString(raw);
		return hash;
	}
}
