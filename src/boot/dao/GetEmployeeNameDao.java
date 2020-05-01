package boot.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import boot.po.EmployeePwdBean;
import boot.po.MannagerPwdBean;
@Repository
public interface GetEmployeeNameDao {
	public List<EmployeePwdBean> getEmployeePwd();
	//查询员工工号和密码
	public EmployeePwdBean selectGonghaoAndPwd(EmployeePwdBean employeePwdBean);
	//查询管理员账号和
	public MannagerPwdBean selectMannagePhoneAndPwd(MannagerPwdBean mannagerPwdBean);
	//查询管理员姓名
	public String selectManName(String phone);
}
