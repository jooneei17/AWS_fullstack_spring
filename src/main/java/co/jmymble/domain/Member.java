package co.jmymble.domain;

import java.util.Date;

import lombok.Data;

@Data
public class Member {
	private String id;
	private String pw;
	private String name;
	private Date regDate;
}
