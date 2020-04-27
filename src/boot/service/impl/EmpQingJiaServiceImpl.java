package boot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import boot.dao.EmpQingJiaDao;
import boot.pojo.JiaTiaoBean;
import boot.service.EmpQingJiaService;
@Service
public class EmpQingJiaServiceImpl implements EmpQingJiaService {
	@Autowired
	private EmpQingJiaDao empQingJiaDao;
	@Override
	public int addEmpQingJiaInFo(JiaTiaoBean jiaTiaoBean) {
		int rows = empQingJiaDao.addEmpQingJia(jiaTiaoBean);
		if (rows>0)
			return rows;
		return 0;
	}

}
