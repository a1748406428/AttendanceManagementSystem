package boot.service;

import java.util.List;

import org.springframework.stereotype.Service;

import boot.page.utils.Page;
import boot.pojo.EmployeeBean;

@Service
public interface EmployeeService {
	// 插入员工信息
	int insertEmpByEmp(EmployeeBean employeeBean);

	// 查询所有员工
	List<EmployeeBean> selectAllEmp();

	// 根据条件查询
	List<EmployeeBean> selectEmpByCon(EmployeeBean employeeBean);
	
	//根据id删除员工信息
	int deleteById(int id);
	
	//根据id修改员工信息
	int updateById(EmployeeBean employeeBean);
	
	//
	public Page<EmployeeBean> findEmp(Integer page,Integer rows,EmployeeBean employeeBean);
	
	//注册新员工
	public int insertNewEmp(EmployeeBean employeeBean);
}
