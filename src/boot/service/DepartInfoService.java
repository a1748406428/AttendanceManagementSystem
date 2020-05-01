package boot.service;

import java.util.List;

import java.util.Map;
import boot.page.utils.Page;
import boot.pojo.DepartInfoBean;
import boot.pojo.EmployeeBean;
import boot.pojo.KaoHeInFoBean;
import boot.pojo.PostBean;
import boot.pojo.TaskBean;

public interface DepartInfoService {
	//����������ѯ������Ϣ 
	Page<DepartInfoBean> selectDepByCon(Integer page,Integer rows,DepartInfoBean departInfoBean);
	//���Ĳ�����Ϣ
	Integer updateDepInfoById(DepartInfoBean departInfoBean);
	//ɾ��������Ϣ
	Integer deleteDepById(Integer id);
	//��Ӳ�����Ϣ
	Integer insertDepInFo(DepartInfoBean departInfoBean);
	//�鿴������
	Map<String, Object> selectMesg(Map<String, Object> param);
	//�޸���Ϣ
	public Integer updateMsgStatus(Integer eid,String status);
	//ɾ��������Ϣ
	public Integer deleteOneMsgByEid(Integer id);
	//�޸�Ա����λ
	public Integer updateEmpDepPostById(EmployeeBean employeeBean);
	//��λ��������Ч��
	public List<PostBean> dynamicDepAndPost(Integer did);
	//���㹤��
	public String calcullateGongHao(Integer did);
	//����ַ�
	public void taskSend(TaskBean taskBean);
	//�鿴��ְ����
	public Map<String,Object> selectResignApp(Map<String,Object> param);
	//������ְ��Ϣ
	public boolean updateResignStatus(Integer eid,String status); 
	//���㲿�ų�����
	public String calculDepartAtt(String month,Integer departid);
	//�鿴������ɶ�
	public String selectTaskProgress(String month,Integer departid);
	//�ύ�������
	public int submitKaoHeBiao(KaoHeInFoBean kaoHeInFoBean);
	//�鿴���˻��ܱ�
	public Map<String,Object> selectKaoHeSum(Map<String,Object> param);
}
