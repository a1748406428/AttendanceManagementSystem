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
import boot.pojo.EmployeeBean;
import boot.service.EmployeeService;

@Controller
public class EmployeeRegisterController {
	@Autowired
	private EmployeeService employeeService;

	@RequestMapping("/empreg.action")
	public String empregister() {
		return "empregister";
	}

	@RequestMapping("/toList.action")
	public String toList() {
		return "listemp";
	}

	// 查询员工
//	@RequestMapping("/selectall.action")
//	public String empInfo(Model model) {
//		List<EmployeeBean> employeeBean = employeeService.selectAllEmp();
//		model.addAttribute("allemp", employeeBean);
//		return "listemp";
//	}
	// 分页查询
	@RequestMapping("/selectbycon.action")
	public String selectByCon(@RequestParam(defaultValue = "1")Integer page,@RequestParam(defaultValue = "10")Integer rows,
			EmployeeBean employeeBean, Model model) {
		Page<EmployeeBean> emp = employeeService.findEmp(page,rows, employeeBean);
		model.addAttribute("page", emp);
		return "listemp";
	}

	// 根据条件查询所有信息
//	@RequestMapping("/selectbycon.action")
//	public String selectByCon(EmployeeBean employeeBean, Model model) {
//		List<EmployeeBean> employeeBean2 = employeeService.selectEmpByCon(employeeBean);
//		model.addAttribute("allemp", employeeBean2);
//		return "listemp";
//	}
	// 根据员工id删除信息
	@RequestMapping("/deleteEmpById.action")
	public String deleteEmpById(HttpServletRequest request, Model model) {
		int id = Integer.parseInt(request.getParameter("id"));
		employeeService.deleteById(id);
		return "listemp";
	}
	@RequestMapping("registerEmp.action")
	public String addIntoEmpTable(@RequestBody EmployeeBean employeeBean) {
		int row = employeeService.insertNewEmp(employeeBean);
		if(row>0) {
			return "listemp";			
		}
		return "listemp";
	}
	// 根据ID号修改信息
	@RequestMapping("/updateEmpById.action")
	public String updateEmpById(@RequestBody EmployeeBean employeeBean, HttpServletResponse response, Model model) {
		int rows = employeeService.updateById(employeeBean);
		if(rows>0) {
			response.setContentType("text/html;charset=utf-8");
			try {
				response.getWriter().write("修改成功");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return "listemp";
	}
}
