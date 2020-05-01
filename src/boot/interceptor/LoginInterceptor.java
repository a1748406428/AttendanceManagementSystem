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
		// 除了index.html或者register.jsp可以被直接访问，其他的进行拦截控制
		if (url.indexOf("index.html") >= 0) {
			return true;
		}
		// 获取session
		HttpSession httpSession = request.getSession();
		String name = (String) httpSession.getAttribute("GONG_HAO");
		if (name != null) {
			return true;
		}
		// 不符合条件的给出提示信息，并且重定向到登陆界面
		request.setAttribute("msg", "您还没有登陆，请登陆");
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
