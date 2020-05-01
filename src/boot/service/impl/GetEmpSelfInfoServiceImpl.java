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
			System.out.println("�޽��");
		}
		return null;
	}
	//��ѯ����֪ͨ��Ϣ
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
	//��ѯ˽����Ϣ
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
	//��ѯ���˹��ʵ�
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
	//���ְλ���
	@Override
	public int addIntoPostChange(YiXiangMessageBean yiXiangMessageBean) {
		int rows = getEmpSelfInFoDao.addInToPostApplicate(yiXiangMessageBean);
		if(rows>0) {
			return rows;
		}
		return 0;
	}
	//�����ְ����
	@Override
	public int addIntoReSignationApplication(YiXiangMessageBean yiXiangMessageBean) {
		int row = getEmpSelfInFoDao.addReSignApplicate(yiXiangMessageBean);
		if(row>0) {
			return row;
		}
		return 0;
	}
	//ʵ��һ���򿨹���
	@Override
	public void autoDaka(Map<String, Object> param) {
		getEmpSelfInFoDao.autoDaka(param);
	}
	//�鿴��������
	@Override
	public List<TaskBean> selectTasks(String gonghao) {
		List<TaskBean> tasks = getEmpSelfInFoDao.scanTasks(gonghao);
		return tasks;
	}
	//��������״̬��Ϣ
	@Override
	public int updateTaskProgress(Integer id, String progress) {
		Integer row = getEmpSelfInFoDao.updateTaskProgress(id, progress);
		if(row>0) {
			return row;
		}
		return 0;
	}
	
}
