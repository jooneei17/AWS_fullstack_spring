package kr.co.jmymble.jsp.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Board {
	private Long bno;
	private String title; 
	private String content;
	private String writer; 
	
	private Date regdate; 
	private String updatedate;
	private int hitcount;
	private Integer category;
	
	//첨부파일
	private List<Attach> attachs = new ArrayList<Attach>(); 
	
	//bno의 cnt 값 가져오기
	private int replyCnt;
	
}
