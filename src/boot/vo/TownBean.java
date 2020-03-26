package boot.vo;

public class TownBean {
	private int id;
	private String townname;
	private int cid;
	public TownBean() {
		super();
	}
	public TownBean(int id, String townname, int cid) {
		super();
		this.id = id;
		this.townname = townname;
		this.cid = cid;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTownname() {
		return townname;
	}
	public void setTownname(String townname) {
		this.townname = townname;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	
}
