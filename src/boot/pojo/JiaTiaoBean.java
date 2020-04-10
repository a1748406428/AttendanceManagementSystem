package boot.pojo;

public class JiaTiaoBean {
	private Integer id;
	private String name;
	private String totalday;
	private String reason;
	private String daytime;
	private String togo;
	private String phone;
	private Integer eid;
	private String status;
	public JiaTiaoBean() {
		super();
	}
	public JiaTiaoBean(Integer id, String name, String totalday, String reason, String daytime, String togo,
			String phone, Integer eid, String status) {
		super();
		this.id = id;
		this.name = name;
		this.totalday = totalday;
		this.reason = reason;
		this.daytime = daytime;
		this.togo = togo;
		this.phone = phone;
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
	public String getTotalday() {
		return totalday;
	}
	public void setTotalday(String totalday) {
		this.totalday = totalday;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getDaytime() {
		return daytime;
	}
	public void setDaytime(String daytime) {
		this.daytime = daytime;
	}
	public String getTogo() {
		return togo;
	}
	public void setTogo(String togo) {
		this.togo = togo;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
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
