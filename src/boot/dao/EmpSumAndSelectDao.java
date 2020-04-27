package boot.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import boot.pojo.EmpSalaryBean;

@Repository
public interface EmpSumAndSelectDao {
	//��������Ա���Ĺ���
	public void sumSalary(Map<String,Object> param);
	//��ѯԱ������
	public List<EmpSalaryBean> selectEmpSalary(Map<String,Object> param);
	//��ѯ�ܸ���
	public Integer selectEmpSalaryCount(Map<String,Object> param);
	//����ɾ��Ա������
	public void deleteEmpEndSalary(Map<String,Object> param);
}
