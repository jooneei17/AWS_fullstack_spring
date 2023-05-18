package co.jmymble.test;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
public class CommonController {
	@GetMapping("accessError")
	public void accessError(Authentication auth, Model model, Exception exception){
		log.warn("access denied");
		model.addAttribute("auth", auth);
		model.addAttribute("exception", exception);
	}
}
