package boot.pojo;

public class JiangLiInFoBean {
	private Integer id;
	private String ename;
	private String reason;
	private Integer totalday;
	private String jiangli;
	private String status;
	private String month;
	private Integer eid;
	public JiangLiInFoBean() {
		super();
	}
	public JiangLiInFoBean(Integer id, String ename, String reason, Integer totalday, String jiangli, String status,
			String month, Integer eid) {
		super();
		this.id = id;
		this.ename = ename;
		this.reason = reason;
		this.totalday = totalday;
		this.jiangli = jiangli;
		this.status = status;
		this.month = month;
		this.eid = eid;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public Integer getTotalday() {
		return totalday;
	}
	public void setTotalday(Integer totalday) {
		this.totalday = totalday;
	}
	public String getJiangli() {
		return jiangli;
	}
	public void setJiangli(String jiangli) {
		this.jiangli = jiangli;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public Integer getEid() {
		return eid;
	}
	public void setEid(Integer eid) {
		this.eid = eid;
	}
	
}
