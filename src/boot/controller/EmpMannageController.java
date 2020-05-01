package boot.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import boot.dao.GetEmpSelfInFoDao;
import boot.pojo.EmpSalaryBean;
import boot.pojo.EmployeeBean;
import boot.pojo.JiaTiaoBean;
import boot.pojo.TaskBean;
import boot.service.EmpQingJiaService;
import boot.service.GetEmpSelfInfoService;
import boot.vo.YiXiangMessageBean;

@Controller
public class EmpMannageController {
	@Autowired
	private EmpQingJiaService empQingJiaService;
	
	@Autowired
	private GetEmpSelfInfoService getEmpSelfInfoService;
	
	@Autowired
	private GetEmpSelfInFoDao getEmpSelfInFoDao;
	//�����Ϣ���Ͳ��������ݿ���Ϣ
	@RequestMapping("empqingjia.action")
	public void addQingJiaAndSendInfo(@RequestBody JiaTiaoBean jiaTiaoBean,HttpServletResponse response) {
		int row = empQingJiaService.addEmpQingJiaInFo(jiaTiaoBean);
		if(row>0) {
			response.setContentType("text/html;charset=utf-8");
			try {
				response.getWriter().write("200");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	//��ѯԱ��������Ϣ
	@RequestMapping("personinfo.action")
	public String toEmpInFo(@RequestParam(value = "gonghao")String gonghao,Model model) {
		EmployeeBean employeeBean = getEmpSelfInfoService.selectEmpSelfInfo(gonghao);
		model.addAttribute("empselfinfo", employeeBean);
		return "personinfo";
	}
	//�鿴�ҵĹ��ʱ�
	@RequestMapping("xzmx.action")
	public String toEmpXinZiMingXi(@RequestParam(value = "gonghao")String gonghao,Model model) {
		List<EmpSalaryBean> empSalaryBean = getEmpSelfInfoService.selectEmpPersonSalary(gonghao);
		model.addAttribute("empsalary", empSalaryBean);
		return "xzmx";
	}
	//���ְλ�����Ϣ
	@RequestMapping("zhiweibiangeng.action")
	public void addZhiWeiBianGengShenQing(@RequestBody YiXiangMessageBean yiXiangMessageBean,HttpServletResponse response) {
		int rows = getEmpSelfInfoService.addIntoPostChange(yiXiangMessageBean);
		if(rows>0) {
			try {
				response.setContentType("text/html;charset=utf-8");
				response.getWriter().write("�ύ�ɹ�");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	//�����ְ������Ϣ
	@RequestMapping("lizhishenqing.action")
	public void addLiZhiShenQing(@RequestBody YiXiangMessageBean yiXiangMessageBean,HttpServletResponse response) {
		int row = getEmpSelfInfoService.addIntoReSignationApplication(yiXiangMessageBean);
		if(row>0) {
			try {
				response.getWriter().write("200");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	//ʵ�����°�򿨹���
	@RequestMapping("daka.action")
	public void addAttdence(@RequestParam String gonghao,@RequestParam String checktime,
			@RequestParam String startcheckorendcheck,HttpServletResponse response) {
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("ingonghao", gonghao);
		param.put("inchecktime", checktime);
		param.put("startcheckorendcheck", startcheckorendcheck);
		getEmpSelfInfoService.autoDaka(param);
		try {
			response.getWriter().write("200");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//��������
	@RequestMapping("rewu.action")
	public String scanTasks(@RequestParam(value="gonghao")String gonghao,Model model) {
		List<TaskBean> tasks = getEmpSelfInfoService.selectTasks(gonghao);
		model.addAttribute("task", tasks);
		return "tasks";
	}
	//��������״̬
	@RequestMapping("updateprogress.action")
	public void updateTaskProgress(HttpServletRequest request,HttpServletResponse response) {
		Integer id = Integer.parseInt(request.getParameter("id"));
		String progress = request.getParameter("progress");
		System.out.println(progress);
		int row = getEmpSelfInfoService.updateTaskProgress(id, progress);
		response.setContentType("text/html;charset=utf-8");
		try {
			response.getWriter().write("������"+row+"����Ϣ");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//������Ϣ���
	@RequestMapping("updatemsgStatus.action")
	public void updatemsgStatus(@RequestParam("id")Integer id,
			@RequestParam("status") String status,HttpServletResponse response) {
		int row = getEmpSelfInFoDao.updatemsgstatus(id, status);
		if(row>0)
			try {
				response.getWriter().write("200");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}
