package boot.dao;

import java.util.List;


import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import boot.pojo.JiTiJiaTiaoBean;
import boot.pojo.JiaTiaoBean;
import boot.pojo.JiangLiInFoBean;
import boot.pojo.NoticeBean;

@Repository
public interface DailyMannageDao {
		//�鿴���������Ϣ
		public List<JiaTiaoBean> selectPersonalQingjia(Map<String,Object> param);
		//�鿴���˼�������
		public Integer selectPersonalJiaTiaoCount(Map<String,Object> param);
		//�޸ĸ��˼���״̬
		public Integer updateJiaTiaoStatus(@Param("id")Integer id,@Param("status") String status);
		//ɾ����������
		public int deletePersonJiaTiaoById(@Param("id")Integer id);
		//���������Ϣ
		public List<JiTiJiaTiaoBean> selectJiTiJiaTiao(Map<String, Object> param);
		//�����������
		public Integer selectJiTiJiaTiaoCount(Map<String,Object> param);
		//���¼������״̬
		public Integer updateJiTiJiaTiaoStatus(@Param("id") Integer id,@Param("status") String status);
		//ɾ���������
		public int deletejitiJiaTiao(@Param("id") Integer id);
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
		//���¹�����Ϣ��
		public int addPublicNotice(NoticeBean noticeBean);
		//����˽����Ϣ��
		public int addPrivateNotice(NoticeBean noticeBean);
		
}
