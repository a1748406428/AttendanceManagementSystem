package boot.service;

import java.util.List;

import org.springframework.stereotype.Service;

import boot.po.NamePwdBean;
import boot.pojo.UserBean;
import boot.vo.CityBean;
import boot.vo.TownBean;
@Service
public interface UserService {
	//查询
	UserBean selectByAll(String name);
	//增加
	int insertIntoUser(UserBean userBean);
	//修改
	int updateUser();
	//删除
	int delete();
	//根据PID查询市返回List
	List<CityBean> selectCityByPid(int pid); 
	//根据CID查询市返回List
	List<TownBean> selectTownByCid(int cid); 
	//查询名字和密码
	boolean selectNamePwd(NamePwdBean namePwdBean);
}
