package boot.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import boot.service.EmpSalarySumService;

@Controller
public class EmpSalarySumController {
	@Autowired
	private EmpSalarySumService empSalarySumService;
	
	//工资汇总
	@RequestMapping("gzhz.action")
	public void sumSalary(@RequestParam(value="choosemonth") String choosemonth,HttpServletResponse response) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("choosemonth", choosemonth);
		empSalarySumService.sumEmpSalary(map);
		try {
			response.getWriter().write("200");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//浏览薪资表
	@RequestMapping("scansalary.action")
	@ResponseBody
	public Map<String,Object> scanSalay(@RequestParam(value = "offset")Integer offset,
			@RequestParam(value = "limit")Integer limit,@RequestParam(value = "time")String time) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("offset", offset);
		map.put("limit", limit);
		if(time.equals("NaN/NaN")) {
			map.put("time", null);
		}else {
			map.put("time", time);
		}
		return empSalarySumService.selectEmpSalary(map);
	}
	//清空工资表
	@RequestMapping("deleteallsalary.action")
	public void deleteAllSalary(@RequestParam(value="choosemonth") String choosemonth,HttpServletResponse response) {
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("choosemonth", choosemonth);
		empSalarySumService.deleteEmpSalary(param);
		try {
			response.getWriter().write("200");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
