package boot.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	//员工登陆
	@RequestMapping("toempclient.action")
	public String toEmpClient(EmployeePwdBean employeePwdBean,
			HttpServletRequest request) {
		String gonghao = employeePwdBean.getEmpgonghao();
		if(loginService.makeSureNameAndPwd(employeePwdBean)) {
			HttpSession session = request.getSession();
			session.setAttribute("GONG_HAO",gonghao);
			return "forward:empmanager.jsp";
		}
		return "redirect:index.html";
	}
	//管理员登陆
	@RequestMapping("tomannageclient.action")
	public String toMannage(MannagerPwdBean mannagerPwdBean,HttpServletRequest request) {
		String phone = mannagerPwdBean.getPhone();
		if(loginService.makeSureMannagePhoneAndPwd(mannagerPwdBean)) {
			HttpSession session = request.getSession();
			session.setAttribute("GONG_HAO",phone);
			return "mannager";
		}
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
	//查看私信
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
