package boot.service;

import java.util.List;

import java.util.Map;

import org.apache.ibatis.annotations.Param;

import boot.pojo.EmpSalaryBean;
import boot.pojo.EmployeeBean;
import boot.pojo.NoticeBean;
import boot.pojo.TaskBean;
import boot.vo.YiXiangMessageBean;

public interface GetEmpSelfInfoService {
	//查询广播信息
	public EmployeeBean selectEmpSelfInfo(String gonghao);
	//查询信息
	public List<NoticeBean> selectPersonNotice(NoticeBean noticeBean);
	//查询个人消息
	public List<NoticeBean> selectPersonPrivateNotice(NoticeBean noticeBean);
	//查询工资单
	public List<EmpSalaryBean> selectEmpPersonSalary(String gonghao);
	//添加职位变更申请单
	public int addIntoPostChange(YiXiangMessageBean yiXiangMessageBean);
	//添加离职申请单
	public int addIntoReSignationApplication(YiXiangMessageBean yiXiangMessageBean);
	//一键打卡
	public void autoDaka(Map<String,Object> param);
	//查看任务
	public List<TaskBean> selectTasks(String gonghao);
	//更新任务状态
	public int updateTaskProgress(Integer id,String progress);
}
