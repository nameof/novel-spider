package novel.web.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import novel.spider.entitys.Chapter;
import novel.spider.entitys.ChapterDetail;
import novel.spider.interfaces.IChapterDetailSpider;
import novel.spider.interfaces.IChapterSpider;
import novel.spider.util.ChapterDetailSpiderFactory;
import novel.spider.util.ChapterSpiderFactory;
import novel.spider.util.NovelSpiderUtil;
import novel.web.entitys.JSONResponse;
import novel.web.service.NovelService;

@Controller
public class NovelController {
	@Resource
	private NovelService service;
	static {
		//NovelSpiderUtil.setConfigPath("D:/opt/web/novel.web/conf/Spider-Rule.xml");
	}
	@RequestMapping(value = "/test/chapters.do", method = RequestMethod.GET)
	@ResponseBody
	public JSONResponse getsChapter(String url) {
		IChapterSpider spider = ChapterSpiderFactory.getChapterSpider(url);
		List<Chapter> chapters = spider.getsChapter(url);
		return JSONResponse.success(chapters);
	}
	
	@RequestMapping(value = "/test/chapterDetail.do", method = RequestMethod.GET)
	@ResponseBody
	public JSONResponse getChapterDetail(String url) {
		IChapterDetailSpider spider = ChapterDetailSpiderFactory.getChapterDetailSpider(url);
		ChapterDetail detail = spider.getChapterDetail(url);
		return JSONResponse.success(detail);
	}
	
	@RequestMapping(value = "/novelSearch.do", method = RequestMethod.POST)
	@ResponseBody
	public JSONResponse getsNovelByKeyword(String keyword) throws UnsupportedEncodingException {
		return JSONResponse.success(service.getsNovelByKeyword(keyword));
	}
	
	@RequestMapping(value = "/novelSearch2.do", method = RequestMethod.POST)
	@ResponseBody
	public JSONResponse getsNovelByKeyword(String keyword, int platformId) throws UnsupportedEncodingException {
		return JSONResponse.success(service.getsNovelByKeyword(keyword, platformId));
	}
	
	@RequestMapping(value = "/chapterList.do", method = RequestMethod.GET)
	public ModelAndView showChapterList(String url) {
		ModelAndView view = new ModelAndView();
		view.setViewName("chapterList");
		view.getModel().put("chapters", ChapterSpiderFactory.getChapterSpider(url).getsChapter(url));
		view.getModel().put("baseUrl", url);
		return view;
	}
	
	@RequestMapping(value = "/chapterDetail.do", method = RequestMethod.GET)
	public ModelAndView showChapterDetail(String url, String baseUrl) {
		ModelAndView view = new ModelAndView();
		view.setViewName("chapterDetail");
		try {
			ChapterDetail detail = ChapterDetailSpiderFactory.getChapterDetailSpider(url).getChapterDetail(url);
			detail.setContent(detail.getContent().replaceAll("\n", "<br>"));
			view.getModel().put("chapterDetail", detail);
			view.getModel().put("isSuccess", true);
		} catch (Exception e) {
			e.printStackTrace();
			view.getModel().put("isSuccess", false);
		}
		view.getModel().put("baseUrl", baseUrl);
		return view;
	}
}
