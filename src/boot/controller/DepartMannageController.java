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
	//�򿪲��Ź���ҳ��
	@RequestMapping("tobmgl.action")
	public String toDepartInfo(@RequestParam(defaultValue = "1") Integer page,
			@RequestParam(defaultValue = "10")Integer rows,DepartInfoBean departInfoBean,
			Model model) {
		Page<DepartInfoBean> departPageBan = departInfoService.selectDepByCon(page, rows, departInfoBean);
		model.addAttribute("page", departPageBan);
		return "departinfo";
	}
	//ʵ�ֲ��Ź���ҳ��Ĺ���
	@RequestMapping("selectdep.action")
	public String departInfo(@RequestParam(defaultValue = "1") Integer page,
			@RequestParam(defaultValue = "10")Integer rows,DepartInfoBean departInfoBean,
			Model model) {
		Page<DepartInfoBean> departPageBan = departInfoService.selectDepByCon(page, rows, departInfoBean);
		model.addAttribute("page", departPageBan);
		return "departinfo";
	}
	//�޸Ĳ��ŵ���Ϣ
	@RequestMapping("updatedep.action")
	public void updateDepInfo(@RequestBody DepartInfoBean departInfoBean,HttpServletResponse response) {
		Integer rows = departInfoService.updateDepInfoById(departInfoBean);
		if(rows>0) {
			response.setContentType("text/html;charset=utf-8");
			try {
				response.getWriter().write("�޸ĳɹ�");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	//�޸Ĳ�����Ϣ
	@RequestMapping("deleteById.action")
	public String deleteDep(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		Integer rows = departInfoService.deleteDepById(id);
		if(rows>0) {
			return "departinfo";
		}
		return null;
	}
	//��Ӳ���
	@RequestMapping("insertDep.action")
	public String insertDep(@RequestBody DepartInfoBean departInfoBean,HttpServletResponse response) {
		Integer rows = departInfoService.insertDepInFo(departInfoBean);
		if(rows>0) {
			response.setContentType("text/html;charset=utf-8");
			try {
				response.getWriter().write("��ӳɹ�");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return "departinfo";
	}
	//to��Ч�����뿼��
	@RequestMapping("jxpd.action")
	public String toJiXiaoPingDing() {
		return "jixiaopingding";
	}
}
