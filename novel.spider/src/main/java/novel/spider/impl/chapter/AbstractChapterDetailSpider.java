package novel.spider.impl.chapter;

import novel.spider.configuration.NovelSiteEnum;
import novel.spider.configuration.SiteDefinition;
import novel.spider.entitys.ChapterDetail;
import novel.spider.impl.AbstractSpider;
import novel.spider.interfaces.IChapterDetailSpider;
import novel.spider.util.NovelSpiderUtil;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public abstract class AbstractChapterDetailSpider extends AbstractSpider
		implements IChapterDetailSpider {

	@Override
	public ChapterDetail getChapterDetail(String url) {
		try {
			String result = super.crawl(url);
			result = result.replace("&nbsp;", " ").replace("<br />", "${line}")
					.replace("<br>", "${line}")
					.replace("<br/>", "${line}");
			Document doc = Jsoup.parse(result);
			doc.setBaseUri(url);

			SiteDefinition siteDefinition = NovelSpiderUtil
					.getContext(NovelSiteEnum.getEnumByUrl(url));

			ChapterDetail detail = new ChapterDetail();
			// 拿标题内容
			String titleSelector = siteDefinition
					.getChapterDetailTitleSelector();
			detail.setTitle(doc.select(titleSelector).first().text());

			// 拿章节内容
			String contentSelector = siteDefinition
					.getChapterDetailContentSelector();
			detail.setContent(doc.select(contentSelector).first().text()
					.replace("${line}", "\n"));

			// 拿前一章的地址
			String prevSelector = siteDefinition.getChapterDetailPrevSelector();
			detail.setPrev(doc.select(prevSelector).first().absUrl("href"));

			// 拿后一章的地址
			String nextSelector = siteDefinition.getChapterDetailNextSelector();
			detail.setNext(doc.select(nextSelector).first().absUrl("href"));

			return detail;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
