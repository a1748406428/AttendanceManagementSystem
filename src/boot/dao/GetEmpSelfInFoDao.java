package boot.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import boot.pojo.EmpSalaryBean;
import boot.pojo.EmployeeBean;
import boot.pojo.NoticeBean;
import boot.pojo.TaskBean;
import boot.vo.YiXiangMessageBean;

@Repository
public interface GetEmpSelfInFoDao {
	//��ѯԱ����Ϣ
	public EmployeeBean selectEmpSelfInFo(String gonghao);
	//�鿴���˹㲥��Ϣ
	public List<NoticeBean> selectPersonNotice(NoticeBean noticeBean);
	//�鿴����˽��
	public List<NoticeBean> selectPersonPrivateNotice(NoticeBean noticeBean);
	//��ѯԱ���Ĺ���
	public List<EmpSalaryBean> selectEmpPersonSalary(String gonghao);
	//���ְλ����������Ϣ
	public int addInToPostApplicate(YiXiangMessageBean yiXiangMessageBean);
	//�����ְ����
	public int addReSignApplicate(YiXiangMessageBean yiXiangMessageBean);
	//ʵ��һ���򿨹���
	public void autoDaka(Map<String,Object> param);
	//��ѯԱ�� ����
	public String selectEmpName(String gonghao);
	//�鿴����
	public List<TaskBean> scanTasks(@Param("gonghao")String gonghao);
	//��������״̬
	public Integer updateTaskProgress(@Param("id")Integer id,@Param("progress")String progress);
	//������Ϣ״̬
	public int updatemsgstatus(@Param("id") Integer id,@Param("status") String status);
}
