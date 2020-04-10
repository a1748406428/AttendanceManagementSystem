package boot.pojo;

public class JiTiJiaTiaoBean {
	private Integer id;
	private String departname;
	private String totalday;
	private String reason;
	private String daytime;
	private String togo;
	private String phone;
	private String leadername;
	private String status;
	public JiTiJiaTiaoBean() {
		super();
	}
	public JiTiJiaTiaoBean(Integer id, String departname, String totalday, String reason, String daytime, String togo,
			String phone, String leadername, String status) {
		super();
		this.id = id;
		this.departname = departname;
		this.totalday = totalday;
		this.reason = reason;
		this.daytime = daytime;
		this.togo = togo;
		this.phone = phone;
		this.leadername = leadername;
		this.status = status;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDepartname() {
		return departname;
	}
	public void setDepartname(String departname) {
		this.departname = departname;
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
	public String getLeadername() {
		return leadername;
	}
	public void setLeadername(String leadername) {
		this.leadername = leadername;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
