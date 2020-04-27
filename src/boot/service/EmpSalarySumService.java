package boot.service;

import java.util.Map;

public interface EmpSalarySumService {
	public void sumEmpSalary(Map<String,Object>param);
	//查询员工工资
	public Map<String,Object> selectEmpSalary(Map<String,Object>param);
	//删除员工工资
	public void deleteEmpSalary(Map<String,Object>param);
}
