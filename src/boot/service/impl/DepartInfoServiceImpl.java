package boot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import boot.dao.DepartInfoDao;
import boot.page.utils.Page;
import boot.pojo.DepartInfoBean;
import boot.service.DepartInfoService;
@Service
public class DepartInfoServiceImpl implements DepartInfoService {
	@Autowired
	private DepartInfoDao departInfoDao;
	@Override
	public Page<DepartInfoBean> selectDepByCon(Integer page, Integer rows, DepartInfoBean departInfoBean) {
		//获取起始行
		departInfoBean.setStart((page-1)*rows);
		//设置每页的数
		departInfoBean.setRows(rows);
		//查询结果集
		List<DepartInfoBean> depBean = departInfoDao.selectAllDepInFo(departInfoBean);
		Integer count = departInfoDao.selectCount(departInfoBean);
		Page<DepartInfoBean> result = new Page<DepartInfoBean>();
		result.setPage(departInfoBean.getStart());
		result.setSize(departInfoBean.getRows());
		result.setRows(depBean);
		result.setTotal(count);
		return result;
	}
	//更新部门信息
	@Override
	public Integer updateDepInfoById(DepartInfoBean departInfoBean) {
		Integer updateDepInfo = departInfoDao.updateDepInfo(departInfoBean);
		if(updateDepInfo>0) {
			return updateDepInfo;
		}
		return null;
	}
	//删除部门
	@Override
	public Integer deleteDepById(Integer id) {
		Integer rows = departInfoDao.deleteDepById(id);
		if(rows>0) {
			return rows;
		}
		return null;
	}
	
}
