package boot.pojo;

public class EmployeeBean {
	private Integer id;
	private String name;
	private String gonghao;
	private String education;
	private String sex;
	private Integer age;
	private String address;
	private String phone;
	private String basesalary;
	private String entrytime;
	private String depname;
	private Integer departid;
	private Integer postid;
	private String postname;
	private Integer gongling;
	private String level;
	private String politicalstatus;
	private Integer start;//起始行
	private Integer rows;//所取行数
	public EmployeeBean() {
		super();
	}
	public EmployeeBean(Integer id, String name, String gonghao, String education, String sex, Integer age,
			String address, String phone, String basesalary, String entrytime, String depname, Integer departid,
			Integer postid, String postname, Integer gongling, String level, String politicalstatus, Integer start,
			Integer rows) {
		super();
		this.id = id;
		this.name = name;
		this.gonghao = gonghao;
		this.education = education;
		this.sex = sex;
		this.age = age;
		this.address = address;
		this.phone = phone;
		this.basesalary = basesalary;
		this.entrytime = entrytime;
		this.depname = depname;
		this.departid = departid;
		this.postid = postid;
		this.postname = postname;
		this.gongling = gongling;
		this.level = level;
		this.politicalstatus = politicalstatus;
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
	public String getGonghao() {
		return gonghao;
	}
	public void setGonghao(String gonghao) {
		this.gonghao = gonghao;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getBasesalary() {
		return basesalary;
	}
	public void setBasesalary(String basesalary) {
		this.basesalary = basesalary;
	}
	public String getEntrytime() {
		return entrytime;
	}
	public void setEntrytime(String entrytime) {
		this.entrytime = entrytime;
	}
	public String getDepname() {
		return depname;
	}
	public void setDepname(String depname) {
		this.depname = depname;
	}
	public Integer getDepartid() {
		return departid;
	}
	public void setDepartid(Integer departid) {
		this.departid = departid;
	}
	public Integer getPostid() {
		return postid;
	}
	public void setPostid(Integer postid) {
		this.postid = postid;
	}
	public String getPostname() {
		return postname;
	}
	public void setPostname(String postname) {
		this.postname = postname;
	}
	public Integer getGongling() {
		return gongling;
	}
	public void setGongling(Integer gongling) {
		this.gongling = gongling;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getPoliticalstatus() {
		return politicalstatus;
	}
	public void setPoliticalstatus(String politicalstatus) {
		this.politicalstatus = politicalstatus;
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
