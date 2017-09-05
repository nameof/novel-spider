package novel.web.entitys;

public class JSONResponse {
	private int status;
	private String desc;
	private Object data;
	public static JSONResponse success(Object data) {
		JSONResponse response = new JSONResponse();
		response.setStatus(1);
		response.setData(data);
		return response;
	}
	public static JSONResponse error(String desc) {
		JSONResponse response = new JSONResponse();
		response.setStatus(0);
		response.setDesc(desc);
		return response;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "JSONResponse [status=" + status + ", desc=" + desc + ", data=" + data + "]";
	}
}
