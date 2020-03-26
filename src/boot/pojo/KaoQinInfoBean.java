package boot.pojo;

public class KaoQinInfoBean {
	private Integer id;
	private String checktime;
	private String startcheck;
	private String endcheck;
	private String absence;
	private Integer eid;
	private Integer postid;
	public KaoQinInfoBean() {
		super();
	}
	public KaoQinInfoBean(Integer id, String checktime, String startcheck, String endcheck, String absence, Integer eid,
			Integer postid) {
		super();
		this.id = id;
		this.checktime = checktime;
		this.startcheck = startcheck;
		this.endcheck = endcheck;
		this.absence = absence;
		this.eid = eid;
		this.postid = postid;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public Integer getEid() {
		return eid;
	}
	public void setEid(Integer eid) {
		this.eid = eid;
	}
	public Integer getPostid() {
		return postid;
	}
	public void setPostid(Integer postid) {
		this.postid = postid;
	}
	
}
