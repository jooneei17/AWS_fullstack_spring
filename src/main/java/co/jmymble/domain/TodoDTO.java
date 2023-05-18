package co.jmymble.domain;

import java.sql.Timestamp;

import java.util.Calendar;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class TodoDTO {
	private String title;
	
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private Date dueDate = new Date();
	
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private java.sql.Date date;
	private Timestamp timestamp;
	private Calendar cal;

}
