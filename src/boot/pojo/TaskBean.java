package boot.pojo;

public class TaskBean {
	private Integer id;
	private String content;
	private String daytime; 
	private String deadline;
	private Integer leaderid;
	private String progress;
	public TaskBean() {
		super();
	}
	public TaskBean(Integer id, String content, String daytime, String deadline, Integer leaderid, String progress) {
		super();
		this.id = id;
		this.content = content;
		this.daytime = daytime;
		this.deadline = deadline;
		this.leaderid = leaderid;
		this.progress = progress;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getDaytime() {
		return daytime;
	}
	public void setDaytime(String daytime) {
		this.daytime = daytime;
	}
	public String getDeadline() {
		return deadline;
	}
	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}
	public Integer getLeaderid() {
		return leaderid;
	}
	public void setLeaderid(Integer leaderid) {
		this.leaderid = leaderid;
	}
	public String getProgress() {
		return progress;
	}
	public void setProgress(String progress) {
		this.progress = progress;
	}
	
}
