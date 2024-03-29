package kr.co.jmymble.jsp.domain;

import java.io.File;

import kr.co.jmymble.jsp.util.ParamSolver;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Attach {
	private String uuid;
	private String origin;
	private boolean image;
	private String path;
	private Long bno;
	
	public Attach(String uuid, String origin, boolean image, String path) {
		this.uuid = uuid;
		this.origin = origin;
		this.image = image;
		this.path = path;
	}
	
	public String getQueryString() {
		return String.format("%s=%s&%s=%s&%s=%s", "uuid", uuid, "origin", origin, "path", path);
	}
	
	public File getFile() {
		return getFile(false);
	}
	
	public File getFile(boolean thumb) {
		File file = null;
		
		//File객체 생성 후 스트링 뽑아내기
		file = new File(ParamSolver.UPLOAD_PATH, path);
		
		//파일명 중 마지막 .의 위치
		int dotIdx = origin.lastIndexOf(".");
		
		//확장자를 담을 변수
		String ext = "";
		
		//확장자 (문자열 결합을 통한 조합) 구하기
		if(dotIdx > -1) {
			ext = origin.substring(dotIdx); //.txt
		}
		file = new File(file, uuid + (thumb ? "_t" : "") + ext);
		return file;
		
	}
}
