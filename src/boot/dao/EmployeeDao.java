package boot.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import boot.pojo.EmployeeBean;
@Repository
public interface EmployeeDao {
	//ע��Ա��
	int insertEmp(EmployeeBean employeeBean);
	//��ѯ����Ա����Ϣ
	List<EmployeeBean> selectAllEmp();
	//����������ѯԱ����Ϣ
	List<EmployeeBean> selectEmpByCon(EmployeeBean employeeBean);
	//��ѯ�ͻ�����
	public Integer selectEmpCount(EmployeeBean employeeBean);
	//ɾ����Ϣ
	int deleteEmpById(int id);
	//����id�޸���Ϣ
	int updateEmpById(EmployeeBean employeeBean);
}
