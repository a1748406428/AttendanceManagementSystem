package boot.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import boot.pojo.EmpSalaryBean;

@Repository
public interface EmpSumAndSelectDao {
	//批量计算员工的工资
	public void sumSalary(Map<String,Object> param);
	//查询员工工资
	public List<EmpSalaryBean> selectEmpSalary(Map<String,Object> param);
	//查询总个数
	public Integer selectEmpSalaryCount(Map<String,Object> param);
	//批量删除员工工资
	public void deleteEmpEndSalary(Map<String,Object> param);
}
