package co.jmymble.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import co.jmymble.domain.AttachVO;
import co.jmymble.domain.BoardVO;
import co.jmymble.domain.Criteria;
import co.jmymble.domain.PageDto;
import co.jmymble.domain.SampleVO;
import co.jmymble.service.BoardService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("board/*")
@Data
public class BoardController {
	private final BoardService boardService; //final(초기화시 반드시 정의되어야 함)로 하면 알아서 필요한 생성자를 (@Data가) 만들어줌

	
	@GetMapping("list")
	public void list(Model model, Criteria cri) {
		log.info("list()");
		log.info(cri);
		model.addAttribute("list", boardService.getList(cri));
		model.addAttribute("page", new PageDto(boardService.getTotalCnt(cri), cri));
	}
	
	@GetMapping({"get", "modify"})
	public void get(Model model, Long bno, @ModelAttribute("cri") Criteria cri) {
		log.info("get() or modify()");
		log.info(bno);
		log.info(cri);
		model.addAttribute("board", boardService.get(bno));
		model.addAttribute("cri", cri);
	}
	
	@GetMapping("{bno}")
	public String getByPath(Model model, @PathVariable Long bno) {
		log.info("get() or modify()");
		log.info(bno);
		model.addAttribute("board", boardService.get(bno));
		return "board/get";
	}
	
	@GetMapping("register")
	public void register() {}
	
	@PostMapping("register")
	public String register(BoardVO vo, RedirectAttributes rttr, Criteria cri) {
		log.info("register");
		log.info(vo);
		boardService.register(vo);
		rttr.addFlashAttribute("result", vo.getBno());
		/*rttr.addAttribute("pageNum", 1);
		rttr.addAttribute("amount", cri.getAmount());*/
		return "redirect:/board/list" + cri.getFullQueryString();
	}
	
	@PostMapping("modify")
	public String modify(BoardVO vo, RedirectAttributes rttr, Criteria cri) {
		//원본 리스트
		List<AttachVO> originList = boardService.get(vo.getBno()).getAttachs();
		
		//수정 될 리스트
		List<AttachVO> list = vo.getAttachs(); 
		
		
		log.info("modify");
		log.info("Modify" + vo);
		log.info(cri);
		if(boardService.modify(vo)) {
			rttr.addFlashAttribute("result", "success");
//			originList.stream().filter(v -> {
//				boolean flag = false;
//				for(AttachVO vo2 : list) {
//					flag = vo2.getUuid().equals(v.getUuid()); 
//				}
//				return !flag;
//			}).forEach(boardService::deleteFile);
		
		}
		return "redirect:/board/list" + cri.getFullQueryString();
	}
	
	
	@PostMapping("remove")
	public String remove(Long bno, RedirectAttributes rttr, Criteria cri) {
		log.info("remove");
		log.info(bno);
		log.info(cri);
		List<AttachVO> list = boardService.get(bno).getAttachs();
		if(boardService.remove(bno)) {
//			list.forEach(boardService::deleteFile); //아래 향상for문과 같은 동작
			for(AttachVO vo : list){
				boardService.deleteFile(vo);
			}
			rttr.addFlashAttribute("result", "success");
		}
		return "redirect:/board/list" + cri.getFullQueryString();
	}
	
	@GetMapping("getSample")
	@ResponseBody
	public SampleVO getSampleVO() {
		return new SampleVO(112, "스타", "로드");
	}
}
