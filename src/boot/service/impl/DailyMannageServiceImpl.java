package boot.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import boot.dao.DailyMannageDao;
import boot.pojo.JiTiJiaTiaoBean;
import boot.pojo.JiaTiaoBean;
import boot.service.DailyMannageService;

@Service
public class DailyMannageServiceImpl implements DailyMannageService{
	@Autowired
	private DailyMannageDao dailyMannageDao;
	@Override
	public Map<String, Object> browseQingJiaTiao(Map<String, Object> param) {
		Map<String,Object> result = new HashMap<String, Object>();
		List<JiaTiaoBean> results = dailyMannageDao.selectPersonalQingjia(param);
		Integer totalCount = dailyMannageDao.selectPersonalJiaTiaoCount();
		result.put("data", results);
		result.put("total", totalCount);
		return result;
	}
	//修改假条状态
	@Override
	public Integer updateJiaTiaoStatus(Integer id, String status) {
		int rows = dailyMannageDao.updateJiaTiaoStatus(id, status);
		if(rows>0)
			return rows;
		return 0;
	}
	//查看集体假条状态
	@Override
	public Map<String, Object> browseJiTiJiaTiao(Map<String, Object> param) {
		Map<String,Object> result = new HashMap<String, Object>();
		List<JiTiJiaTiaoBean> results = dailyMannageDao.selectJiTiJiaTiao(param);
		Integer totalCount = dailyMannageDao.selectJiTiJiaTiaoCount();
		result.put("data", results);
		result.put("total", totalCount);
		return result;
	}
	@Override
	public Integer updateJiJiaTiaoStatus(Integer id, String status) {
		int rows = dailyMannageDao.updateJiTiJiaTiaoStatus(id, status);
		if(rows>0)
			return rows;
		return 0;
	}
	
}
