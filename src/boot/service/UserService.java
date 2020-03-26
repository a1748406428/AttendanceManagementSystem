package boot.service;

import java.util.List;

import org.springframework.stereotype.Service;

import boot.po.NamePwdBean;
import boot.pojo.UserBean;
import boot.vo.CityBean;
import boot.vo.TownBean;
@Service
public interface UserService {
	//��ѯ
	UserBean selectByAll(String name);
	//����
	int insertIntoUser(UserBean userBean);
	//�޸�
	int updateUser();
	//ɾ��
	int delete();
	//����PID��ѯ�з���List
	List<CityBean> selectCityByPid(int pid); 
	//����CID��ѯ�з���List
	List<TownBean> selectTownByCid(int cid); 
	//��ѯ���ֺ�����
	boolean selectNamePwd(NamePwdBean namePwdBean);
}
