package boot.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import boot.pojo.DepartInfoBean;
import boot.pojo.EmployeeBean;
import boot.pojo.KaoHeInFoBean;
import boot.pojo.PostBean;
import boot.pojo.TaskBean;
import boot.vo.YiXiangMessageBean;


@Repository
public interface DepartInfoDao {
	//查询结果
	public List<DepartInfoBean> selectAllDepInFo(DepartInfoBean departInfoBean);
	//查询结果条数
	public Integer selectCount(DepartInfoBean departInfoBean);
	//修改部门信息
	public Integer updateDepInfo(DepartInfoBean departInfoBean);
	//删除部门
	public Integer deleteDepById(@Param("id")Integer id);
	//添加部门
	public Integer insertDep(DepartInfoBean departInfoBean);
	//查看意向书
	public List<YiXiangMessageBean> selectMessage(Map<String,Object> param);
	//查看申请意向书的条数
	public Integer selectMessageCount();
	//修改状态信息
	public Integer updateMessageStatus(@Param("eid")Integer eid,@Param("status")String status);
	//删除意向申请书信息
	public Integer deleteMsgByEid(Integer eid);
	//修改岗位信息
	public Integer updateEmpDepPostById(EmployeeBean employeeBean);
	//实现部门联动效果
	public List<PostBean> dynamicDepAndPost(Integer did);
	//查询部门工号
	public List<String> selectGongHao(@Param("did")Integer did);
	//任务分发
	public void addTask(TaskBean taskBean);
	//离职申请查看
	public List<YiXiangMessageBean> selectResignationApplicationMessage(Map<String,Object> param);
	//离职申请总数
	public Integer selectResignationApplicationMessageCount();
	//同意离职
	public int AgreeResign(@Param("eid")Integer eid,@Param("status")String status);
	//不同意离职
	public int UnAgreeResign(@Param("eid")Integer eid,@Param("status")String status);
	//根据部门和月份查询部门的出勤数
	public Integer selectChuQinCount(@Param("month")String month,@Param("departid")Integer departid);
	//查询部门应该出勤的人数
	public Integer selectTotalChuQinCount(@Param("month")String month,@Param("departid")Integer departid);
	//查看部门任务完成情况
	public String selectTaskProgress(@Param("month")String month,@Param("departid")Integer departid);
	//提交考核信息
	public int submitKaoHeInFo(KaoHeInFoBean kaoHeInFoBean);
	//查看考核汇总表
	public List<KaoHeInFoBean> selectKaoHeInFo(Map<String,Object> param);
	//考核汇总表的总数
	public Integer selectKaoHeInFoTotal(Map<String,Object> param);
}
