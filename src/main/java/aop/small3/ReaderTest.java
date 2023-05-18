package aop.small3;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class ReaderTest {
	public static void main(String[] args) throws IOException {
		byte[] btyes = {65, 66, 67, 68, 97, 98, 99, 48, 49, 50};

 		ByteArrayInputStream bais = new ByteArrayInputStream(btyes);
		BufferedInputStream bis = new BufferedInputStream(bais);
		
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("abcd.txt"), 3);
		
		int i = 0;
		byte[] readUnit = new byte[9];
		
		i = bis.read(readUnit); //읽을 때는 상관 없지만
//		bos.write(readUnit, 0, i); //쓸 때는 offset과 length를 해주어야 정확하게 값이 적힌다.
//		i = bis.read(readUnit); 
//		bos.write(readUnit, 0, i); 
		
		//보통 이렇게 사용한다.
		i = bis.read();
		bos.write(i); 
		
//		i = bis.read();
//		i = bis.read();
//		i = bis.read();
//		i = bis.read(readUnit);
//		i = bis.read(readUnit, 1, 2); //[0, 1, 2, 0] 2
		
//		i = bis.read(readUnit);
//		i = bis.read(readUnit); //9 10 7 8
		//-1은 eof 더 이상 읽을 게 없다
		
		System.out.println(Arrays.toString(readUnit));
		System.out.println(i); //읽은 개수 
//		bos.flush(); //버퍼 내용을 다 보내줌. (어떤 내용을 하던 원래 있던 내용을 다 보내줌)
		bos.close();
	}
}
