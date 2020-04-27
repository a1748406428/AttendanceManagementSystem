package boot.service;

import java.util.List;

import boot.pojo.EmpSalaryBean;
import boot.pojo.EmployeeBean;
import boot.pojo.NoticeBean;

public interface GetEmpSelfInfoService {
	//查询广播信息
	public EmployeeBean selectEmpSelfInfo(String gonghao);
	//查询信息
	public List<NoticeBean> selectPersonNotice(NoticeBean noticeBean);
	//查询个人消息
	public List<NoticeBean> selectPersonPrivateNotice(NoticeBean noticeBean);
	//查询工资单
	public EmpSalaryBean selectEmpPersonSalary(String gonghao);
}
