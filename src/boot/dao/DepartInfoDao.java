package boot.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import boot.pojo.DepartInfoBean;


@Repository
public interface DepartInfoDao {
	//��ѯ���
	public List<DepartInfoBean> selectAllDepInFo(DepartInfoBean departInfoBean);
	//��ѯ�������
	public Integer selectCount(DepartInfoBean departInfoBean);
	//�޸Ĳ�����Ϣ
	public Integer updateDepInfo(DepartInfoBean departInfoBean);
	//ɾ������
	public Integer deleteDepById(@Param("id")Integer id);
}
