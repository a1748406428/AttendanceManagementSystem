package boot.controller;

import java.io.IOException;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import boot.pojo.UserBean;
import boot.service.UserService;
import boot.vo.CityBean;
import boot.vo.TownBean;
import net.sf.json.JSONArray;

@Controller
public class RegisterController {
	@Autowired
	private UserService userService;

	// Ajax判断用户名是否存在
	@RequestMapping("/checkIsNULL.action")
	public void checkIsNull(UserBean userBean, HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		UserBean userBean2 = userService.selectByAll(request.getParameter("name"));
		// 此处捕获异常并处理，是因为数据库的值查出来为空值，比较判断就会出现异常
		try {
			if (request.getParameter("name").toString().equals(userBean2.getName().toString())) {
				response.setContentType("text/html;charset=utf-8");
				response.getWriter().write("<font color = \"red\">" + "用户名已存在,请重新输入!" + "</font>");
				System.out.println("用户名已经存在");
			}
		} catch (NullPointerException e) {
			if (request.getParameter("name").toString() == "") {
				response.setContentType("text/html;charset=utf-8");
				response.getWriter().write("<font color = \"red\"" + ">您输入的值为空,请重新输入!" + "</font>");
			} else {
				response.setContentType("text/html;charset=utf-8");
				response.getWriter().write("<font color = \"green\">" + "用户不存在，可以注册！" + "</font>");
			}

		}

	}

	// 省市联动后台
	@RequestMapping("/shengshi.action")
	public void provinceCity(HttpServletRequest request, HttpServletResponse response) {
		int pid = Integer.parseInt(request.getParameter("pId"));
		List<CityBean> cityBean = userService.selectCityByPid(pid);
		JSONArray jsonArray = JSONArray.fromObject(cityBean);
		try {
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write(jsonArray.toString());
		} catch (IOException e) {
			System.out.println("数组转换失败");
		}
	}

	// 市县联动后台
	@RequestMapping("/shixian.action")
	public void cityTown(HttpServletRequest request, HttpServletResponse response) {
		int cid = Integer.parseInt(request.getParameter("cId"));
		List<TownBean> townBean = userService.selectTownByCid(cid);
		JSONArray jsonArray = JSONArray.fromObject(townBean);
		try {
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write(jsonArray.toString());
		} catch (IOException e) {
			System.out.println("数组转换失败");
		}
	}
	// 后台注册
	@RequestMapping("/register.action")
	public String registerUser(HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {
		// 此处参数不用POJO类型的绑定，因为前台传来的数值无法绑定到POJO上
		UserBean userBean = new UserBean();
		String name = request.getParameter("Name");
		String password = request.getParameter("Password");
		String sex = request.getParameter("Sex");
		String phone = request.getParameter("Phone");
		String address = request.getParameter("Address");
		userBean.setName(name);
		System.out.println(name);
		userBean.setPassword(password);
		userBean.setSex(sex);
		userBean.setPhone(phone);
		userBean.setAddress(address);
		int rows = userService.insertIntoUser(userBean);
		if(rows>0) {
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write(".");
		}
		return null;
	}
}
