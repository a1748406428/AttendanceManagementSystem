package boot.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import boot.page.utils.Page;
import boot.pojo.DepartInfoBean;
import boot.pojo.KaoHeInFoBean;
import boot.service.DepartInfoService;

@Controller
public class DepartMannageController {
	@Autowired
	private DepartInfoService departInfoService;
	//打开部门管理页面
	@RequestMapping("tobmgl.action")
	public String toDepartInfo(@RequestParam(defaultValue = "1") Integer page,
			@RequestParam(defaultValue = "10")Integer rows,DepartInfoBean departInfoBean,
			Model model) {
		Page<DepartInfoBean> departPageBan = departInfoService.selectDepByCon(page, rows, departInfoBean);
		model.addAttribute("page", departPageBan);
		return "departinfo";
	}
	//实现部门管理页面的功能
	@RequestMapping("selectdep.action")
	public String departInfo(@RequestParam(defaultValue = "1") Integer page,
			@RequestParam(defaultValue = "10")Integer rows,DepartInfoBean departInfoBean,
			Model model) {
		Page<DepartInfoBean> departPageBan = departInfoService.selectDepByCon(page, rows, departInfoBean);
		model.addAttribute("page", departPageBan);
		return "departinfo";
	}
	//修改部门的信息
	@RequestMapping("updatedep.action")
	public void updateDepInfo(@RequestBody DepartInfoBean departInfoBean,HttpServletResponse response) {
		Integer rows = departInfoService.updateDepInfoById(departInfoBean);
		if(rows>0) {
			response.setContentType("text/html;charset=utf-8");
			try {
				response.getWriter().write("修改成功");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	//修改部门信息
	@RequestMapping("deleteById.action")
	public String deleteDep(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		Integer rows = departInfoService.deleteDepById(id);
		if(rows>0) {
			return "departinfo";
		}
		return null;
	}
	//添加部门
	@RequestMapping("insertDep.action")
	public String insertDep(@RequestBody DepartInfoBean departInfoBean,HttpServletResponse response) {
		Integer rows = departInfoService.insertDepInFo(departInfoBean);
		if(rows>0) {
			response.setContentType("text/html;charset=utf-8");
			try {
				response.getWriter().write("添加成功");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return "departinfo";
	}
	//to绩效评定与考核
	@RequestMapping("jxpd.action")
	public String toJiXiaoPingDing() {
		return "jixiaopingding";
	}
	//查看出勤率
	@RequestMapping("selectcql.action")
	@ResponseBody
	public String scanChuQinLv(@RequestParam(value = "month") String month,@RequestParam(value = "departid") Integer departid) {
		String chuqinlv = departInfoService.calculDepartAtt(month, departid);
		return chuqinlv;
	} 
	//查看任务完成情况
	@RequestMapping("progress.action")
	@ResponseBody
	public String scanTaskProgress(@RequestParam(value = "month") String month,@RequestParam(value = "departid") Integer departid) {
		String taskProgress = departInfoService.selectTaskProgress(month, departid);
		return taskProgress;
	}
	//提交考核信息
	@RequestMapping(value = "jixiaotijiao.action")
	public void submitKaoHe(@RequestBody KaoHeInFoBean kaoHeInFoBean,HttpServletResponse response) {
		int row = departInfoService.submitKaoHeBiao(kaoHeInFoBean);
		System.out.println(row);
		if (row >0)
			response.setContentType("text/html;charset=utf-8");
			try {
				response.getWriter().write("提交成功");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	//to考核汇总
	@RequestMapping("khhztable.action")
	public String toKaoHeHuiZong() {
		return "kaohehuizong";
	}
	//make考核汇总表
	@RequestMapping("khzbtable.action")
	@ResponseBody
	public Map<String,Object> makeKaoHeHuizongTable(Integer offset,Integer limit,@RequestParam(value="month") String month,@RequestParam Integer depid){
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("offset", offset);
		param.put("limit", limit);
		if(month.equals("NaN/NaN")) {
			param.put("month", null);
		}else {
			param.put("month", month);
		}
		try {
			if(depid != null) {
				param.put("depid", depid);
			}
		} catch (NullPointerException e) {
			param.put("depid", null);
		}
		System.out.println(departInfoService.selectKaoHeSum(param).get("data"));
		return departInfoService.selectKaoHeSum(param);
	}
}
