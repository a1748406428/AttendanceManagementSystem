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
	//请假消息发送并更新数据库信息
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
	//查询员工个人信息
	@RequestMapping("personinfo.action")
	public String toEmpInFo(@RequestParam(value = "gonghao")String gonghao,Model model) {
		EmployeeBean employeeBean = getEmpSelfInfoService.selectEmpSelfInfo(gonghao);
		model.addAttribute("empselfinfo", employeeBean);
		return "personinfo";
	}
	//查看我的工资表
	@RequestMapping("xzmx.action")
	public String toEmpXinZiMingXi(@RequestParam(value = "gonghao")String gonghao,Model model) {
		List<EmpSalaryBean> empSalaryBean = getEmpSelfInfoService.selectEmpPersonSalary(gonghao);
		model.addAttribute("empsalary", empSalaryBean);
		return "xzmx";
	}
	//添加职位变更消息
	@RequestMapping("zhiweibiangeng.action")
	public void addZhiWeiBianGengShenQing(@RequestBody YiXiangMessageBean yiXiangMessageBean,HttpServletResponse response) {
		int rows = getEmpSelfInfoService.addIntoPostChange(yiXiangMessageBean);
		if(rows>0) {
			try {
				response.setContentType("text/html;charset=utf-8");
				response.getWriter().write("提交成功");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	//添加离职申请消息
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
	//实现上下班打卡功能
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
	//任务中心
	@RequestMapping("rewu.action")
	public String scanTasks(@RequestParam(value="gonghao")String gonghao,Model model) {
		List<TaskBean> tasks = getEmpSelfInfoService.selectTasks(gonghao);
		model.addAttribute("task", tasks);
		return "tasks";
	}
	//更新任务状态
	@RequestMapping("updateprogress.action")
	public void updateTaskProgress(HttpServletRequest request,HttpServletResponse response) {
		Integer id = Integer.parseInt(request.getParameter("id"));
		String progress = request.getParameter("progress");
		System.out.println(progress);
		int row = getEmpSelfInfoService.updateTaskProgress(id, progress);
		response.setContentType("text/html;charset=utf-8");
		try {
			response.getWriter().write("更新了"+row+"条信息");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//更新信息标记
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
