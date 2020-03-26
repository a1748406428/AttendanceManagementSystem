package boot.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import boot.pojo.KaoQinInfoBean;
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
	
}
