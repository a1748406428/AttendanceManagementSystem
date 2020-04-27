package boot.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import boot.pojo.DepartInfoBean;
import boot.pojo.EmployeeBean;
import boot.pojo.PostBean;
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
}
