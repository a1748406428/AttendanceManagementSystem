package boot.controller;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.socket.TextMessage;
@Controller
public class SocketController {
	@Bean
	public MyHandler infoHandler() {
		return new MyHandler();
	}
	@RequestMapping("weblogin.action")
	public String login(HttpServletRequest request,HttpServletResponse response) {
		String username = request.getParameter("username");
		HttpSession session = request.getSession(false);
        session.setAttribute("SESSION_USERNAME", username);
		return "websocket";
	}
//	@RequestMapping("sendone.action")
//	@ResponseBody
//	public String send(HttpServletRequest request) {
//		String username = request.getParameter("username");
//		if(StringUtils.isEmpty(username)) {
//			infoHandler().sendMessageToUsers(new TextMessage("给所有用户发送消息"));
//		}else {
//			infoHandler().sendMessageToUser(username, new TextMessage("给"+username+"用户发送消息"));
//		}
//		return null;
//	}
	//广播消息
//	 @RequestMapping("broad.action")
//	    @ResponseBody
//	    public  String broad() {
//	        infoHandler().sendMessageToUsers(new TextMessage("发送一条小Broad"));
//	        System.out.println("群发成功");
//	        return "broad";
//	    }
//	 //测试
}
