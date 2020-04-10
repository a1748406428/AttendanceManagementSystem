package boot.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import boot.pojo.JiTiJiaTiaoBean;
import boot.pojo.JiaTiaoBean;

@Repository
public interface DailyMannageDao {
		//�鿴���������Ϣ
		public List<JiaTiaoBean> selectPersonalQingjia(Map<String,Object> param);
		//�鿴���˼�������
		public Integer selectPersonalJiaTiaoCount();
		//�޸ĸ��˼���״̬
		public Integer updateJiaTiaoStatus(@Param("id")Integer id,@Param("status") String status);
		//���������Ϣ
		public List<JiTiJiaTiaoBean> selectJiTiJiaTiao(Map<String, Object> param);
		//�����������
		public Integer selectJiTiJiaTiaoCount();
		//���¼������״̬
		public Integer updateJiTiJiaTiaoStatus(@Param("id") Integer id,@Param("status") String status);
}
