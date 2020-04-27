package boot.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import boot.dao.EmpSumAndSelectDao;
import boot.pojo.EmpSalaryBean;
import boot.service.EmpSalarySumService;
@Service
@Transactional
public class EmpSalarySumServiceImpl implements EmpSalarySumService {
	@Autowired
	private EmpSumAndSelectDao empSumAndSelectDao;
	//计算工资
	@Override
	public void sumEmpSalary(Map<String, Object> param) {
		empSumAndSelectDao.sumSalary(param);
	}
	//查询员工的工资
	@Override
	public Map<String, Object> selectEmpSalary(Map<String, Object> param) {
		Map<String,Object> results = new HashMap<String,Object>();
		List<EmpSalaryBean> result = empSumAndSelectDao.selectEmpSalary(param);
		Integer total = empSumAndSelectDao.selectEmpSalaryCount(param);
		results.put("total", total);
		results.put("data", result);
		return results;
	}
	//批量删除员工工资
	@Override
	public void deleteEmpSalary(Map<String,Object> param) {
		empSumAndSelectDao.deleteEmpEndSalary(param);
	}
	
}
