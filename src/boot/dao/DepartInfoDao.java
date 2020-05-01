package boot.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import boot.pojo.DepartInfoBean;
import boot.pojo.EmployeeBean;
import boot.pojo.KaoHeInFoBean;
import boot.pojo.PostBean;
import boot.pojo.TaskBean;
import boot.vo.YiXiangMessageBean;


@Repository
public interface DepartInfoDao {
	//��ѯ���
	public List<DepartInfoBean> selectAllDepInFo(DepartInfoBean departInfoBean);
	//��ѯ�������
	public Integer selectCount(DepartInfoBean departInfoBean);
	//�޸Ĳ�����Ϣ
	public Integer updateDepInfo(DepartInfoBean departInfoBean);
	//ɾ������
	public Integer deleteDepById(@Param("id")Integer id);
	//��Ӳ���
	public Integer insertDep(DepartInfoBean departInfoBean);
	//�鿴������
	public List<YiXiangMessageBean> selectMessage(Map<String,Object> param);
	//�鿴���������������
	public Integer selectMessageCount();
	//�޸�״̬��Ϣ
	public Integer updateMessageStatus(@Param("eid")Integer eid,@Param("status")String status);
	//ɾ��������������Ϣ
	public Integer deleteMsgByEid(Integer eid);
	//�޸ĸ�λ��Ϣ
	public Integer updateEmpDepPostById(EmployeeBean employeeBean);
	//ʵ�ֲ�������Ч��
	public List<PostBean> dynamicDepAndPost(Integer did);
	//��ѯ���Ź���
	public List<String> selectGongHao(@Param("did")Integer did);
	//����ַ�
	public void addTask(TaskBean taskBean);
	//��ְ����鿴
	public List<YiXiangMessageBean> selectResignationApplicationMessage(Map<String,Object> param);
	//��ְ��������
	public Integer selectResignationApplicationMessageCount();
	//ͬ����ְ
	public int AgreeResign(@Param("eid")Integer eid,@Param("status")String status);
	//��ͬ����ְ
	public int UnAgreeResign(@Param("eid")Integer eid,@Param("status")String status);
	//���ݲ��ź��·ݲ�ѯ���ŵĳ�����
	public Integer selectChuQinCount(@Param("month")String month,@Param("departid")Integer departid);
	//��ѯ����Ӧ�ó��ڵ�����
	public Integer selectTotalChuQinCount(@Param("month")String month,@Param("departid")Integer departid);
	//�鿴��������������
	public String selectTaskProgress(@Param("month")String month,@Param("departid")Integer departid);
	//�ύ������Ϣ
	public int submitKaoHeInFo(KaoHeInFoBean kaoHeInFoBean);
	//�鿴���˻��ܱ�
	public List<KaoHeInFoBean> selectKaoHeInFo(Map<String,Object> param);
	//���˻��ܱ������
	public Integer selectKaoHeInFoTotal(Map<String,Object> param);
}
