package boot.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import boot.dao.GetEmployeeNameDao;
import boot.po.EmployeePwdBean;
import boot.po.MannagerPwdBean;
import boot.service.LoginService;
@Service
public class LoginServiceImpl implements LoginService {
	@Autowired
	private GetEmployeeNameDao getEmployeeNameDao;
	@Override
	public boolean makeSureNameAndPwd(EmployeePwdBean employeePwdBean) {
		EmployeePwdBean employeePwdBean2 = getEmployeeNameDao.selectGonghaoAndPwd(employeePwdBean);
		if(employeePwdBean2!=null) {
			return true;
		}else {
			return false;
		}
}
	//判断管理员账号和密码
	@Override
	public boolean makeSureMannagePhoneAndPwd(MannagerPwdBean mannagerPwdBean) {
		if(getEmployeeNameDao.selectMannagePhoneAndPwd(mannagerPwdBean)!=null) {
			return true;
		}
		return false;
	}
}
