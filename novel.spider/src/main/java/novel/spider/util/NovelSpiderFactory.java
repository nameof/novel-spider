package novel.spider.util;

import novel.spider.configuration.NovelSiteEnum;
import novel.spider.impl.novel.BxwxNovelSpider;
import novel.spider.impl.novel.KanShuZhongNovelSpider;
import novel.spider.interfaces.INovelSpider;

/**
 * 生产书籍列表的实现类
 * @author LiuKeFeng
 * @date   2016年10月14日
 */
public final class NovelSpiderFactory {
	private NovelSpiderFactory() {}
	public static INovelSpider getNovelSpider(String url) {
		NovelSiteEnum novelSiteEnum = NovelSiteEnum.getEnumByUrl(url);
		switch (novelSiteEnum) {
		case Bxwx : return new BxwxNovelSpider();
		case KanShuZhong : return new KanShuZhongNovelSpider();
		default : throw new RuntimeException(url + "暂时不被支持");
		}
	}
}
