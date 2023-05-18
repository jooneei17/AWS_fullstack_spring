package magic;

import lombok.Data;

@Data
public class Magician {
	private MagicBox magicBox;
	
	public void magic() {
		System.out.println("마술 시작");
		System.out.println(magicBox.getContent());
		System.out.println("짜잔");
		
	}
}
