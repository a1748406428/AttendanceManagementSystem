package boot.controller;

import java.io.IOException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import boot.service.DepartInfoService;

@Controller
public class DepEmpMannageController {
	@Autowired
	private DepartInfoService departInfoService;
	// ������Ա����
	@RequestMapping("bmcygl.action")
	public String toDepEmpManage() {
		return "depempmannage";
	}

	//��ѯ��Ϣ
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
	//��ͬ��
	@RequestMapping("/butongyi.action")
	public void buTongYi(@RequestParam Integer eid,@RequestParam String status,HttpServletResponse response) {
		int rows = departInfoService.updateMsgStatus(eid,status);
		if(rows>0) {
			try {
				response.getWriter().write("δͬ��");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	//�޸���Ϣ
	@RequestMapping(value = "/tongyi.action",method = RequestMethod.POST)
	public void tongYi(@RequestParam Integer eid,@RequestParam String status,HttpServletResponse response) {
		System.out.println(eid+"==="+status);
		int rows = departInfoService.updateMsgStatus(eid,status);
		if(rows>0) {
			try {
				response.setContentType("text/html;charset=utf-8");
				response.getWriter().write(eid);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	//����ɾ��
	@RequestMapping("deleteOneByeid.action")
	public void deleteByOneId(@RequestParam Integer eid) {
		departInfoService.deleteOneMsgByEid(eid);
	}
	//��λ����Ч��
	@RequestMapping("bumenliandong.action")
	@ResponseBody
	public List<PostBean> dynamicDepAndPost(@RequestBody PostBean postBean){
		List<PostBean> result = departInfoService.dynamicDepAndPost(postBean.getDid());
		return result;
	}
	//�޸ĸ�λ
	@RequestMapping("updateGangWeiById.action") 
	public String updateGangWeiByEid(EmployeeBean employeeBean) {
		int rows = departInfoService.updateEmpDepPostById(employeeBean);
		System.out.println(employeeBean.getDepartid()+employeeBean.getId()+employeeBean.getPostid());
		if(rows>0)
			return "depempmannage";
		return null;
	}
}
