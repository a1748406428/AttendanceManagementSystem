package boot.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import boot.pojo.KaoQinInfoBean;
import boot.vo.KaoQinCountBean;

@Repository
public interface KaoQinInfoDao {
	// ��ѯ������Ա�б�
	public KaoQinCountBean selectDepart(@Param("did") Integer did/*, String startTime, String endTime*/);

	// ��ѯ�����ϰ�����
	public Integer selectZcCount(@Param("did") Integer did, 
			@Param("startTime") String startTime, 
			@Param("endTime") String endTime);
	//��ѯȱ����Ա
	public Integer selectQqCount(@Param("did") Integer did, 
			@Param("startTime") String startTime, 
			@Param("endTime") String endTime);
	//��ѯ�ٵ�����
	public Integer selectCdCount(@Param("did") Integer did, 
			@Param("startTime") String startTime, 
			@Param("endTime") String endTime);
	//��ѯ��˾�����忼�����
	public Integer selectZcCopTotalCount(@Param("startTime")String startTime,@Param("endTime")String endTime);
	public Integer selectQqCopTotalCount(@Param("startTime")String startTime,@Param("endTime")String endTime);
	public Integer selectCdCopTotalCount(@Param("startTime")String startTime,@Param("endTime")String endTime);
	
	//�ֶ���¼��������
	public Integer insertInToAttdence(KaoQinInfoBean kaoQinInfobean);
	
}
