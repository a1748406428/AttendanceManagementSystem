package boot.controller;

import java.io.IOException;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import boot.dao.GetEmployeeNameDao;
import boot.po.EmployeePwdBean;
@Controller
public class MyHandler extends TextWebSocketHandler{
	@Autowired
	private GetEmployeeNameDao getEmployeeNameDao; 
	@Bean
	public MyHandler myHandler() {
		return new MyHandler();
	}
	//在线用户列表
	private static final Map<String,WebSocketSession> users;
	//用户标识
	private static final String USER_ID = "WEBSOCKET_USERID";
	//离线消息
	private static Map<String,TextMessage> tempMsg;
	//所有用户
	private List<EmployeePwdBean> list;
	
	static {
		users = new HashMap<>();
		tempMsg = new HashMap<String,TextMessage>();
	}
	
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		System.out.println("成功连接");
		String userid = getClientId(session);
		System.out.println(userid);
		if(userid != null) {
			users.put(userid, session);
			System.out.println("当前用户数量"+users.size());
			//发送离线消息
			try {
				Set<String> keySet = tempMsg.keySet();
				for (Iterator<String> iterator = keySet.iterator(); iterator.hasNext();) {
					try {
						String gonghao = iterator.next();
						//判断这位刚刚登陆的用户当管理员发送消息的时候在不在，如果不在说明账号被存入离线信息表中，然后根据名字进行匹配发送信息
						if(userid.equals(gonghao)) {
							users.get(gonghao).sendMessage(tempMsg.get(gonghao));
							iterator.remove();
						}
					} catch (NullPointerException e) {
					}
				}
			} catch (NullPointerException e) {
			}
		}
	}
	//获取用户标识
	private String getClientId(WebSocketSession session) {
		try {
			String userId = (String) session.getAttributes().get(USER_ID);
			return userId;
		} catch (Exception e) {
			return null;
		}
	}
	//js调用 websocket.send时候，会调用该方法
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		super.handleTextMessage(session, message);
        String sendToUser = message.getPayload().split("[|]")[0];
        String sendmessage = message.getPayload().split("[|]")[1];
        String sendUser = message.getPayload().split("[|]")[2];
        if(sendToUser.equals("everyone")){
            sendMessageToUsers(new TextMessage("发件人:"+sendUser+"\r\n"+"正文"+"\r\n"+sendmessage));
        }//(message.getPayload().startsWith(sendToUser))
        else{ //单发某人
            sendMessageToUser(sendToUser, new TextMessage("发件人:"+sendUser+"\r\n"+"正文"+"\r\n"+sendmessage));
            System.out.println(sendToUser+(new TextMessage("发件人:"+sendUser+"\r\n"+"正文"+"\r\n"+sendmessage)).toString());
        } 
	}
	//发送信息给指定用户
    public void sendMessageToUser(String userId, TextMessage message) throws IOException {
    	list = getEmployeeNameDao.getEmployeePwd();
    		 if(userId.equals("13218039275")) {
				if(users.get("13218039275").isOpen()) {
					users.get("13218039275").sendMessage(message);
				}
				//存储离线消息
				else if(!users.containsKey("13218039275")) {
					tempMsg.put("13218039275",message);
				}
				
			}
    		 else {
    		for (Iterator<EmployeePwdBean> iterator = list.iterator(); iterator.hasNext();) {
    			EmployeePwdBean employeePwdBean = (EmployeePwdBean) iterator.next();
    			if(userId.equals(employeePwdBean.getEmpgonghao())) {
    				try {
    					if (users.get(employeePwdBean.getEmpgonghao()).isOpen()) {
                            users.get(employeePwdBean.getEmpgonghao()).sendMessage(message);
                        }
					} catch (NullPointerException e) {
						tempMsg.put(employeePwdBean.getEmpgonghao(),message);
					}
    				break;
                    } 
    			}
    		}
    }
	//广播消息
    public void sendMessageToUsers(TextMessage message) throws IOException {
    	list = getEmployeeNameDao.getEmployeePwd();
    	try {
    		for (Iterator<EmployeePwdBean> iterator = list.iterator(); iterator.hasNext();) {
    			EmployeePwdBean employeePwdBean = (EmployeePwdBean) iterator.next();
    			String empGongHao = employeePwdBean.getEmpgonghao();
    			//如果某个员工下线的时候，则将这个员工的工号添加到离线信息表中，以便这个员工登陆时收到离线消息
                    if(!users.containsKey(empGongHao))
                    {
                    	tempMsg.put(empGongHao,message);
                    }else if (users.get(empGongHao).isOpen()) 
                    {
                        users.get(empGongHao).sendMessage(message);
                    }
    			
    		}
		} catch (NullPointerException e) {
		}
    }
	@Override
	public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
		if(session.isOpen()) {
			session.close();
		}
		System.out.println("连接出错");
		users.remove(getClientId(session));
	}
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		System.out.println("连接已关闭"+status);
		users.remove(getClientId(session));
	}
	@Override
	public boolean supportsPartialMessages() {
		return false;
	}
	
}
