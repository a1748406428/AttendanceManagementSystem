package boot.service;

import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public interface DailyMannageService {
	//�鿴�����������
	public Map<String,Object> browseQingJiaTiao(Map<String,Object> param);
	//�޸ļ���״̬
	public Integer updateJiaTiaoStatus(Integer id,String status);
	//�鿴�������
	public Map<String,Object> browseJiTiJiaTiao(Map<String,Object> param);
	//�޸ļ������״̬
	public Integer updateJiJiaTiaoStatus(Integer id,String status);
}
