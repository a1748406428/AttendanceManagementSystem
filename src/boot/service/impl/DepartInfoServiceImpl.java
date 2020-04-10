package boot.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import boot.dao.DepartInfoDao;
import boot.page.utils.Page;
import boot.pojo.DepartInfoBean;
import boot.pojo.EmployeeBean;
import boot.pojo.PostBean;
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
	
}
