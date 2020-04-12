package boot.service;

import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public interface DailyMannageService {
	//查看个人请假人数
	public Map<String,Object> browseQingJiaTiao(Map<String,Object> param);
	//修改假条状态
	public Integer updateJiaTiaoStatus(Integer id,String status);
	//查看集体加条
	public Map<String,Object> browseJiTiJiaTiao(Map<String,Object> param);
	//修改集体假条状态
	public Integer updateJiJiaTiaoStatus(Integer id,String status);
	//汇总加班人数
	public void huiZongJiangLi(Map<String,Object> param);
	//查询所受奖励人员
	public Map<String,Object> selectJiangLiInFo(Map<String,Object> param);
	//查询平均工资
	public Map<String,Object> calculateAvgDailySal(Integer id,Integer jiabantianshu); 
	//奖励审核
	public int updateJiangliZhuangTai(Integer id,String status,Float yingdejiangli);
}
