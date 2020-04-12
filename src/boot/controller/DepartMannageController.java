package boot.controller;

import java.io.IOException;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import boot.page.utils.Page;
import boot.pojo.DepartInfoBean;
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
}
