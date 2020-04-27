package boot.service;

import java.util.List;
import java.util.Map;

import boot.pojo.KaoQinInfoBean;
import boot.pojo.KaoQinZongBiaoBean;
import boot.vo.KaoQinCountBean;

public interface KaoQinInfoService {
	//根据ID查询每个部门的考勤情况
	List<KaoQinCountBean> selectDepKaoQin(Integer did1,Integer did2,Integer did3,
			Integer did4,Integer did5,Integer did6,
			String startTime, String endTime);
	//查询公司的总体考情情况
	KaoQinCountBean selectCopKaoQin(String startTime, String endTime);
	//添加手动开考勤
	Integer insertIntoAttdence(KaoQinInfoBean kaoQinInfo);
	//更新考勤信息
	Integer updateAttedence(KaoQinInfoBean kaoQinInfo);
	//查看考勤总表的内容
	public Map<String,Object> selectKaoQinZongBiao(Map<String,Object>param);
}
