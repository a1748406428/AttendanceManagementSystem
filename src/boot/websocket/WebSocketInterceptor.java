package boot.websocket;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

public class WebSocketInterceptor extends HttpSessionHandshakeInterceptor{
	@Override
	public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wshandler,
			Map<String, Object> map) throws Exception {
		System.out.println("Before Handshake");
        if (request instanceof ServletServerHttpRequest) {
            ServletServerHttpRequest servletRequest = (ServletServerHttpRequest) request;
            HttpSession session = servletRequest.getServletRequest().getSession(false);
            if (session != null) {
                //ʹ��userName����WebSocketHandler���Ա㶨������Ϣ
                String gongHao = (String) session.getAttribute("GONG_HAO");  //һ��ֱ�ӱ���userʵ��
                if (gongHao!=null) {
                	map.put("WEBSOCKET_USERID",gongHao);
                }

            }else {
            	return false;
            }
        }
        return super.beforeHandshake(request, response, wshandler, map);
	}

	@Override
	public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler handler, Exception exception) {
		super.afterHandshake(request, response, handler, exception);
	}


}
