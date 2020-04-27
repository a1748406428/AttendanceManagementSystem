package boot.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import boot.pojo.EmpSalaryBean;
import boot.pojo.EmployeeBean;
import boot.pojo.JiaTiaoBean;
import boot.service.EmpQingJiaService;
import boot.service.GetEmpSelfInfoService;

@Controller
public class EmpMannageController {
	@Autowired
	private EmpQingJiaService empQingJiaService;
	
	@Autowired
	private GetEmpSelfInfoService getEmpSelfInfoService;
	//请假消息发送并更新数据库信息
	@RequestMapping("empqingjia.action")
	public void addQingJiaAndSendInfo(@RequestBody JiaTiaoBean jiaTiaoBean,HttpServletResponse response) {
		int row = empQingJiaService.addEmpQingJiaInFo(jiaTiaoBean);
		if(row>0) {
			response.setContentType("text/html;charset=utf-8");
			try {
				response.getWriter().write("200");
			} catch (IOException e) {
				// TODO Auto-generated catch block
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
		EmpSalaryBean empSalaryBean = getEmpSelfInfoService.selectEmpPersonSalary(gonghao);
		model.addAttribute("empsalary", empSalaryBean);
		return "xzmx";
	}
}
