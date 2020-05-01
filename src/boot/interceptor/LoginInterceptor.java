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
		// ����index.html����register.jsp���Ա�ֱ�ӷ��ʣ������Ľ������ؿ���
		if (url.indexOf("index.html") >= 0) {
			return true;
		}
		// ��ȡsession
		HttpSession httpSession = request.getSession();
		String name = (String) httpSession.getAttribute("GONG_HAO");
		if (name != null) {
			return true;
		}
		// �����������ĸ�����ʾ��Ϣ�������ض��򵽵�½����
		request.setAttribute("msg", "����û�е�½�����½");
		response.sendRedirect("index.html");
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
