package boot.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import boot.pojo.KaoQinInfoBean;
import boot.pojo.KaoQinZongBiaoBean;
import boot.vo.KaoQinCountBean;

@Repository
public interface KaoQinInfoDao {
	// 查询考勤人员列表
	public KaoQinCountBean selectDepart(@Param("did") Integer did/*, String startTime, String endTime*/);

	// 查询正常上班总数
	public Integer selectZcCount(@Param("did") Integer did, 
			@Param("startTime") String startTime, 
			@Param("endTime") String endTime);
	//查询缺勤人员
	public Integer selectQqCount(@Param("did") Integer did, 
			@Param("startTime") String startTime, 
			@Param("endTime") String endTime);
	//查询迟到人数
	public Integer selectCdCount(@Param("did") Integer did, 
			@Param("startTime") String startTime, 
			@Param("endTime") String endTime);
	//查询公司的整体考勤情况
	public Integer selectZcCopTotalCount(@Param("startTime")String startTime,@Param("endTime")String endTime);
	public Integer selectQqCopTotalCount(@Param("startTime")String startTime,@Param("endTime")String endTime);
	public Integer selectCdCopTotalCount(@Param("startTime")String startTime,@Param("endTime")String endTime);
	
	//手动记录考勤数据
	public Integer insertInToAttdence(KaoQinInfoBean kaoQinInfobean);
	
	//条件查询考勤表
	public List<KaoQinZongBiaoBean> selectKaoQinInFo(Map<String,Object> param);
	//查询总表结果集个数
	public Integer selectKaoQinInFoCount(Map<String,Object> param);
	
	//更新个人的考勤信息
	public Integer updateAttdenceInFo(KaoQinInfoBean kaoQinInfobean);
}
