package boot.service;

import java.util.Map;

import boot.pojo.NoticeBean;
public interface DailyMannageService {
	//�鿴�����������
	public Map<String,Object> browseQingJiaTiao(Map<String,Object> param);
	//�޸ļ���״̬
	public Integer updateJiaTiaoStatus(Integer id,String status);
	//ɾ��������Ϣ
	public int deletePersonJiaTiaoById(Integer id);
	//�鿴�������
	public Map<String,Object> browseJiTiJiaTiao(Map<String,Object> param);
	//�޸ļ������״̬
	public Integer updateJiJiaTiaoStatus(Integer id,String status);
	//ɾ��������Ϣ
	public int deleteJiTiJiaTiao(Integer id);
	//���ܼӰ�����
	public void huiZongJiangLi(Map<String,Object> param);
	//��ѯ���ܽ�����Ա
	public Map<String,Object> selectJiangLiInFo(Map<String,Object> param);
	//��ѯƽ������
	public Map<String,Object> calculateAvgDailySal(Integer id,Integer jiabantianshu); 
	//�������
	public int updateJiangliZhuangTai(Integer id,String status,Float yingdejiangli);
	//�����Ϣ���빫����Ϣ��
	public int addIntoPublicNotice(NoticeBean noticeBean);
	//������Ϣ��˽����Ϣ��
	public int addIntoPrivateNotice(NoticeBean noticeBean);
}
