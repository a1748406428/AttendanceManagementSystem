package boot.service;

import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

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
	//���ܼӰ�����
	public void huiZongJiangLi(Map<String,Object> param);
	//��ѯ���ܽ�����Ա
	public Map<String,Object> selectJiangLiInFo(Map<String,Object> param);
	//��ѯƽ������
	public Map<String,Object> calculateAvgDailySal(Integer id,Integer jiabantianshu); 
	//�������
	public int updateJiangliZhuangTai(Integer id,String status,Float yingdejiangli);
}
