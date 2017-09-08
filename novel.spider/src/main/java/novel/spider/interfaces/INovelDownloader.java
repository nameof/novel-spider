package novel.spider.interfaces;

import novel.spider.configuration.Configuration;

public interface INovelDownloader {
	/**
	 * 比如说我下载到D:/novel/biquge.tw/完美世界/完美世界.txt
	 * @param url 这个url是指某本小说的章节列表页面
	 * @return
	 */
	public String download(String url, Configuration config);
}
