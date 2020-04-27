package boot.service;

import java.util.List;

import boot.pojo.EmpSalaryBean;
import boot.pojo.EmployeeBean;
import boot.pojo.NoticeBean;

public interface GetEmpSelfInfoService {
	//��ѯ�㲥��Ϣ
	public EmployeeBean selectEmpSelfInfo(String gonghao);
	//��ѯ��Ϣ
	public List<NoticeBean> selectPersonNotice(NoticeBean noticeBean);
	//��ѯ������Ϣ
	public List<NoticeBean> selectPersonPrivateNotice(NoticeBean noticeBean);
	//��ѯ���ʵ�
	public EmpSalaryBean selectEmpPersonSalary(String gonghao);
}
