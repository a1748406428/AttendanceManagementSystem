package boot.vo;

public class YiXiangMessageBean {
	private Integer id;
	private String name;
	private String content;
	private String time;
	private Integer eid;
	private String status;
	public YiXiangMessageBean() {
		super();
	}
	public YiXiangMessageBean(Integer id, String name, String content, String time, Integer eid, String status) {
		super();
		this.id = id;
		this.name = name;
		this.content = content;
		this.time = time;
		this.eid = eid;
		this.status = status;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public Integer getEid() {
		return eid;
	}
	public void setEid(Integer eid) {
		this.eid = eid;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
