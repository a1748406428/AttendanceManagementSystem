package boot.vo;

import java.util.List;

public class KaoQinTongJiBean<T> {
	private Integer zhengchangCount;
	private Integer queqinCount;
	private Integer ChiDaoCount;
	private List<T> rows;
	public KaoQinTongJiBean() {
		super();
	}
	public KaoQinTongJiBean(Integer zhengchangCount, Integer queqinCount, Integer chiDaoCount, List<T> rows) {
		super();
		this.zhengchangCount = zhengchangCount;
		this.queqinCount = queqinCount;
		ChiDaoCount = chiDaoCount;
		this.rows = rows;
	}
	public Integer getZhengchangCount() {
		return zhengchangCount;
	}
	public void setZhengchangCount(Integer zhengchangCount) {
		this.zhengchangCount = zhengchangCount;
	}
	public Integer getQueqinCount() {
		return queqinCount;
	}
	public void setQueqinCount(Integer queqinCount) {
		this.queqinCount = queqinCount;
	}
	public Integer getChiDaoCount() {
		return ChiDaoCount;
	}
	public void setChiDaoCount(Integer chiDaoCount) {
		ChiDaoCount = chiDaoCount;
	}
	public List<T> getRows() {
		return rows;
	}
	public void setRows(List<T> rows) {
		this.rows = rows;
	}
	
}
