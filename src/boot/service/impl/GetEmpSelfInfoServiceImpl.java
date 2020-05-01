package boot.service.impl;

import java.util.List;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import boot.dao.GetEmpSelfInFoDao;
import boot.pojo.EmpSalaryBean;
import boot.pojo.EmployeeBean;
import boot.pojo.NoticeBean;
import boot.pojo.TaskBean;
import boot.service.GetEmpSelfInfoService;
import boot.vo.YiXiangMessageBean;
@Service
public class GetEmpSelfInfoServiceImpl implements GetEmpSelfInfoService {
	@Autowired
	private GetEmpSelfInFoDao getEmpSelfInFoDao;
	
	@Override
	public EmployeeBean selectEmpSelfInfo(String gonghao){
		try {
			EmployeeBean employeeBean = getEmpSelfInFoDao.selectEmpSelfInFo(gonghao);
			if(employeeBean!=null) {
				return employeeBean;
			}
		} catch (NullPointerException e) {
			System.out.println("无结果");
		}
		return null;
	}
	//查询个人通知信息
	@Override
	public List<NoticeBean> selectPersonNotice(NoticeBean noticeBean) {
		try {
			List<NoticeBean> results = getEmpSelfInFoDao.selectPersonNotice(noticeBean);
			if(results!=null) {
				return results;
			}
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		return null;
	}
	//查询私信消息
	@Override
	public List<NoticeBean> selectPersonPrivateNotice(NoticeBean noticeBean) {
		try {			
			List<NoticeBean> results = getEmpSelfInFoDao.selectPersonPrivateNotice(noticeBean);
			if(results!=null) {
				return results;
			}
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		return null;
	}
	//查询个人工资单
	@Override
	public List<EmpSalaryBean> selectEmpPersonSalary(String gonghao) {
		try {
			List<EmpSalaryBean> result = getEmpSelfInFoDao.selectEmpPersonSalary(gonghao);
			if(result!=null) {
				return result;
			}
		} catch (NullPointerException e) {
		}
		return null;
	}
	//添加职位变更
	@Override
	public int addIntoPostChange(YiXiangMessageBean yiXiangMessageBean) {
		int rows = getEmpSelfInFoDao.addInToPostApplicate(yiXiangMessageBean);
		if(rows>0) {
			return rows;
		}
		return 0;
	}
	//添加离职申请
	@Override
	public int addIntoReSignationApplication(YiXiangMessageBean yiXiangMessageBean) {
		int row = getEmpSelfInFoDao.addReSignApplicate(yiXiangMessageBean);
		if(row>0) {
			return row;
		}
		return 0;
	}
	//实现一键打卡功能
	@Override
	public void autoDaka(Map<String, Object> param) {
		getEmpSelfInFoDao.autoDaka(param);
	}
	//查看任务中心
	@Override
	public List<TaskBean> selectTasks(String gonghao) {
		List<TaskBean> tasks = getEmpSelfInFoDao.scanTasks(gonghao);
		return tasks;
	}
	//更新任务状态消息
	@Override
	public int updateTaskProgress(Integer id, String progress) {
		Integer row = getEmpSelfInFoDao.updateTaskProgress(id, progress);
		if(row>0) {
			return row;
		}
		return 0;
	}
	
}
