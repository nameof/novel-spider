package novel.spider.configuration;

/**
 * XML≈‰÷√ µÃÂ¿‡
 * @author ChengPan
 */
public class SiteDefinition {
	
	private String siteName;
	
	private String charset;
	
	private String url;
	
	private String chapterListSelector;
	
	private String chapterDetailTitleSelector;
	
	private String chapterDetailContentSelector;
	
	private String chapterDetailPrevSelector;
	
	private String chapterDetailNextSelector;
	
	private String novelSelector;
	
	private String novelNextPageSelector;

	public String getSiteName() {
		return siteName;
	}

	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}

	public String getCharset() {
		return charset;
	}

	public void setCharset(String charset) {
		this.charset = charset;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getChapterListSelector() {
		return chapterListSelector;
	}

	public void setChapterListSelector(String chapterListSelector) {
		this.chapterListSelector = chapterListSelector;
	}

	public String getChapterDetailTitleSelector() {
		return chapterDetailTitleSelector;
	}

	public void setChapterDetailTitleSelector(String chapterDetailTitleSelector) {
		this.chapterDetailTitleSelector = chapterDetailTitleSelector;
	}

	public String getChapterDetailContentSelector() {
		return chapterDetailContentSelector;
	}

	public void setChapterDetailContentSelector(String chapterDetailContentSelector) {
		this.chapterDetailContentSelector = chapterDetailContentSelector;
	}

	public String getChapterDetailPrevSelector() {
		return chapterDetailPrevSelector;
	}

	public void setChapterDetailPrevSelector(String chapterDetailPrevSelector) {
		this.chapterDetailPrevSelector = chapterDetailPrevSelector;
	}

	public String getChapterDetailNextSelector() {
		return chapterDetailNextSelector;
	}

	public void setChapterDetailNextSelector(String chapterDetailNextSelector) {
		this.chapterDetailNextSelector = chapterDetailNextSelector;
	}

	public String getNovelSelector() {
		return novelSelector;
	}

	public void setNovelSelector(String novelSelector) {
		this.novelSelector = novelSelector;
	}

	public String getNovelNextPageSelector() {
		return novelNextPageSelector;
	}

	public void setNovelNextPageSelector(String novelNextPageSelector) {
		this.novelNextPageSelector = novelNextPageSelector;
	}

	@Override
	public String toString() {
		return "SiteDefinition [siteName=" + siteName + ", charset=" + charset
				+ ", url=" + url + ", chapterListSelector="
				+ chapterListSelector + ", chapterDetailTitleSelector="
				+ chapterDetailTitleSelector
				+ ", chapterDetailContentSelector="
				+ chapterDetailContentSelector + ", chapterDetailPrevSelector="
				+ chapterDetailPrevSelector + ", chapterDetailNextSelector="
				+ chapterDetailNextSelector + ", novelSelector="
				+ novelSelector + ", novelNextPageSelector="
				+ novelNextPageSelector + "]";
	}

}
