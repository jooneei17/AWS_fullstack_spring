package co.jmymble.persistence;

import java.io.File;
import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class ThumbnailTests {
	@Test
	public void testThumbnail() throws IOException{
		File file = new File("c:/upload/tj_text_sm.png");
		File file2 = new File("c:/upload/결과.png");
		Thumbnails.of(file).crop(Positions.CENTER).size(200, 200).toFile(file2);
	}

}
