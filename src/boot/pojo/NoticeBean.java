package boot.pojo;

public class NoticeBean {
	private Integer id;
	private String content;
	private String daytime;
	private String gonghao;
	public NoticeBean() {
		super();
	}
	public NoticeBean(Integer id, String content, String daytime, String gonghao) {
		super();
		this.id = id;
		this.content = content;
		this.daytime = daytime;
		this.gonghao = gonghao;
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
	public String getGonghao() {
		return gonghao;
	}
	public void setGonghao(String gonghao) {
		this.gonghao = gonghao;
	}
	
}
