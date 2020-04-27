package boot.service;

import java.util.List;
import java.util.Map;

import boot.pojo.KaoQinInfoBean;
import boot.pojo.KaoQinZongBiaoBean;
import boot.vo.KaoQinCountBean;

public interface KaoQinInfoService {
	//����ID��ѯÿ�����ŵĿ������
	List<KaoQinCountBean> selectDepKaoQin(Integer did1,Integer did2,Integer did3,
			Integer did4,Integer did5,Integer did6,
			String startTime, String endTime);
	//��ѯ��˾�����忼�����
	KaoQinCountBean selectCopKaoQin(String startTime, String endTime);
	//����ֶ�������
	Integer insertIntoAttdence(KaoQinInfoBean kaoQinInfo);
	//���¿�����Ϣ
	Integer updateAttedence(KaoQinInfoBean kaoQinInfo);
	//�鿴�����ܱ������
	public Map<String,Object> selectKaoQinZongBiao(Map<String,Object>param);
}
