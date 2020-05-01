package boot.service;

import java.util.List;

import java.util.Map;
import boot.page.utils.Page;
import boot.pojo.DepartInfoBean;
import boot.pojo.EmployeeBean;
import boot.pojo.KaoHeInFoBean;
import boot.pojo.PostBean;
import boot.pojo.TaskBean;

public interface DepartInfoService {
	//根据条件查询部门信息 
	Page<DepartInfoBean> selectDepByCon(Integer page,Integer rows,DepartInfoBean departInfoBean);
	//更改部门信息
	Integer updateDepInfoById(DepartInfoBean departInfoBean);
	//删除部门信息
	Integer deleteDepById(Integer id);
	//添加部门信息
	Integer insertDepInFo(DepartInfoBean departInfoBean);
	//查看意向书
	Map<String, Object> selectMesg(Map<String, Object> param);
	//修改信息
	public Integer updateMsgStatus(Integer eid,String status);
	//删除单个信息
	public Integer deleteOneMsgByEid(Integer id);
	//修改员工岗位
	public Integer updateEmpDepPostById(EmployeeBean employeeBean);
	//岗位部门联动效果
	public List<PostBean> dynamicDepAndPost(Integer did);
	//计算工号
	public String calcullateGongHao(Integer did);
	//任务分发
	public void taskSend(TaskBean taskBean);
	//查看离职申请
	public Map<String,Object> selectResignApp(Map<String,Object> param);
	//更新离职信息
	public boolean updateResignStatus(Integer eid,String status); 
	//计算部门出勤率
	public String calculDepartAtt(String month,Integer departid);
	//查看任务完成度
	public String selectTaskProgress(String month,Integer departid);
	//提交考核情况
	public int submitKaoHeBiao(KaoHeInFoBean kaoHeInFoBean);
	//查看考核汇总表
	public Map<String,Object> selectKaoHeSum(Map<String,Object> param);
}
