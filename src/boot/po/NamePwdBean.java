package boot.po;

public class NamePwdBean {
	private String name;
	private String password;
	public NamePwdBean() {
		super();
	}
	public NamePwdBean(String name, String password) {
		super();
		this.name = name;
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	};
	
}
