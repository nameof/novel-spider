package novel.spider.configuration;

import java.io.Serializable;

/**
 * @author LiuKeFeng
 * @date   2016年10月12日
 */
public class Configuration implements Serializable {
	private static final long serialVersionUID = 427742653911093147L;
	/**
	 * 每个线程默认可以下载的最大章节数量
	 */
	public static final int DEFAULT_SIZE = 100;
	/**
	 * 每个线程下载每一章所允许的最大尝试次数
	 */
	public static final int DEFAULT_TRY_TIMES = 3;
	/**
	 * 下载后的文件保存的基地址
	 * d:/opt/bxwx.org/完美世界/1-2.txt
	 * ....
	 */
	private String path;
	/**
	 * 每个线程能够下载的最大章节数量
	 */
	private int size;
	private int tryTimes;
	public Configuration() {
		this.size = DEFAULT_SIZE;
		this.tryTimes = DEFAULT_TRY_TIMES;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getTryTimes() {
		return tryTimes;
	}
	public void setTryTimes(int tryTimes) {
		this.tryTimes = tryTimes;
	}
	
}
