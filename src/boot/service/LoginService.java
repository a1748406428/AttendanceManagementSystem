package boot.service;
import boot.po.EmployeePwdBean;
import boot.po.MannagerPwdBean;

public interface LoginService {
	//判断员工账号和密码
	public boolean makeSureNameAndPwd(EmployeePwdBean employeePwdBean);
	//判断管理员账号和密码
	public boolean makeSureMannagePhoneAndPwd(MannagerPwdBean mannagerPwdBean);
	
}
