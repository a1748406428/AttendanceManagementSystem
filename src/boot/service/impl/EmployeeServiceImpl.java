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
	// ע���Ա
	@Override
	public int insertEmpByEmp(EmployeeBean employeeBean) {
		int rows = employeeDao.insertEmp(employeeBean);
		if (rows > 0) {
			return rows;
		}
		return 0;
	}

//	��ѯ���г�Ա
	@Override
	public List<EmployeeBean> selectAllEmp() {
		List<EmployeeBean> employeeBean = employeeDao.selectAllEmp();
		if (employeeBean == null) {
			throw new RuntimeException("��ֵ�쳣");
		} else {
			return employeeBean;
		}
	}

	// ����������ѯԱ����Ϣ
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
		//��ȡ��ʼ��
		employeeBean.setStart((page-1)*rows);
		//ÿҳ��
		employeeBean.setRows(rows);
		List<EmployeeBean> employeeBeans = employeeDao.selectEmpByCon(employeeBean);
		Integer count = employeeDao.selectEmpCount(employeeBean);
//		����Page���󲢷���
		Page<EmployeeBean> result = new Page<>();
		result.setPage(page);
		result.setRows(employeeBeans);
		result.setSize(employeeBean.getRows());
		result.setTotal(count);
		return result;
	}
	//ע����Ա��

	@Override
	public int insertNewEmp(EmployeeBean employeeBean) {
		int row = employeeDao.addintoEmpTable(employeeBean);
		if (row>0)
			return row;
		return 0;
	}
	
}
