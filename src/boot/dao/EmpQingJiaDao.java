package boot.dao;

import org.springframework.stereotype.Repository;

import boot.pojo.JiaTiaoBean;
@Repository
public interface EmpQingJiaDao {
	public int addEmpQingJia(JiaTiaoBean jiaTiaoBean);
	
}
