package co.jmymble.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import co.jmymble.domain.SampleDTO;
import co.jmymble.domain.SampleDTOList;
import co.jmymble.domain.TodoDTO;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("sample/*")
@Log4j
//@Log
public class SampleController {
	@GetMapping()
	public void basic() {
		log.warn("basic()");
	}

	@RequestMapping(path={"aaa", "bbb"}, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, 
			method = {RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public Object basic2() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("ab", 12345);
		map.put("c", 12345);
		map.put("d", 12345);
		return map;
	}
	
	@GetMapping("ex01")
	public void ex01(SampleDTO dto, String name, @RequestParam("age") Integer number) {
		log.warn(dto);
		log.warn(name);
		log.warn(number);
	}
	
	@GetMapping("ex02List")
	public void ex02List(@RequestParam("ids") List<String> ids) {
		log.info(ids);
		log.info(ids.getClass().getSimpleName());
	}
	@GetMapping("ex02Array")
	public void ex02Array(@RequestParam(value="ids", defaultValue = "") String[] ids) {
		log.info(Arrays.toString(ids));
		log.info(ids.getClass().getSimpleName());
	}
	@GetMapping("ex02Bean")
	public void ex02Bean(SampleDTOList list) {
		log.info(list);
		list.getList().forEach(log::info);
		//첨부 파일에서 사용
		//Board >> List<Attach>
//		list%5b0%5d.name=aaa 
//		list[0].name=aaa&list[10].name=bbb -> console에서 encodeURIComponent에 문자열 형태로 태우면 변환이 된다. 
//		list[1].age=20&list[2].name=aaa
	}
	@GetMapping("ex03")
	public void ex03(TodoDTO dto, Model model, @ModelAttribute("dueDate") String dueDate, 
			@ModelAttribute("myAge") int age) {
		log.info(dto);
		log.info(dueDate);
//		log.info(req);
//		log.info(req.getParameter("dueDate"));
//		model.addAttribute("serverTime", new Date());
		
		log.info(model);
		log.info(model.getClass().getName());
	}
	
	@GetMapping("ex04")
	public String ex04(@ModelAttribute("myAge") int age, @RequestParam("myScore") Integer score, Model model) {
		//score
		model.addAttribute("myScore", score);
		return "/sample/ex03";
	}
	
	@GetMapping("ex04Result")
	public void ex04RediResult() {
	
	}
	
	@GetMapping("ex04Redi")
	public String ex04Redi(RedirectAttributes rttr) {
		rttr.addAttribute("name", "hong");
		rttr.addFlashAttribute("myAge", 30);
		rttr.addFlashAttribute("myScore", 100);
		return "redirect:/sample/ex04Result" + "?a=10";
	}
	
//	@InitBinder
//	public void initBinder(WebDataBinder binder) {
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, false));
//	}
	
	@GetMapping("ex06") @ResponseBody
	public SampleDTO ex06() {
		SampleDTO dto = new SampleDTO();
		dto.setAge(10);
		dto.setName("홍길동");
		return dto;
	}
	//아래와 같이 만든 뒤, 쿼리스트링으로 age와 name 값을 줄 수도 있다.
//	@GetMapping("ex06_")
//	@ResponseBody
//	public SampleDTO ex06_(SampleDTO dto) {
//		return dto;
//	}
	
	@GetMapping("exUpload")
	public void exUpload() {
		
	}

	@PostMapping("exUpload")
	public void exUploadResult(List<MultipartFile> files) {
		files.forEach(f -> {
			log.info(f.getOriginalFilename());
			log.info(f.getSize());
		});
	}
	
}
