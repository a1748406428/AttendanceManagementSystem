package boot.po;

public class EmployeePwdBean {
	private String empname;
	private String emppwd;
	private String empgonghao;
	public EmployeePwdBean() {
		super();
	}
	public EmployeePwdBean(String empname, String emppwd, String empgonghao) {
		super();
		this.empname = empname;
		this.emppwd = emppwd;
		this.empgonghao = empgonghao;
	}
	public String getEmpname() {
		return empname;
	}
	public void setEmpname(String empname) {
		this.empname = empname;
	}
	public String getEmppwd() {
		return emppwd;
	}
	public void setEmppwd(String emppwd) {
		this.emppwd = emppwd;
	}
	public String getEmpgonghao() {
		return empgonghao;
	}
	public void setEmpgonghao(String empgonghao) {
		this.empgonghao = empgonghao;
	}
}
