package novel.spider.impl.chapter;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import novel.spider.entitys.Chapter;

public class BxwxChapterSpider extends AbstractChapterSpider {
	public List<Chapter> getsChapter(String url) {
		List<Chapter> chapters = super.getsChapter(url);
		Collections.sort(chapters, new Comparator<Chapter>() {
			@Override
			public int compare(Chapter o1, Chapter o2) {
				String o1Url = o1.getUrl();
				String o2Url = o2.getUrl();
				// 1234567890
				//我现在要 567 这三个字符串
				//substring("",0,1);
				String o1Index = o1Url.substring(o1Url.lastIndexOf('/') + 1, o1Url.lastIndexOf('.'));
				String o2Index = o2Url.substring(o2Url.lastIndexOf('/') + 1, o2Url.lastIndexOf('.'));
				return o1Index.compareTo(o2Index);
			}
		});
		return chapters;
	}
}
