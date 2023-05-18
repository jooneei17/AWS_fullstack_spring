package co.jmymble.domain;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.Data;

@Data
public class RestAurant2 {
	@Autowired
	private Chef2 chef2;
}
