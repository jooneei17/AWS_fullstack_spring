package co.jmymble.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import co.jmymble.domain.Member;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
public class HelloController {
	@GetMapping("hello")
	public void hello(String str) {
		log.warn(str);
	}
	@GetMapping("bye")
	public void bye(Member member) {
		log.warn(member);
	}
}