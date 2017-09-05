package novel.spider.impl.novel;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.select.Elements;

import novel.spider.NovelSiteEnum;
import novel.spider.entitys.Novel;
import novel.spider.util.NovelSpiderUtil;

/**
 * 看书中网站的书籍列表爬取
 * @author LiuKeFeng
 * @date   2016年10月14日
 */
public class KanShuZhongNovelSpider extends AbstractNovelSpider {

	@Override
	public List<Novel> getsNovel(String url, Integer maxTryTimes) {
		List<Novel> novels = new ArrayList<>();
		try {
			Elements trs = super.getsTr(url, maxTryTimes);
			for (int index = 1, size = trs.size() - 1; index < size; index++) {
				Elements tds = trs.get(index).getElementsByTag("td");
//				for (Element td : tds) {
//					System.out.println(td);
//				}
				Novel novel = new Novel();
				novel.setType(tds.first().text());
				novel.setName(tds.get(1).text());
				novel.setUrl(tds.get(1).getElementsByTag("a").first().absUrl("href"));
				novel.setLastUpdateChapter(tds.get(2).text());
				novel.setLastUpdateChapterUrl(tds.get(2).getElementsByTag("a").first().absUrl("href"));
				novel.setAuthor(tds.get(3).text());
				novel.setLastUpdateTime(NovelSpiderUtil.getDate(tds.get(4).text(), "MM-dd"));
				novel.setStatus(NovelSpiderUtil.getNovelStatus(tds.get(5).text()));
				novel.setPlatformId(NovelSiteEnum.getEnumByUrl(url).getId());
				novels.add(novel);
			}
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return novels;
	}

}
