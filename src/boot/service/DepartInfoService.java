package boot.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import boot.page.utils.Page;
import boot.pojo.DepartInfoBean;
import boot.pojo.EmployeeBean;
import boot.pojo.PostBean;

@Service
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
}
