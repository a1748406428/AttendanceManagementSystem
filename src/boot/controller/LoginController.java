package boot.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import boot.dao.GetEmpSelfInFoDao;
import boot.dao.GetEmployeeNameDao;
import boot.po.EmployeePwdBean;
import boot.po.MannagerPwdBean;
import boot.pojo.NoticeBean;
import boot.service.GetEmpSelfInfoService;
import boot.service.LoginService;
import boot.service.UserService;

@Controller
public class LoginController {
	@Autowired
	private LoginService loginService;
	
	@Autowired
	private GetEmpSelfInfoService getEmpSelfInfoService;
	
	@Autowired
	private GetEmpSelfInFoDao getEmpSelfInFoDao;
	
	@Autowired
	private GetEmployeeNameDao getEmployeeNameDao;
	//Ա����½
	@RequestMapping("toempclient.action")
	public String toEmpClient(EmployeePwdBean employeePwdBean,
			HttpServletRequest request,Model model) {
		String gonghao = employeePwdBean.getEmpgonghao();
		String name = getEmpSelfInFoDao.selectEmpName(gonghao);
		if(loginService.makeSureNameAndPwd(employeePwdBean)) {
			HttpSession session = request.getSession();
			session.setAttribute("GONG_HAO",gonghao);
			model.addAttribute("empname", name);
			return "empmanager";
		}
		return "redirect:index.html";
	}
	//����Ա��½
	@RequestMapping("tomannageclient.action")
	public String toMannage(MannagerPwdBean mannagerPwdBean,HttpServletRequest request,Model model) {
		String phone = mannagerPwdBean.getPhone();
		String manname = getEmployeeNameDao.selectManName(phone);
		if(loginService.makeSureMannagePhoneAndPwd(mannagerPwdBean)) {
			HttpSession session = request.getSession();
			session.setAttribute("GONG_HAO",phone);
			model.addAttribute("manname", manname);
			return "mannager";
		}
		return "redirect:index.html";
	}
	//����Ա�˳���ǰ�˺�
	@RequestMapping("logout.action")
	public String logoutToIndex(HttpSession session) {
		session.invalidate();
		return "redirect:index.html";
	}
	@RequestMapping("/mannager.action")
	public String toManageTest() {
		return "mannager";
	}

	@RequestMapping("qjsqq.action")
	public String toEmpQingJiaShenQing(@RequestParam(value="gonghao")String gonghao,HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.setAttribute("GONG_HAO", gonghao);
		return "qjsq";
	}
	@RequestMapping("xxzx.action")
	public String toEmpXiaoXiZhongXin(NoticeBean noticeBean,Model model) {
		List<NoticeBean> results = getEmpSelfInfoService.selectPersonNotice(noticeBean);
		model.addAttribute("personNotice", results);
		return "xxzx";
	}
	//�鿴˽��
	@RequestMapping("privatenotice.action")
	public String selectPrivateNotice(NoticeBean noticeBean,Model model) {
		List<NoticeBean> results = getEmpSelfInfoService.selectPersonPrivateNotice(noticeBean);
		model.addAttribute("personNotice", results);
		return "xxzx";
	}
	
	
	@RequestMapping("gsck.action")
	public String toEmpGongShiChaKan() {
		return "gsck";
	}
}
