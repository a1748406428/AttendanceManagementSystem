package boot.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import boot.dao.DailyMannageDao;
import boot.pojo.JiTiJiaTiaoBean;
import boot.pojo.JiaTiaoBean;
import boot.pojo.JiangLiInFoBean;
import boot.service.DailyMannageService;

@Service
@Transactional
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
	//汇总奖励条数
	@Override
	public void huiZongJiangLi(Map<String, Object> param) {
		dailyMannageDao.addIntoJiaBanCount(param);
	}
	//查寻奖励者人数
	@Override
	public Map<String, Object> selectJiangLiInFo(Map<String, Object> param) {
		Map<String,Object> map = new HashMap<String,Object>();
		List<JiangLiInFoBean> result = dailyMannageDao.selectJiangLiInFo(param);
		Integer count = dailyMannageDao.jiangLiTotalCount();
		map.put("data", result);
		map.put("total", count);
		return map;
	}
	@Override
	public Map<String,Object> calculateAvgDailySal(Integer id,Integer jiabantianshu) {
		Map<String,Object> map = new HashMap<String,Object>();
		String basesal =  dailyMannageDao.selectEmpBaseSalary(id);
		float avgDailySal = Integer.parseInt(basesal)/30;
		float jiangli = avgDailySal*jiabantianshu;
		map.put("avgDailySal", avgDailySal);
		map.put("jiangli", jiangli);
		return map;
	}
	//审核奖励
	@Override
	public int updateJiangliZhuangTai(Integer id, String status, Float yingdejiangli) {
		String tempyingdejiangli = yingdejiangli.toString();
		int rows = dailyMannageDao.updateJiangLiInFo(id, status,tempyingdejiangli);
		if(rows>0)
			return rows;
		return 0;
	}
	
}
