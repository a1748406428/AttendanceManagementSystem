package boot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import boot.dao.EmployeeDao;
import boot.page.utils.Page;
import boot.pojo.EmployeeBean;
import boot.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeDao employeeDao;
	// 注册成员
	@Override
	public int insertEmpByEmp(EmployeeBean employeeBean) {
		int rows = employeeDao.insertEmp(employeeBean);
		if (rows > 0) {
			return rows;
		}
		return 0;
	}

//	查询所有成员
	@Override
	public List<EmployeeBean> selectAllEmp() {
		List<EmployeeBean> employeeBean = employeeDao.selectAllEmp();
		if (employeeBean == null) {
			throw new RuntimeException("空值异常");
		} else {
			return employeeBean;
		}
	}

	// 根据条件查询员工信息
	@Override
	public List<EmployeeBean> selectEmpByCon(EmployeeBean employeeBean) {
		List<EmployeeBean> employeeBean2 = employeeDao.selectEmpByCon(employeeBean);
		return employeeBean2;
	}

	@Override
	public int deleteById(int id) {
		int rows = employeeDao.deleteEmpById(id);
		return rows;
	}

	@Override
	public int updateById(EmployeeBean employeeBean) {
		int rows = employeeDao.updateEmpById(employeeBean);
		return rows;
	}

	@Override
	public Page<EmployeeBean> findEmp(Integer page,Integer rows,EmployeeBean employeeBean) {
		//获取起始行
		employeeBean.setStart((page-1)*rows);
		//每页数
		employeeBean.setRows(rows);
		List<EmployeeBean> employeeBeans = employeeDao.selectEmpByCon(employeeBean);
		Integer count = employeeDao.selectEmpCount(employeeBean);
//		创建Page对象并返回
		Page<EmployeeBean> result = new Page<>();
		result.setPage(page);
		result.setRows(employeeBeans);
		result.setSize(employeeBean.getRows());
		result.setTotal(count);
		return result;
	}
	//注册新员工

	@Override
	public int insertNewEmp(EmployeeBean employeeBean) {
		int row = employeeDao.addintoEmpTable(employeeBean);
		if (row>0)
			return row;
		return 0;
	}
	
}
