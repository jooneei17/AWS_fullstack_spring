package test;

import org.mindrot.bcrypt.BCrypt;

public class BcryptTest {
	public static void main(String[] args) {
		String pw = "0000";
		BCrypt bCrypt = new BCrypt();
		String result = bCrypt.hashpw(pw, BCrypt.gensalt(8));
		String result2 = bCrypt.hashpw(pw, BCrypt.gensalt());
		String result3 = bCrypt.hashpw(pw, BCrypt.gensalt());
		System.out.println(result);
		System.out.println(result2);
		System.out.println(result3);
		
		System.out.println(BCrypt.checkpw("1111", result));
		System.out.println(BCrypt.checkpw(pw, result2));
		System.out.println(BCrypt.checkpw(pw, result3));
		
		String resultCopy = "$2a$10$.0MmEGhrAT4VMU15oN.cIe.fPlY2Hae/IMlbGHy1mI0h4r0fg1.vu";
		System.out.println(BCrypt.checkpw("0000", resultCopy));
		
	}
}
