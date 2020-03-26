package boot.service;

import java.util.List;
import org.springframework.stereotype.Service;

import boot.pojo.KaoQinInfoBean;
import boot.vo.KaoQinCountBean;

@Service
public interface KaoQinInfoService {
	//����ID��ѯÿ�����ŵĿ������
	List<KaoQinCountBean> selectDepKaoQin(Integer did1,Integer did2,Integer did3,
			Integer did4,Integer did5,Integer did6,
			String startTime, String endTime);
	//��ѯ��˾�����忼�����
	KaoQinCountBean selectCopKaoQin(String startTime, String endTime);
	//����ֶ�������
	Integer insertIntoAttdence(KaoQinInfoBean kaoQinInfo);
}
