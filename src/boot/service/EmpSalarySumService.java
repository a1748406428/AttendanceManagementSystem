package boot.service;

import java.util.Map;

public interface EmpSalarySumService {
	public void sumEmpSalary(Map<String,Object>param);
	//��ѯԱ������
	public Map<String,Object> selectEmpSalary(Map<String,Object>param);
	//ɾ��Ա������
	public void deleteEmpSalary(Map<String,Object>param);
}
