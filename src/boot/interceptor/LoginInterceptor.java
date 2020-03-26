package boot.interceptor;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String url = request.getRequestURI();
		// ����index.jsp����register.jsp���Ա�ֱ�ӷ��ʣ������Ľ������ؿ���
		if (url.indexOf("login.action") >= 0 || url.indexOf("checkIsNULL.action") >= 0
				|| url.indexOf("shengshi.action") >= 0 || url.indexOf("shixian.action") >= 0
				|| url.indexOf("empreg.action") >= 0) {
			return true;
		}
		// ��ȡsession
		HttpSession httpSession = request.getSession();
		String name = (String) httpSession.getAttribute("USER_SESSION");
		if (name != null) {
			return true;
		}
		// �����������ĸ�����ʾ��Ϣ�������ض��򵽵�½����
		request.setAttribute("msg", "����û�е�½�����½");
		response.sendRedirect("index.jsp");
		return false;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}

}
