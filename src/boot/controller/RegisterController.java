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

	// Ajax�ж��û����Ƿ����
	@RequestMapping("/checkIsNULL.action")
	public void checkIsNull(UserBean userBean, HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		UserBean userBean2 = userService.selectByAll(request.getParameter("name"));
		// �˴������쳣����������Ϊ���ݿ��ֵ�����Ϊ��ֵ���Ƚ��жϾͻ�����쳣
		try {
			if (request.getParameter("name").toString().equals(userBean2.getName().toString())) {
				response.setContentType("text/html;charset=utf-8");
				response.getWriter().write("<font color = \"red\">" + "�û����Ѵ���,����������!" + "</font>");
				System.out.println("�û����Ѿ�����");
			}
		} catch (NullPointerException e) {
			if (request.getParameter("name").toString() == "") {
				response.setContentType("text/html;charset=utf-8");
				response.getWriter().write("<font color = \"red\"" + ">�������ֵΪ��,����������!" + "</font>");
			} else {
				response.setContentType("text/html;charset=utf-8");
				response.getWriter().write("<font color = \"green\">" + "�û������ڣ�����ע�ᣡ" + "</font>");
			}

		}

	}

	// ʡ��������̨
	@RequestMapping("/shengshi.action")
	public void provinceCity(HttpServletRequest request, HttpServletResponse response) {
		int pid = Integer.parseInt(request.getParameter("pId"));
		List<CityBean> cityBean = userService.selectCityByPid(pid);
		JSONArray jsonArray = JSONArray.fromObject(cityBean);
		try {
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write(jsonArray.toString());
		} catch (IOException e) {
			System.out.println("����ת��ʧ��");
		}
	}

	// ����������̨
	@RequestMapping("/shixian.action")
	public void cityTown(HttpServletRequest request, HttpServletResponse response) {
		int cid = Integer.parseInt(request.getParameter("cId"));
		List<TownBean> townBean = userService.selectTownByCid(cid);
		JSONArray jsonArray = JSONArray.fromObject(townBean);
		try {
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write(jsonArray.toString());
		} catch (IOException e) {
			System.out.println("����ת��ʧ��");
		}
	}
	// ��̨ע��
	@RequestMapping("/register.action")
	public String registerUser(HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {
		// �˴���������POJO���͵İ󶨣���Ϊǰ̨��������ֵ�޷��󶨵�POJO��
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
