package boot.service;

import java.util.List;

import boot.po.EmployeePwdBean;
import boot.po.MannagerPwdBean;

public interface LoginService {
	//�ж�Ա���˺ź�����
	public boolean makeSureNameAndPwd(EmployeePwdBean employeePwdBean);
	//�жϹ���Ա�˺ź�����
	public boolean makeSureMannagePhoneAndPwd(MannagerPwdBean mannagerPwdBean);
}
