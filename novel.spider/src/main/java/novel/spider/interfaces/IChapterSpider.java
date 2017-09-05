package novel.spider.interfaces;

import java.util.List;

import novel.spider.entitys.Chapter;

public interface IChapterSpider {
	/**
	 * 给我们一个完整的url，我们就给你返回所有的章节列表
	 * @param url
	 * @return
	 */
	public List<Chapter> getsChapter(String url);
}
