package boot.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import boot.dao.DepartInfoDao;
import boot.page.utils.Page;
import boot.pojo.DepartInfoBean;
import boot.pojo.EmployeeBean;
import boot.pojo.PostBean;
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
	
}
