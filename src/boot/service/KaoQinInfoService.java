package boot.service;

import java.util.List;
import org.springframework.stereotype.Service;

import boot.pojo.KaoQinInfoBean;
import boot.vo.KaoQinCountBean;

@Service
public interface KaoQinInfoService {
	//根据ID查询每个部门的考勤情况
	List<KaoQinCountBean> selectDepKaoQin(Integer did1,Integer did2,Integer did3,
			Integer did4,Integer did5,Integer did6,
			String startTime, String endTime);
	//查询公司的总体考情情况
	KaoQinCountBean selectCopKaoQin(String startTime, String endTime);
	//添加手动开考勤
	Integer insertIntoAttdence(KaoQinInfoBean kaoQinInfo);
}
