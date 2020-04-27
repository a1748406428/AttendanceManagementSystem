package boot.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import boot.po.MannagerPwdBean;
import boot.pojo.UserBean;
import boot.vo.CityBean;
import boot.vo.TownBean;

/**
 * @author ZXY
 *
 */
@Repository
public interface UserDao {
	//��ѯ
	UserBean selectByAll(@Param("name") String name);
	//����
	int insertUser(UserBean userBean);
	//�޸�
	int updateById(int id);
	//ɾ��
	int deleteById(int id);
	//����ʡ��ID��ѯ��
	List<CityBean> selectCityNameByPid(@RequestParam("pid") int pid);
	//������ID��ѯ����
	List<TownBean> selectTownNameByCid(@RequestParam("cid") int id);
	//��ѯ���ݿ��е�����������
//	MannagerPwdBean selectByNamePwd(MannagerPwdBean namePwdBean);
}
