package boot.service;

import org.springframework.stereotype.Service;

import boot.page.utils.Page;
import boot.pojo.DepartInfoBean;

@Service
public interface DepartInfoService {
	//根据条件查询部门信息 
	Page<DepartInfoBean> selectDepByCon(Integer page,Integer rows,DepartInfoBean departInfoBean);
	//更改部门信息
	Integer updateDepInfoById(DepartInfoBean departInfoBean);
	//删除部门信息
	Integer deleteDepById(Integer id);
}
