package boot.service;

import java.util.List;

import org.springframework.stereotype.Service;

import boot.page.utils.Page;
import boot.pojo.EmployeeBean;

@Service
public interface EmployeeService {
	// ����Ա����Ϣ
	int insertEmpByEmp(EmployeeBean employeeBean);

	// ��ѯ����Ա��
	List<EmployeeBean> selectAllEmp();

	// ����������ѯ
	List<EmployeeBean> selectEmpByCon(EmployeeBean employeeBean);
	
	//����idɾ��Ա����Ϣ
	int deleteById(int id);
	
	//����id�޸�Ա����Ϣ
	int updateById(EmployeeBean employeeBean);
	
	//
	public Page<EmployeeBean> findEmp(Integer page,Integer rows,EmployeeBean employeeBean);
	
	//ע����Ա��
	public int insertNewEmp(EmployeeBean employeeBean);
}
