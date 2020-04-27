package boot.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import boot.pojo.EmpSalaryBean;
import boot.pojo.EmployeeBean;
import boot.pojo.NoticeBean;

@Repository
public interface GetEmpSelfInFoDao {
	//��ѯԱ����Ϣ
	public EmployeeBean selectEmpSelfInFo(String gonghao);
	//�鿴���˹㲥��Ϣ
	public List<NoticeBean> selectPersonNotice(NoticeBean noticeBean);
	//�鿴����˽��
	public List<NoticeBean> selectPersonPrivateNotice(NoticeBean noticeBean);
	//��ѯԱ���Ĺ���
	public EmpSalaryBean selectEmpPersonSalary(String gonghao);
}
