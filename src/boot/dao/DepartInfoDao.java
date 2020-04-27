package boot.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import boot.pojo.DepartInfoBean;
import boot.pojo.EmployeeBean;
import boot.pojo.PostBean;
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
}
