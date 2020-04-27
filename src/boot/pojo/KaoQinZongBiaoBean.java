package boot.pojo;

public class KaoQinZongBiaoBean {
	private Integer id;
	private String name;
	private String checktime;
	private String startcheck;
	private String endcheck;
	private String absence;
	private String departname;
	private String postname;
	public KaoQinZongBiaoBean() {
		super();
	}
	public KaoQinZongBiaoBean(Integer id, String name, String checktime, String startcheck, String endcheck,
			String absence, String departname, String postname) {
		super();
		this.id = id;
		this.name = name;
		this.checktime = checktime;
		this.startcheck = startcheck;
		this.endcheck = endcheck;
		this.absence = absence;
		this.departname = departname;
		this.postname = postname;
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
	public String getChecktime() {
		return checktime;
	}
	public void setChecktime(String checktime) {
		this.checktime = checktime;
	}
	public String getStartcheck() {
		return startcheck;
	}
	public void setStartcheck(String startcheck) {
		this.startcheck = startcheck;
	}
	public String getEndcheck() {
		return endcheck;
	}
	public void setEndcheck(String endcheck) {
		this.endcheck = endcheck;
	}
	public String getAbsence() {
		return absence;
	}
	public void setAbsence(String absence) {
		this.absence = absence;
	}
	public String getDepartname() {
		return departname;
	}
	public void setDepartname(String departname) {
		this.departname = departname;
	}
	public String getPostname() {
		return postname;
	}
	public void setPostname(String postname) {
		this.postname = postname;
	}
	
}
