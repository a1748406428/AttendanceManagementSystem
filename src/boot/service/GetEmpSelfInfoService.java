package boot.service;

import java.util.List;

import java.util.Map;

import org.apache.ibatis.annotations.Param;

import boot.pojo.EmpSalaryBean;
import boot.pojo.EmployeeBean;
import boot.pojo.NoticeBean;
import boot.pojo.TaskBean;
import boot.vo.YiXiangMessageBean;

public interface GetEmpSelfInfoService {
	//��ѯ�㲥��Ϣ
	public EmployeeBean selectEmpSelfInfo(String gonghao);
	//��ѯ��Ϣ
	public List<NoticeBean> selectPersonNotice(NoticeBean noticeBean);
	//��ѯ������Ϣ
	public List<NoticeBean> selectPersonPrivateNotice(NoticeBean noticeBean);
	//��ѯ���ʵ�
	public List<EmpSalaryBean> selectEmpPersonSalary(String gonghao);
	//���ְλ������뵥
	public int addIntoPostChange(YiXiangMessageBean yiXiangMessageBean);
	//�����ְ���뵥
	public int addIntoReSignationApplication(YiXiangMessageBean yiXiangMessageBean);
	//һ����
	public void autoDaka(Map<String,Object> param);
	//�鿴����
	public List<TaskBean> selectTasks(String gonghao);
	//��������״̬
	public int updateTaskProgress(Integer id,String progress);
}
