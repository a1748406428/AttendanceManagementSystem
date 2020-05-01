package boot.controller;

import java.io.IOException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import boot.pojo.EmployeeBean;
import boot.pojo.PostBean;
import boot.pojo.TaskBean;
import boot.service.DepartInfoService;

@Controller
public class DepEmpMannageController {
	@Autowired
	private DepartInfoService departInfoService;
	// 部门人员管理
	@RequestMapping("bmcygl.action")
	public String toDepEmpManage() {
		return "depempmannage";
	}
	//查询信息
	@RequestMapping("/getmessage.action")
	public @ResponseBody Map<String, Object> toDepEmpMannage(@RequestParam Integer offset,@RequestParam Integer limit,@RequestParam String time) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("offset", offset);
		map.put("limit", limit);
		System.out.println(time);
		if(time.equals("NaN/NaN/NaN")) {
			map.put(null, time);
		}else {
			map.put("time", time);
		}
		return departInfoService.selectMesg(map);
	}
	//不同意
	@RequestMapping("/butongyi.action")
	public void buTongYi(@RequestParam Integer eid,@RequestParam String status,HttpServletResponse response) {
		int rows = departInfoService.updateMsgStatus(eid,status);
		if(rows>0) {
			try {
				response.getWriter().write("未同意");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	//修改信息
	@RequestMapping(value = "/tongyi.action",method = RequestMethod.POST)
	public void tongYi(@RequestParam Integer eid,@RequestParam String status,HttpServletResponse response) {
		System.out.println(eid+"==="+status);
		departInfoService.updateMsgStatus(eid,status);
			try {
				response.setContentType("text/html;charset=utf-8");
				response.getWriter().write(eid);
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	//单个删除
	@RequestMapping("deleteOneByeid.action")
	public void deleteByOneId(@RequestParam Integer eid) {
		departInfoService.deleteOneMsgByEid(eid);
	}
	//岗位联动效果
	@RequestMapping("bumenliandong.action")
	@ResponseBody
	public List<PostBean> dynamicDepAndPost(@RequestBody PostBean postBean){
		List<PostBean> result = departInfoService.dynamicDepAndPost(postBean.getDid());
		return result;
	}
	//修改岗位
	@RequestMapping("updateGangWeiById.action") 
	public String updateGangWeiByEid(EmployeeBean employeeBean) {
		int rows = departInfoService.updateEmpDepPostById(employeeBean);
		System.out.println(employeeBean.getDepartid()+employeeBean.getId()+employeeBean.getPostid());
		if(rows>0)
			return "depempmannage";
		return null;
	}
	//自动获取工号
	@RequestMapping("calcaugonghao.action")
	@ResponseBody
	public String autoCalCulGongHao(@RequestParam Integer did) {
		String gongHao = departInfoService.calcullateGongHao(did);
		return gongHao;
	}
	//任务分发
	@RequestMapping("tasksend.action")
	public void taskSend(@RequestBody TaskBean taskBean,HttpServletResponse response) {
		departInfoService.taskSend(taskBean);
			try {
				response.getWriter().write("200");
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	//查看离职收件箱
	@RequestMapping("getresignapp.action")
	@ResponseBody
	public Map<String,Object> getResignApp(@RequestParam Integer offset,@RequestParam Integer limit){
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("offset", offset);
		param.put("limit", limit);
		return departInfoService.selectResignApp(param);
	}
	//同意离职申请申请
	@RequestMapping("lizhitongyi.action")
	public void ResignAgree(@RequestParam(value = "eid") Integer eid,@RequestParam(value="status") String status,HttpServletResponse response) {
		if(departInfoService.updateResignStatus(eid,status)) {
			try {
				response.getWriter().write("200");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	} 
	//不同意
	@RequestMapping("lizhibutongyi.action")
	public void ResignUnAgree(@RequestParam(value = "eid") Integer eid,@RequestParam(value="status") String status,
	HttpServletResponse response) {
		if(departInfoService.updateResignStatus(eid,status)) {
			try {
				response.getWriter().write("200");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
