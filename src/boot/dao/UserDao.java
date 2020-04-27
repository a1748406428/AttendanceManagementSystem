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
	//查询
	UserBean selectByAll(@Param("name") String name);
	//增加
	int insertUser(UserBean userBean);
	//修改
	int updateById(int id);
	//删除
	int deleteById(int id);
	//根据省份ID查询市
	List<CityBean> selectCityNameByPid(@RequestParam("pid") int pid);
	//根据是ID查询区县
	List<TownBean> selectTownNameByCid(@RequestParam("cid") int id);
	//查询数据库中的姓名和密码
//	MannagerPwdBean selectByNamePwd(MannagerPwdBean namePwdBean);
}
