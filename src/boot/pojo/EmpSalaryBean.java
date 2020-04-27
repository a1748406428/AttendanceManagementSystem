package boot.pojo;

public class EmpSalaryBean {
	private Integer id;
	private String name;
	private String postname;
	private String month;
	private String totalsalary;
	private String jiabangongzi;
	private String tax;
	private String endsalary;
	public EmpSalaryBean() {
		super();
	}
	public EmpSalaryBean(Integer id, String name, String postname, String month, String totalsalary,
			String jiabangongzi, String tax, String endsalary) {
		super();
		this.id = id;
		this.name = name;
		this.postname = postname;
		this.month = month;
		this.totalsalary = totalsalary;
		this.jiabangongzi = jiabangongzi;
		this.tax = tax;
		this.endsalary = endsalary;
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
	public String getPostname() {
		return postname;
	}
	public void setPostname(String postname) {
		this.postname = postname;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getTotalsalary() {
		return totalsalary;
	}
	public void setTotalsalary(String totalsalary) {
		this.totalsalary = totalsalary;
	}
	public String getJiabangongzi() {
		return jiabangongzi;
	}
	public void setJiabangongzi(String jiabangongzi) {
		this.jiabangongzi = jiabangongzi;
	}
	public String getTax() {
		return tax;
	}
	public void setTax(String tax) {
		this.tax = tax;
	}
	public String getEndsalary() {
		return endsalary;
	}
	public void setEndsalary(String endsalary) {
		this.endsalary = endsalary;
	}
	
}
