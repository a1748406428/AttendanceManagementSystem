package boot.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import boot.pojo.EmployeeBean;
@Repository
public interface EmployeeDao {
	//注册员工
	int insertEmp(EmployeeBean employeeBean);
	//查询所有员工信息
	List<EmployeeBean> selectAllEmp();
	//根据条件查询员工信息
	List<EmployeeBean> selectEmpByCon(EmployeeBean employeeBean);
	//查询客户总数
	public Integer selectEmpCount(EmployeeBean employeeBean);
	//删除信息
	int deleteEmpById(int id);
	//根据id修改信息
	int updateEmpById(EmployeeBean employeeBean);
}
