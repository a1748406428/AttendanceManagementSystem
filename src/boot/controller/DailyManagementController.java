package boot.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import boot.service.DailyMannageService;

@Controller
public class DailyManagementController {
	@Autowired
	private DailyMannageService dailyMannageService;
	//to请假申请
	@RequestMapping("qjsq.action")
	public String toQingJia() {
		return "qingjiashenqingdan";
	}
	//个人假条浏览
	@RequestMapping("jiatiao.action")
	@ResponseBody
	public Map<String, Object> browseJiaTiao(@RequestParam Integer offset,@RequestParam Integer limit,@RequestParam String time) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("offset", offset);
		map.put("limit", limit);
		System.out.println(time);
		if(time.equals("NaN/NaN/NaN")) {
			map.put(null, time);
		}else {
			map.put("time", time);
		}
		return dailyMannageService.browseQingJiaTiao(map);
	}
	//个人请假是否批准
	@RequestMapping("pizhun.action")
	public void isPiZhun(HttpServletRequest request,HttpServletResponse response) {
		int id = Integer.parseInt(request.getParameter("id"));
		String status = request.getParameter("status");
		dailyMannageService.updateJiaTiaoStatus(id, status);
		try {
			response.getWriter().write(200);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//集体假条浏览
	@RequestMapping("jitijiatiao.action")
	@ResponseBody
	public Map<String,Object> browseJiTiJiaTio(@RequestParam Integer offset,@RequestParam Integer limit,@RequestParam String time){
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("offset", offset);
		map.put("limit", limit);
		System.out.println(time);
		if(time.equals("NaN/NaN/NaN")) {
			map.put(null, time);
		}else {
			map.put("time", time);
		}
		return dailyMannageService.browseJiTiJiaTiao(map);
	}
	//修改状态信息(集体假条)
	@RequestMapping("istongyi.action")
	public void updateJiTiJiaTiaoStatus(HttpServletRequest request,HttpServletResponse response) {
		int id = Integer.parseInt(request.getParameter("id"));
		String status = request.getParameter("status");
		System.out.println(id+"---"+status);
		dailyMannageService.updateJiJiaTiaoStatus(id, status);
		try {
			response.getWriter().write("200");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//to调休管理
	@RequestMapping("txgl.action")
	public String toTiaoXiu() {
		return "tiaoxiu";
	}
	//to补偿计划
	@RequestMapping("bcjh.action")
	public String buChangJiHua() {
		return "buchangjihua";
	}
	//汇总加班天数
	@RequestMapping("huizong.action")
	public void huiZongJiaBan(@RequestParam String monthstart,@RequestParam String monthend,HttpServletResponse response) {
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("monthstart", monthstart);
		param.put("monthend", monthend);
		dailyMannageService.huiZongJiangLi(param);
		System.out.println(monthstart+""+monthend);
		response.setContentType("text/html;charset=utf-8");
		try {
			response.getWriter().write("200");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//查看答当月奖惩情况
	@RequestMapping("selectjiangcheng.action")
	@ResponseBody
	public Map<String, Object> browseJiangCheng(@RequestParam Integer offset,@RequestParam Integer limit,@RequestParam Integer month) {
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("offset", offset);
		param.put("limit", limit);
		param.put("month", month);
		return dailyMannageService.selectJiangLiInFo(param);
	}
	//查询平均薪资并计算奖励多少钱
	@RequestMapping("caculatormoney.action")
	@ResponseBody
	public Map<String,Object> caculatorAvgMoney(@RequestParam Integer id,@RequestParam Integer jiabantianshu) {
		return dailyMannageService.calculateAvgDailySal(id,jiabantianshu);
	} 
	//奖励审核
	@RequestMapping("jianglishenhe.action")
	public void jiangLiShenHe(@RequestParam Integer id,@RequestParam String status,@RequestParam Float yingdejiangli,HttpServletResponse response) {
		dailyMannageService.updateJiangliZhuangTai(id, status, yingdejiangli);
		System.out.println(status);
		response.setContentType("text/html;charset=utf-8");
		try {
			response.getWriter().write("200");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//to通知广播
	@RequestMapping("tzgb.action")
	public String toTongZhiGuangBo() {
		return "tongzhi";
	}
}
