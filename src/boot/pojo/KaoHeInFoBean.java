package boot.pojo;

public class KaoHeInFoBean {
	private Integer id;
	private String month;
	private Integer depid;
	private float totalgoal;
	private String attratio;
	private String progressschedule;
	private String jixiao;
	private String depname;
	public KaoHeInFoBean() {
		super();
	}
	public KaoHeInFoBean(Integer id, String month, Integer depid, float totalgoal, String attratio,
			String progressschedule, String jixiao, String depname) {
		super();
		this.id = id;
		this.month = month;
		this.depid = depid;
		this.totalgoal = totalgoal;
		this.attratio = attratio;
		this.progressschedule = progressschedule;
		this.jixiao = jixiao;
		this.depname = depname;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public Integer getDepid() {
		return depid;
	}
	public void setDepid(Integer depid) {
		this.depid = depid;
	}
	public float getTotalgoal() {
		return totalgoal;
	}
	public void setTotalgoal(float totalgoal) {
		this.totalgoal = totalgoal;
	}
	public String getAttratio() {
		return attratio;
	}
	public void setAttratio(String attratio) {
		this.attratio = attratio;
	}
	public String getProgressschedule() {
		return progressschedule;
	}
	public void setProgressschedule(String progressschedule) {
		this.progressschedule = progressschedule;
	}
	public String getJixiao() {
		return jixiao;
	}
	public void setJixiao(String jixiao) {
		this.jixiao = jixiao;
	}
	public String getDepname() {
		return depname;
	}
	public void setDepname(String depname) {
		this.depname = depname;
	}
}
