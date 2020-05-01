package boot.service.impl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import boot.dao.DepartInfoDao;
import boot.page.utils.Page;
import boot.pojo.DepartInfoBean;
import boot.pojo.EmployeeBean;
import boot.pojo.KaoHeInFoBean;
import boot.pojo.PostBean;
import boot.pojo.TaskBean;
import boot.service.DepartInfoService;
import boot.vo.YiXiangMessageBean;

@Service
public class DepartInfoServiceImpl implements DepartInfoService {
	@Autowired
	private DepartInfoDao departInfoDao;

	@Override
	public Page<DepartInfoBean> selectDepByCon(Integer page, Integer rows, DepartInfoBean departInfoBean) {
		// ��ȡ��ʼ��
		departInfoBean.setStart((page - 1) * rows);
		// ����ÿҳ����
		departInfoBean.setRows(rows);
		// ��ѯ�����
		List<DepartInfoBean> depBean = departInfoDao.selectAllDepInFo(departInfoBean);
		Integer count = departInfoDao.selectCount(departInfoBean);
		Page<DepartInfoBean> result = new Page<DepartInfoBean>();
		result.setPage(departInfoBean.getStart());
		result.setSize(departInfoBean.getRows());
		result.setRows(depBean);
		result.setTotal(count);
		return result;
	}

	// ���²�����Ϣ
	@Override
	public Integer updateDepInfoById(DepartInfoBean departInfoBean) {
		Integer updateDepInfo = departInfoDao.updateDepInfo(departInfoBean);
		if (updateDepInfo > 0) {
			return updateDepInfo;
		}
		return null;
	}

	// ɾ������
	@Override
	public Integer deleteDepById(Integer id) {
		Integer rows = departInfoDao.deleteDepById(id);
		if (rows > 0) {
			return rows;
		}
		return null;
	}

	// ��Ӳ�����Ϣ
	@Override
	public Integer insertDepInFo(DepartInfoBean departInfoBean) {
		Integer rows = departInfoDao.insertDep(departInfoBean);
		if (rows > 0) {
			return rows;
		}
		return null;
	}

	// �鿴�ռ���
	@Override
	public Map<String, Object> selectMesg(Map<String, Object> param) {
		// ��ѯ�����
		List<YiXiangMessageBean> messageBean = departInfoDao.selectMessage(param);
		Integer count = departInfoDao.selectMessageCount();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("data", messageBean);
		map.put("total", count);
		return map;
	}
	//�޸�״̬
	@Override
	public Integer updateMsgStatus(Integer eid,String status) {
		int rows = departInfoDao.updateMessageStatus(eid,status);
		if(rows>0) {
			return rows;
		}
		return 0;
	}
	//ɾ��������Ϣ
	@Override
	public Integer deleteOneMsgByEid(Integer eid) {
		int rows = departInfoDao.deleteMsgByEid(eid);
		if(rows>0) {
			return rows;
		}
		return 0;
	}
	//�޸�Ա����Ϣ
	@Override
	public Integer updateEmpDepPostById(EmployeeBean employeeBean) {
		int rows = departInfoDao.updateEmpDepPostById(employeeBean);
		if(rows > 0)
			return rows;
		return 0;
	}
	//���Ÿ�λ����Ч��
	@Override
	public List<PostBean> dynamicDepAndPost(Integer did) {
		List<PostBean> results = departInfoDao.dynamicDepAndPost(did);
		if(!results.isEmpty()) {
			return results;
		}
		return null;
	}
	//���㹤��
	/*	�����ŷ��뼯���У��������ţ��ҵ����������Ĺ���Ȼ��+1
	 * */
	@Override
	public String calcullateGongHao(Integer did) {
		List<String> gongHao = departInfoDao.selectGongHao(did);
		int arraySize = gongHao.size();
		Integer[] tempArray = new Integer[arraySize];
		int i =0;
		for (Iterator iterator = gongHao.iterator(); iterator.hasNext();) {
			String strGongHao = (String) iterator.next();
			tempArray[i] = Integer.parseInt(strGongHao);
			i = i+1;
		}
		//����������ֵ
		int max = tempArray[0];
		for(int j =1;j<tempArray.length;j++) {
			if(tempArray[j]>max) {
				max = tempArray[j];
			}
		}
		int intGonghao = max+1;
		String gonghao = String.valueOf(intGonghao);
		return gonghao;
	}
	//����ַ�

	@Override
	public void taskSend(TaskBean taskBean) {
		departInfoDao.addTask(taskBean);
	}
	//�鿴��ְ����

	@Override
	public Map<String, Object> selectResignApp(Map<String, Object> param) {
		Map<String,Object> map = new HashMap<String,Object>();
		List<YiXiangMessageBean> data = departInfoDao.selectResignationApplicationMessage(param);
		Integer total = departInfoDao.selectResignationApplicationMessageCount();
		map.put("data", data);
		map.put("total", total);
		return map;
	}
	//������ְ���뵥״̬��Ϣ

	@Override
	public boolean updateResignStatus(Integer eid,String status) {
		int row1 = departInfoDao.AgreeResign(eid,status);
		int row2 = departInfoDao.UnAgreeResign(eid,status);
		if(row1>0 || row2 > 0) {
			return true;
		}
		return false;
	}
	//���㲿�ų�����

	@Override
	public String calculDepartAtt(String month, Integer departid) {
		Integer count = departInfoDao.selectChuQinCount(month, departid);
		Integer totalcount = departInfoDao.selectTotalChuQinCount(month, departid);
		System.out.println(count);
		System.out.println(totalcount);
		
		float flchuqinlv = ((float)count/(float)totalcount)*100;
		System.out.println(flchuqinlv);
		String strchuqinlv = String.valueOf(flchuqinlv);
		return strchuqinlv;
	}
	//�鿴������ɶ�
	@Override
	public String selectTaskProgress(String month, Integer departid) {
		String taskProgress = departInfoDao.selectTaskProgress(month, departid);
		return taskProgress;
	}
	//�ύ���������

	@Override
	public int submitKaoHeBiao(KaoHeInFoBean kaoHeInFoBean) {
		int row = departInfoDao.submitKaoHeInFo(kaoHeInFoBean);
		if(row>0)
			return row;
		return 0;
	}
	//���˱�

	@Override
	public Map<String, Object> selectKaoHeSum(Map<String, Object> param) {
		Map<String,Object> result = new HashMap<String,Object>();
		List<KaoHeInFoBean> data = departInfoDao.selectKaoHeInFo(param);
		Integer total = departInfoDao.selectKaoHeInFoTotal(param);
		result.put("data", data);
		result.put("total", total);
		return result;
	}
	
}
