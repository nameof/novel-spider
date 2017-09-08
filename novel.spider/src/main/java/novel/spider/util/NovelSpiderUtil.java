package novel.spider.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import novel.spider.configuration.NovelSiteEnum;
import novel.spider.configuration.SiteDefinition;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public final class NovelSpiderUtil {
	private static final Map<NovelSiteEnum, SiteDefinition> CONTEXT_MAP = new HashMap<>();
	static {
		init();
	}
	private NovelSpiderUtil() {}
	
	@SuppressWarnings("unchecked")
	private static void init() {
		SAXReader reader = new SAXReader();
		try {
			Document doc = reader.read(NovelSpiderUtil.class.getResourceAsStream("/Spider-Rule.xml"));
			Element root = doc.getRootElement();
			List<Element> sites = root.elements("site");
			for (Element site : sites) {
				List<Element> subs = site.elements();
				SiteDefinition sd = new SiteDefinition();
				for (Element sub : subs) {
					String name = sub.getName();
					String text = sub.getTextTrim();
					populateSiteBean(sd, name, text);
				}
				CONTEXT_MAP.put(NovelSiteEnum.getEnumByUrl(sd.getUrl()), sd);
			}
		} catch (Exception e) {
			throw new RuntimeException("解析Spider-Rule.xml配置文件错误", e);
		}
	}
	
	private static void populateSiteBean(SiteDefinition sd, String name, String val) {
		switch (name) {
			case "title":
				sd.setSiteName(val);
				break;
			case "charset":
				sd.setCharset(val);
				break;
			case "url":
				sd.setUrl(val);
				break;
			case "chapter-list-selector":
				sd.setChapterListSelector(val);
				break;
			case "chapter-detail-title-selector":
				sd.setChapterDetailTitleSelector(val);
				break;
			case "chapter-detail-content-selector":
				sd.setChapterDetailContentSelector(val);
				break;
			case "chapter-detail-prev-selector":
				sd.setChapterDetailPrevSelector(val);
				break;
			case "chapter-detail-next-selector":
				sd.setChapterDetailNextSelector(val);
				break;
			case "novel-selector":
				sd.setNovelSelector(val);
				break;
			case "novel-next-page-selector":
				sd.setNovelNextPageSelector(val);
				break;
			default:
				throw new RuntimeException("unkown bean definition ：" + name);
		}
	}
	
	/**
	 * 拿到对应网站的解析规则
	 */
	public static SiteDefinition getContext(NovelSiteEnum novelSiteEnum) {
		return CONTEXT_MAP.get(novelSiteEnum);
	}
	
	/**
	 * 多个文件合并为一个文件，合并规则：按文件名分割排序
	 * @param path 基础目录，该根目录下的所有文本文件都会被合并到 mergeToFile
	 * @param mergeToFile 被合并的文本文件，这个参数可以为null,合并后的文件保存在path/merge.txt
	 */
	public static void multiFileMerge(String path, String mergeToFile, boolean deleteThisFile) {
		mergeToFile = mergeToFile == null ? path + "/merge.txt" : mergeToFile;
		File[] files = new File(path).listFiles(new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				return name.endsWith(".txt");
			}
		});
		Arrays.sort(files, new Comparator<File>() {
			@Override
			public int compare(File o1, File o2) {
				int o1Index = Integer.parseInt(o1.getName().split("\\-")[0]);
				int o2Index = Integer.parseInt(o2.getName().split("\\-")[0]);
				if (o1Index > o2Index) {
					return 1;
				} else if (o1Index == o2Index){
					return 0;
				} else {
					return -1;
				}
			}
		});
		PrintWriter out = null;
		try {
			out = new PrintWriter(new File(mergeToFile), "UTF-8");
			for (File file : files) {
				BufferedReader bufr = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));	
				String line = null;
				while ((line = bufr.readLine()) != null) {
					out.println(line);
				}
				bufr.close();
				
				if (deleteThisFile) {
					file.delete();
				}
			}
		} catch (IOException e1) {
			throw new RuntimeException(e1);
		} finally {
			out.close();
		}
	}
	
	/**
	 * 获取书籍的状态
	 * @param status
	 * @return
	 */
	public static int getNovelStatus(String status) {
		if (status.contains("连载")) {
			return 1;
		} else if (status.contains("完结") || status.contains("完成") || status.contains("完本")) {
			return 2;
		} else {
			throw new RuntimeException ("不支持的书籍状态：" + status);
		}
	}
	
	/**
	 * 格式化日期字符串为日期对象
	 * @param dateStr
	 * @param pattern
	 * @return
	 * @throws ParseException
	 */
	public static Date getDate(String dateStr, String pattern) throws ParseException {
		if ("MM-dd".equals(pattern)) {
			pattern = "yyyy-MM-dd";
			dateStr = getDateField(Calendar.YEAR) + "-" + dateStr;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		Date date = sdf.parse(dateStr);
		return date;
	}
	
	/**
	 * 获取本时刻的字符量
	 * @param field
	 * @return
	 */
	public static String getDateField(int field) {
		Calendar cal = new GregorianCalendar();
		return cal.get(field) + "";
	}
}
