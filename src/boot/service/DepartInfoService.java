package boot.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import boot.page.utils.Page;
import boot.pojo.DepartInfoBean;
import boot.pojo.EmployeeBean;
import boot.pojo.PostBean;

@Service
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
}
