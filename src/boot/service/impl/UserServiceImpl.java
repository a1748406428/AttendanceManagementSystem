/**
 * 
 */
package boot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import boot.dao.UserDao;
import boot.po.MannagerPwdBean;
import boot.pojo.UserBean;
import boot.service.UserService;
import boot.vo.CityBean;
import boot.vo.TownBean;

/**
 * @author ����԰
 *
 */
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;
	@Override
	public UserBean selectByAll(String name) {
		UserBean userBean = userDao.selectByAll(name);
		return userBean;
	}
	@Override
	public int insertIntoUser(UserBean userBean) {
		int rows = userDao.insertUser(userBean);
		return rows;
	}

	@Override
	public int updateUser() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete() {
		// TODO Auto-generated method stub
		return 0;
	}
	//����pid��ѯ����
	@Override
	public List<CityBean> selectCityByPid(int pid) {
		List<CityBean> cityBean = userDao.selectCityNameByPid(pid);
		return cityBean;
	}
	//����cid��ѯ����
	@Override
	public List<TownBean> selectTownByCid(int cid) {
		List<TownBean> townBean = userDao.selectTownNameByCid(cid);
		return townBean;
	}
	//��ѯ���ֺ�����
//	@Override
//	public boolean selectNamePwd(MannagerPwdBean namePwdBean) {
//		MannagerPwdBean nameBean = userDao.selectByNamePwd(namePwdBean);
//		if(nameBean!=null) {
//			return true;
//		}
//		return false;
//	}
	@Override
	public boolean selectNamePwd(MannagerPwdBean namePwdBean) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
