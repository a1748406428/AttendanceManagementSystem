package boot.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import boot.pojo.DepartInfoBean;


@Repository
public interface DepartInfoDao {
	//查询结果
	public List<DepartInfoBean> selectAllDepInFo(DepartInfoBean departInfoBean);
	//查询结果条数
	public Integer selectCount(DepartInfoBean departInfoBean);
	//修改部门信息
	public Integer updateDepInfo(DepartInfoBean departInfoBean);
	//删除部门
	public Integer deleteDepById(@Param("id")Integer id);
}
