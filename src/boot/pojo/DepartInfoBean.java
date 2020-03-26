package boot.pojo;

public class DepartInfoBean {
	private Integer id;
	private String name;
	private String officelocal;
	private String performance;
	private String fuli;
	private Integer start;
	private Integer rows;
	public DepartInfoBean() {
		super();
	}
	public DepartInfoBean(Integer id, String name, String officelocal, String performance, String fuli, Integer start,
			Integer rows) {
		super();
		this.id = id;
		this.name = name;
		this.officelocal = officelocal;
		this.performance = performance;
		this.fuli = fuli;
		this.start = start;
		this.rows = rows;
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
	public String getOfficelocal() {
		return officelocal;
	}
	public void setOfficelocal(String officelocal) {
		this.officelocal = officelocal;
	}
	public String getPerformance() {
		return performance;
	}
	public void setPerformance(String performance) {
		this.performance = performance;
	}
	public String getFuli() {
		return fuli;
	}
	public void setFuli(String fuli) {
		this.fuli = fuli;
	}
	public Integer getStart() {
		return start;
	}
	public void setStart(Integer start) {
		this.start = start;
	}
	public Integer getRows() {
		return rows;
	}
	public void setRows(Integer rows) {
		this.rows = rows;
	}
	
	
}
