package novel.spider.entitys;

import java.io.Serializable;
import java.util.Date;

/**
 * 小说实体
 * @author LiuKeFeng
 * @date   2016年10月14日
 */
public class Novel implements Serializable {
	private static final long serialVersionUID = 4834523404092493662L;
	/** 书名 */
	private String name;
	/** 作者名 */
	private String author;
	/** 小说的链接 */
	private String url;
	/** 小说的类别：如武侠修真，都市言情 */
	private String type;
	/** 最后一章的章节名 */
	private String lastUpdateChapter;
	/** 最后一章的链接 */
	private String lastUpdateChapterUrl;
	/** 小说最后更新的时间 */
	private Date lastUpdateTime;
	/** 小说的状态：1 连载 2 完结 */
	private int status;
	/** 书名的首字母 */
	private char firstLetter;
	/** 小说平台的id */
	private int platformId;
	/** 这本小说存储到我们数据库的时间 */
	private Date addTime;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getLastUpdateChapter() {
		return lastUpdateChapter;
	}
	public void setLastUpdateChapter(String lastUpdateChapter) {
		this.lastUpdateChapter = lastUpdateChapter;
	}
	public String getLastUpdateChapterUrl() {
		return lastUpdateChapterUrl;
	}
	public void setLastUpdateChapterUrl(String lastUpdateChapterUrl) {
		this.lastUpdateChapterUrl = lastUpdateChapterUrl;
	}
	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}
	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public char getFirstLetter() {
		return firstLetter;
	}
	public void setFirstLetter(char firstLetter) {
		this.firstLetter = firstLetter;
	}
	public int getPlatformId() {
		return platformId;
	}
	public void setPlatformId(int platformId) {
		this.platformId = platformId;
	}
	public Date getAddTime() {
		return addTime;
	}
	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}
	@Override
	public String toString() {
		return "Novel [name=" + name + ", author=" + author + ", url=" + url + ", type=" + type + ", lastUpdateChapter="
				+ lastUpdateChapter + ", lastUpdateChapterUrl=" + lastUpdateChapterUrl + ", lastUpdateTime="
				+ lastUpdateTime + ", status=" + status + ", firstLetter=" + firstLetter + ", platformId=" + platformId
				+ ", addTime=" + addTime + "]";
	}
}
