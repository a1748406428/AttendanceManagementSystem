package boot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import boot.dao.GetEmpSelfInFoDao;
import boot.pojo.EmpSalaryBean;
import boot.pojo.EmployeeBean;
import boot.pojo.NoticeBean;
import boot.service.GetEmpSelfInfoService;
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
	public EmpSalaryBean selectEmpPersonSalary(String gonghao) {
		try {
			EmpSalaryBean result = getEmpSelfInFoDao.selectEmpPersonSalary(gonghao);
			if(result!=null) {
				return result;
			}
		} catch (NullPointerException e) {
		}
		return null;
	}
	
}
