package boot.service;

import java.util.Map;

import org.springframework.stereotype.Service;

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
}
