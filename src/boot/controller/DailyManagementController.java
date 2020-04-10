package boot.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

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
	public void isPiZhun(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		String status = request.getParameter("status");
		dailyMannageService.updateJiaTiaoStatus(id, status);
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
	//修改状态信息
	@RequestMapping("istongyi.action")
	public void updateJiTiJiaTiaoStatus(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		String status = request.getParameter("status");
		System.out.println(id+"---"+status);
		dailyMannageService.updateJiJiaTiaoStatus(id, status);
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
	//to通知广播
	@RequestMapping("tzgb.action")
	public String toTongZhiGuangBo() {
		return "tongzhi";
	}
}
