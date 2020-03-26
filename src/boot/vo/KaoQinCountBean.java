package boot.vo;


public class KaoQinCountBean {
	private Integer zhengchang;
	private Integer queqin;
	private Integer chidao;
	public KaoQinCountBean() {
		super();
	}
	public KaoQinCountBean(Integer zhengchang, Integer queqin, Integer chidao) {
		super();
		this.zhengchang = zhengchang;
		this.queqin = queqin;
		this.chidao = chidao;
	}
	public Integer getZhengchang() {
		return zhengchang;
	}
	public void setZhengchang(Integer zhengchang) {
		this.zhengchang = zhengchang;
	}
	public Integer getQueqin() {
		return queqin;
	}
	public void setQueqin(Integer queqin) {
		this.queqin = queqin;
	}
	public Integer getChidao() {
		return chidao;
	}
	public void setChidao(Integer chidao) {
		this.chidao = chidao;
	}
	
}
