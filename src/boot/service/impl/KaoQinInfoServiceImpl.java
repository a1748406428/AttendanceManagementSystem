package boot.service.impl;
import java.util.ArrayList;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import boot.dao.KaoQinInfoDao;
import boot.pojo.KaoQinInfoBean;
import boot.service.KaoQinInfoService;
import boot.vo.KaoQinCountBean;
@Service
public class KaoQinInfoServiceImpl implements KaoQinInfoService {
	@Autowired
	private KaoQinInfoDao kaoQinInfoDao;
	@Override
	public List<KaoQinCountBean> selectDepKaoQin(Integer did1,Integer did2,Integer did3,
			Integer did4,Integer did5,Integer did6,
			String startTime, String endTime) 
	{
		KaoQinCountBean re1 = new KaoQinCountBean();
		re1.setZhengchang(kaoQinInfoDao.selectZcCount(did1,startTime,endTime));
		re1.setQueqin(kaoQinInfoDao.selectQqCount(did1,startTime,endTime));
		re1.setChidao(kaoQinInfoDao.selectCdCount(did1,startTime,endTime));
		KaoQinCountBean re2 = new KaoQinCountBean();
		re2.setZhengchang(kaoQinInfoDao.selectZcCount(did2,startTime,endTime));
		re2.setQueqin(kaoQinInfoDao.selectQqCount(did2,startTime,endTime));
		re2.setChidao(kaoQinInfoDao.selectCdCount(did2,startTime,endTime));
		KaoQinCountBean re3 = new KaoQinCountBean();
		re3.setZhengchang(kaoQinInfoDao.selectZcCount(did3,startTime,endTime));
		re3.setQueqin(kaoQinInfoDao.selectQqCount(did3,startTime,endTime));
		re3.setChidao(kaoQinInfoDao.selectCdCount(did3,startTime,endTime));
		KaoQinCountBean re4 = new KaoQinCountBean();
		re4.setZhengchang(kaoQinInfoDao.selectZcCount(did4,startTime,endTime));
		re4.setQueqin(kaoQinInfoDao.selectQqCount(did4,startTime,endTime));
		re4.setChidao(kaoQinInfoDao.selectCdCount(did4,startTime,endTime));
		KaoQinCountBean re5 = new KaoQinCountBean();
		re5.setZhengchang(kaoQinInfoDao.selectZcCount(did5,startTime,endTime));
		re5.setQueqin(kaoQinInfoDao.selectQqCount(did5,startTime,endTime));
		re5.setChidao(kaoQinInfoDao.selectCdCount(did5,startTime,endTime));
		KaoQinCountBean re6 = new KaoQinCountBean();
		re6.setZhengchang(kaoQinInfoDao.selectZcCount(did6,startTime,endTime));
		re6.setQueqin(kaoQinInfoDao.selectQqCount(did6,startTime,endTime));
		re6.setChidao(kaoQinInfoDao.selectCdCount(did6,startTime,endTime));
		List<KaoQinCountBean> results = new ArrayList<KaoQinCountBean>();
		results.add(re1);
		results.add(re2);
		results.add(re3);
		results.add(re4);
		results.add(re5);
		results.add(re6);
		return results;
	}
	//查询公司的考勤情况
	@Override
	public KaoQinCountBean selectCopKaoQin(String startTime, String endTime) {
		KaoQinCountBean result = new KaoQinCountBean();
		result.setZhengchang(kaoQinInfoDao.selectZcCopTotalCount(startTime,endTime));
		result.setQueqin(kaoQinInfoDao.selectQqCopTotalCount(startTime,endTime));
		result.setChidao(kaoQinInfoDao.selectCdCopTotalCount(startTime,endTime));
		return result;
	}
	//手动添加考勤
	@Override
	public Integer insertIntoAttdence(KaoQinInfoBean kaoQinInfo) {
		Integer rows = kaoQinInfoDao.insertInToAttdence(kaoQinInfo);
		if(rows>0) {
			return rows;
		}
		return null;
	}

}
