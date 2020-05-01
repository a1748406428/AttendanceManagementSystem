package boot.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import boot.pojo.EmpSalaryBean;
import boot.pojo.EmployeeBean;
import boot.pojo.NoticeBean;
import boot.pojo.TaskBean;
import boot.vo.YiXiangMessageBean;

@Repository
public interface GetEmpSelfInFoDao {
	//查询员工信息
	public EmployeeBean selectEmpSelfInFo(String gonghao);
	//查看个人广播消息
	public List<NoticeBean> selectPersonNotice(NoticeBean noticeBean);
	//查看个人私信
	public List<NoticeBean> selectPersonPrivateNotice(NoticeBean noticeBean);
	//查询员工的工资
	public List<EmpSalaryBean> selectEmpPersonSalary(String gonghao);
	//添加职位意向申请信息
	public int addInToPostApplicate(YiXiangMessageBean yiXiangMessageBean);
	//添加离职申请
	public int addReSignApplicate(YiXiangMessageBean yiXiangMessageBean);
	//实现一件打卡功能
	public void autoDaka(Map<String,Object> param);
	//查询员工 姓名
	public String selectEmpName(String gonghao);
	//查看任务
	public List<TaskBean> scanTasks(@Param("gonghao")String gonghao);
	//更新任务状态
	public Integer updateTaskProgress(@Param("id")Integer id,@Param("progress")String progress);
	//更新消息状态
	public int updatemsgstatus(@Param("id") Integer id,@Param("status") String status);
}
