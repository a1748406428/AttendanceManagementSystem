package boot.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
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

import boot.pojo.KaoQinInfoBean;
import boot.service.KaoQinInfoService;
import boot.vo.KaoQinCountBean;
import net.sf.json.JSONObject;

@Controller
public class KaoQinGuanLiController {
	@Autowired
	private KaoQinInfoService kaoQinInfoService;

	@RequestMapping("/kqqk.action")
	public String kaoQinQingKuang() {
		return "kaoqinqingkuang";
	}

	// 部门情况表
	@RequestMapping("/bumen.action")
	public String bumenDetailed(  @RequestParam() Integer did1,@RequestParam() Integer did2,@RequestParam() Integer did3,
								  @RequestParam() Integer did4,@RequestParam() Integer did5,@RequestParam() Integer did6,
								  @RequestParam() String startTime,
								  @RequestParam() String endTime,
								 Model model, HttpServletResponse response, HttpServletRequest request) {
		//获得每个部门的考勤信息
		List<KaoQinCountBean> selectDepKaoQin = kaoQinInfoService.selectDepKaoQin(did1, did2, did3, 
				did4, did5, did6,startTime,endTime);
		KaoQinCountBean kaoQinCountBean1 = selectDepKaoQin.get(0);
		KaoQinCountBean kaoQinCountBean2 = selectDepKaoQin.get(1);
		KaoQinCountBean kaoQinCountBean3 = selectDepKaoQin.get(2);
		KaoQinCountBean kaoQinCountBean4 = selectDepKaoQin.get(3);
		KaoQinCountBean kaoQinCountBean5 = selectDepKaoQin.get(4);
		KaoQinCountBean kaoQinCountBean6 = selectDepKaoQin.get(5);	
		String callbackJson = KaoQinGuanLiController.formatJson(kaoQinCountBean1, kaoQinCountBean2, kaoQinCountBean3, 
				kaoQinCountBean4, kaoQinCountBean5, kaoQinCountBean6);
		@SuppressWarnings("static-access")
		JSONObject jsonData = new JSONObject().fromObject(callbackJson);
		try {
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write(jsonData.toString());
		} catch (IOException e) {
			System.out.println("数据转换失败");
		}
		return null;
	}
	//查询公司的总体考勤情况
	@RequestMapping("/total.action")
	public void totalDetailed(HttpServletRequest request,HttpServletResponse response,
			@RequestParam() String startTime,
			@RequestParam() String endTime) {
		KaoQinCountBean selectCopKaoQin = kaoQinInfoService.selectCopKaoQin(startTime,endTime);
		@SuppressWarnings("static-access")
		JSONObject jsonObject = new JSONObject().fromObject(selectCopKaoQin);
		response.setContentType("text/html;charset=utf-8");
		try {
			response.getWriter().write(jsonObject.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//手动记录功能
	@RequestMapping("sdtj.action")
	public String mappingToQueQin() {
		return "queqinjilu";
	}
	//手动记录
	@RequestMapping("/sdjl.action")
	@ResponseBody
	public String shDongInsert(@RequestBody KaoQinInfoBean kaoQinInfao,HttpServletResponse response) {
		int row = kaoQinInfoService.insertIntoAttdence(kaoQinInfao);
		if(row>0) {
			try {
				response.setContentType("text/html;charset=utf-8");
				response.getWriter().write("添加成功");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	//更新考勤信息
	@RequestMapping("gengxin.action")
	public String upDateKaoQinInFo(@RequestBody KaoQinInfoBean kaoQinInfao) {
		int row = kaoQinInfoService.updateAttedence(kaoQinInfao);
		if(row > 0) {
			return "更新成功";
		}
		return null;
	}
	@RequestMapping("kqzb.action")
	public String selectKaoQinZongBiao() {
		
		return "kaoqinzongbiao";
	}
	@RequestMapping("scankaoqinzongbiao.action")
	@ResponseBody
	public Map<String,Object> scanKaoQinZongBiao(@RequestParam Integer offset,@RequestParam Integer limit,
			@RequestParam String time,@RequestParam Integer departid,@RequestParam Integer postid){
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("offset", offset);
		param.put("limit", limit);
		if(time.equals("NaN/NaN")) {
			param.put("time", null);
		}else {
			param.put("time", time);
		}
		try {
			if(!departid.equals(null)) {
				param.put("departid", departid);
			}
		} catch (NullPointerException e) {
			param.put("departid", null);
		}
		try {
			if(!postid.equals(null)) {
				param.put("postid", postid);
			}
		} catch (NullPointerException e) {
			param.put("postid", null);
		}
		System.out.println(departid);
		return kaoQinInfoService.selectKaoQinZongBiao(param);
	}
	
	//得到数据进行JSON数据转换
	public static String formatJson(KaoQinCountBean countBean1,KaoQinCountBean countBean2,
			KaoQinCountBean countBean3,KaoQinCountBean countBean4,
			KaoQinCountBean countBean5,KaoQinCountBean countBean6) {
		//获取每一个Bean中的参数值
		int zhengchang1 = countBean1.getZhengchang();
		int queqin1 = countBean1.getQueqin();
		int chidao1 = countBean1.getChidao();
		int zhengchang2 = countBean2.getZhengchang();
		int queqin2 = countBean2.getQueqin();
		int chidao2 = countBean2.getChidao();
		int zhengchang3 = countBean3.getZhengchang();
		int queqin3 = countBean3.getQueqin();
		int chidao3 = countBean3.getChidao();
		int zhengchang4 = countBean4.getZhengchang();
		int queqin4 = countBean4.getQueqin();
		int chidao4 = countBean4.getChidao();
		int zhengchang5 = countBean5.getZhengchang();
		int queqin5 = countBean5.getQueqin();
		int chidao5 = countBean5.getChidao();
		int zhengchang6 = countBean6.getZhengchang();
		int queqin6 = countBean6.getQueqin();
		int chidao6 = countBean6.getChidao();
		String json = "{categories:[\"正常上班\",\"缺勤\",\"迟到\"],data:[{d1:[" + zhengchang1 + "," + queqin1 + ","
				+ chidao1+"]"+","+"d2:["+zhengchang2 + "," + queqin2 + ","
				+ chidao2+"]"+","+"d3:["+zhengchang3 + "," + queqin3 + ","
				+ chidao3+"]"+","+"d4:["+zhengchang4 + "," + queqin4 + ","
				+ chidao4+"]"+","+"d5:["+zhengchang5 + "," + queqin5 + ","
				+ chidao5+"]"+","+"d6:["+zhengchang6 + "," + queqin6 + ","
				+ chidao6+"]"+"}]}";
		return json;
	}
}
