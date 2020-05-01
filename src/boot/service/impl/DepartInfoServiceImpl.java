package boot.service.impl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import boot.dao.DepartInfoDao;
import boot.page.utils.Page;
import boot.pojo.DepartInfoBean;
import boot.pojo.EmployeeBean;
import boot.pojo.KaoHeInFoBean;
import boot.pojo.PostBean;
import boot.pojo.TaskBean;
import boot.service.DepartInfoService;
import boot.vo.YiXiangMessageBean;

@Service
public class DepartInfoServiceImpl implements DepartInfoService {
	@Autowired
	private DepartInfoDao departInfoDao;

	@Override
	public Page<DepartInfoBean> selectDepByCon(Integer page, Integer rows, DepartInfoBean departInfoBean) {
		// 获取起始行
		departInfoBean.setStart((page - 1) * rows);
		// 设置每页的数
		departInfoBean.setRows(rows);
		// 查询结果集
		List<DepartInfoBean> depBean = departInfoDao.selectAllDepInFo(departInfoBean);
		Integer count = departInfoDao.selectCount(departInfoBean);
		Page<DepartInfoBean> result = new Page<DepartInfoBean>();
		result.setPage(departInfoBean.getStart());
		result.setSize(departInfoBean.getRows());
		result.setRows(depBean);
		result.setTotal(count);
		return result;
	}

	// 更新部门信息
	@Override
	public Integer updateDepInfoById(DepartInfoBean departInfoBean) {
		Integer updateDepInfo = departInfoDao.updateDepInfo(departInfoBean);
		if (updateDepInfo > 0) {
			return updateDepInfo;
		}
		return null;
	}

	// 删除部门
	@Override
	public Integer deleteDepById(Integer id) {
		Integer rows = departInfoDao.deleteDepById(id);
		if (rows > 0) {
			return rows;
		}
		return null;
	}

	// 添加部门信息
	@Override
	public Integer insertDepInFo(DepartInfoBean departInfoBean) {
		Integer rows = departInfoDao.insertDep(departInfoBean);
		if (rows > 0) {
			return rows;
		}
		return null;
	}

	// 查看收件箱
	@Override
	public Map<String, Object> selectMesg(Map<String, Object> param) {
		// 查询结果集
		List<YiXiangMessageBean> messageBean = departInfoDao.selectMessage(param);
		Integer count = departInfoDao.selectMessageCount();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("data", messageBean);
		map.put("total", count);
		return map;
	}
	//修改状态
	@Override
	public Integer updateMsgStatus(Integer eid,String status) {
		int rows = departInfoDao.updateMessageStatus(eid,status);
		if(rows>0) {
			return rows;
		}
		return 0;
	}
	//删除单个信息
	@Override
	public Integer deleteOneMsgByEid(Integer eid) {
		int rows = departInfoDao.deleteMsgByEid(eid);
		if(rows>0) {
			return rows;
		}
		return 0;
	}
	//修改员工信息
	@Override
	public Integer updateEmpDepPostById(EmployeeBean employeeBean) {
		int rows = departInfoDao.updateEmpDepPostById(employeeBean);
		if(rows > 0)
			return rows;
		return 0;
	}
	//部门岗位联动效果
	@Override
	public List<PostBean> dynamicDepAndPost(Integer did) {
		List<PostBean> results = departInfoDao.dynamicDepAndPost(did);
		if(!results.isEmpty()) {
			return results;
		}
		return null;
	}
	//计算工号
	/*	将工号放入集合中，遍历工号，找到集合中最大的工号然后+1
	 * */
	@Override
	public String calcullateGongHao(Integer did) {
		List<String> gongHao = departInfoDao.selectGongHao(did);
		int arraySize = gongHao.size();
		Integer[] tempArray = new Integer[arraySize];
		int i =0;
		for (Iterator iterator = gongHao.iterator(); iterator.hasNext();) {
			String strGongHao = (String) iterator.next();
			tempArray[i] = Integer.parseInt(strGongHao);
			i = i+1;
		}
		//求出数组最大值
		int max = tempArray[0];
		for(int j =1;j<tempArray.length;j++) {
			if(tempArray[j]>max) {
				max = tempArray[j];
			}
		}
		int intGonghao = max+1;
		String gonghao = String.valueOf(intGonghao);
		return gonghao;
	}
	//任务分发

	@Override
	public void taskSend(TaskBean taskBean) {
		departInfoDao.addTask(taskBean);
	}
	//查看离职申请

	@Override
	public Map<String, Object> selectResignApp(Map<String, Object> param) {
		Map<String,Object> map = new HashMap<String,Object>();
		List<YiXiangMessageBean> data = departInfoDao.selectResignationApplicationMessage(param);
		Integer total = departInfoDao.selectResignationApplicationMessageCount();
		map.put("data", data);
		map.put("total", total);
		return map;
	}
	//更新离职申请单状态信息

	@Override
	public boolean updateResignStatus(Integer eid,String status) {
		int row1 = departInfoDao.AgreeResign(eid,status);
		int row2 = departInfoDao.UnAgreeResign(eid,status);
		if(row1>0 || row2 > 0) {
			return true;
		}
		return false;
	}
	//计算部门出勤率

	@Override
	public String calculDepartAtt(String month, Integer departid) {
		Integer count = departInfoDao.selectChuQinCount(month, departid);
		Integer totalcount = departInfoDao.selectTotalChuQinCount(month, departid);
		System.out.println(count);
		System.out.println(totalcount);
		
		float flchuqinlv = ((float)count/(float)totalcount)*100;
		System.out.println(flchuqinlv);
		String strchuqinlv = String.valueOf(flchuqinlv);
		return strchuqinlv;
	}
	//查看任务完成度
	@Override
	public String selectTaskProgress(String month, Integer departid) {
		String taskProgress = departInfoDao.selectTaskProgress(month, departid);
		return taskProgress;
	}
	//提交考核情况表

	@Override
	public int submitKaoHeBiao(KaoHeInFoBean kaoHeInFoBean) {
		int row = departInfoDao.submitKaoHeInFo(kaoHeInFoBean);
		if(row>0)
			return row;
		return 0;
	}
	//考核表

	@Override
	public Map<String, Object> selectKaoHeSum(Map<String, Object> param) {
		Map<String,Object> result = new HashMap<String,Object>();
		List<KaoHeInFoBean> data = departInfoDao.selectKaoHeInFo(param);
		Integer total = departInfoDao.selectKaoHeInFoTotal(param);
		result.put("data", data);
		result.put("total", total);
		return result;
	}
	
}
