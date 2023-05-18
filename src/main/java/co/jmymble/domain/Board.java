package co.jmymble.domain;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//@Builder
public class Board {
	private Long bno;
	private String title;
	private String content;
	
	public Board(Long bno, String title, String content) {
		super();
		this.bno = bno;
		this.title = title;
		this.content = content;
	}
	
	public static BoardBuilder builder() {
		return new BoardBuilder();
	}
	
	public static class BoardBuilder {
		private Long bno;
		private String title;
		private String content;
		
		
		
		public BoardBuilder bno(Long bno) {
			this.bno = bno;
			return this;
		}
		public BoardBuilder title(String title) {
			this.title = title;
			return this;
		}
		public BoardBuilder content(String content) {
			this.content = content;
			return this;
		}
		
		public Board build() {
			return new Board(bno, title, content);
		}
	}
	
	public static void main(String[] args) {
		Board board = Board.builder()
				.bno(1L)
				.title("aaa")
				.title("bbb") //두번 쓰면 덮어씀
				.content("abcd")
				.build();
		System.out.println(board);
	}


}
