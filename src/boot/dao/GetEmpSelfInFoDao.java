package boot.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import boot.pojo.EmpSalaryBean;
import boot.pojo.EmployeeBean;
import boot.pojo.NoticeBean;

@Repository
public interface GetEmpSelfInFoDao {
	//查询员工信息
	public EmployeeBean selectEmpSelfInFo(String gonghao);
	//查看个人广播消息
	public List<NoticeBean> selectPersonNotice(NoticeBean noticeBean);
	//查看个人私信
	public List<NoticeBean> selectPersonPrivateNotice(NoticeBean noticeBean);
	//查询员工的工资
	public EmpSalaryBean selectEmpPersonSalary(String gonghao);
}
