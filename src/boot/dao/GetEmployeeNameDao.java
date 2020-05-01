package boot.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import boot.po.EmployeePwdBean;
import boot.po.MannagerPwdBean;
@Repository
public interface GetEmployeeNameDao {
	public List<EmployeePwdBean> getEmployeePwd();
	//��ѯԱ�����ź�����
	public EmployeePwdBean selectGonghaoAndPwd(EmployeePwdBean employeePwdBean);
	//��ѯ����Ա�˺ź�
	public MannagerPwdBean selectMannagePhoneAndPwd(MannagerPwdBean mannagerPwdBean);
	//��ѯ����Ա����
	public String selectManName(String phone);
}
