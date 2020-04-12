package boot.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import boot.pojo.JiTiJiaTiaoBean;
import boot.pojo.JiaTiaoBean;
import boot.pojo.JiangLiInFoBean;

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
		//��Ӱ���д洢����
		public void addIntoJiaBanCount(Map<String,Object> param);
		//��ѯ���ܽ���Ա������Ϣ
		public List<JiangLiInFoBean> selectJiangLiInFo(Map<String,Object> param);
		//��ѯ���ܽ���Ա��������
		public Integer jiangLiTotalCount();
		//��ѯԱ����������
		public String selectEmpBaseSalary(Integer id);
		//���½���״̬��Ϣ
		public int updateJiangLiInFo(@Param("id")Integer id,@Param("status")String status,@Param("yingdejiangli")String yingdejiangli);
		
}
