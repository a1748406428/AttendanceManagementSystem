package boot.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import boot.po.NamePwdBean;
import boot.service.UserService;

@Controller
public class LoginController {
	@Autowired
	private UserService userService;

	// Õý³£µÇÂ¼
	@RequestMapping("/login.action")
	public String login(NamePwdBean namePwdBean, Model model, HttpSession session) {
		if (userService.selectNamePwd(namePwdBean)) {
//			model.addAttribute("msg", namePwdBean.getName());
			session.setAttribute("USER_SESSION", namePwdBean.getName());
			return "mannager";
		}
		return "login";
	}
	@RequestMapping("/mannager.action")
	public String toMannage() {
		return "mannager";
	}
}
