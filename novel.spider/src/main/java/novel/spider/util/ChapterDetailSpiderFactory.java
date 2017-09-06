package novel.spider.util;

import novel.spider.configuration.NovelSiteEnum;
import novel.spider.impl.chapter.DefaultChapterDetailSpider;
import novel.spider.interfaces.IChapterDetailSpider;

public final class ChapterDetailSpiderFactory {
	private ChapterDetailSpiderFactory() {}
	/**
	 * 通过给定的url拿到实现了IChapterDetailSpider的具体实现类
	 * @param url
	 * @return
	 */
	public static IChapterDetailSpider getChapterDetailSpider(String url) {
		IChapterDetailSpider spider = null;
		NovelSiteEnum novelSiteEnum = NovelSiteEnum.getEnumByUrl(url);
		switch (novelSiteEnum) {
		case DingDianXiaoShuo :
		case BiQuGe :
		case KanShuZhong :
		case Bxwx :
			spider = new DefaultChapterDetailSpider();
			break;
		}
		return spider;
	}
}
