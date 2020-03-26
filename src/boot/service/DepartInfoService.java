package boot.service;

import org.springframework.stereotype.Service;

import boot.page.utils.Page;
import boot.pojo.DepartInfoBean;

@Service
public interface DepartInfoService {
	//����������ѯ������Ϣ 
	Page<DepartInfoBean> selectDepByCon(Integer page,Integer rows,DepartInfoBean departInfoBean);
	//���Ĳ�����Ϣ
	Integer updateDepInfoById(DepartInfoBean departInfoBean);
	//ɾ��������Ϣ
	Integer deleteDepById(Integer id);
}
