package boot.service;
import boot.po.EmployeePwdBean;
import boot.po.MannagerPwdBean;

public interface LoginService {
	//�ж�Ա���˺ź�����
	public boolean makeSureNameAndPwd(EmployeePwdBean employeePwdBean);
	//�жϹ���Ա�˺ź�����
	public boolean makeSureMannagePhoneAndPwd(MannagerPwdBean mannagerPwdBean);
	
}
