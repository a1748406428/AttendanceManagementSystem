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
	//�����û��б�
	private static final Map<String,WebSocketSession> users;
	//�û���ʶ
	private static final String USER_ID = "WEBSOCKET_USERID";
	//������Ϣ
	private static Map<String,TextMessage> tempMsg;
	//�����û�
	private List<EmployeePwdBean> list;
	
	static {
		users = new HashMap<>();
		tempMsg = new HashMap<String,TextMessage>();
	}
	
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		System.out.println("�ɹ�����");
		String userid = getClientId(session);
		System.out.println(userid);
		if(userid != null) {
			users.put(userid, session);
			System.out.println("��ǰ�û�����"+users.size());
			//����������Ϣ
			try {
				Set<String> keySet = tempMsg.keySet();
				for (Iterator<String> iterator = keySet.iterator(); iterator.hasNext();) {
					try {
						String gonghao = iterator.next();
						//�ж���λ�ոյ�½���û�������Ա������Ϣ��ʱ���ڲ��ڣ��������˵���˺ű�����������Ϣ���У�Ȼ��������ֽ���ƥ�䷢����Ϣ
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
	//��ȡ�û���ʶ
	private String getClientId(WebSocketSession session) {
		try {
			String userId = (String) session.getAttributes().get(USER_ID);
			return userId;
		} catch (Exception e) {
			return null;
		}
	}
	//js���� websocket.sendʱ�򣬻���ø÷���
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		super.handleTextMessage(session, message);
        String sendToUser = message.getPayload().split("[|]")[0];
        String sendmessage = message.getPayload().split("[|]")[1];
        String sendUser = message.getPayload().split("[|]")[2];
        if(sendToUser.equals("everyone")){
            sendMessageToUsers(new TextMessage("������:"+sendUser+"\r\n"+"����"+"\r\n"+sendmessage));
        }//(message.getPayload().startsWith(sendToUser))
        else{ //����ĳ��
            sendMessageToUser(sendToUser, new TextMessage("������:"+sendUser+"\r\n"+"����"+"\r\n"+sendmessage));
            System.out.println(sendToUser+(new TextMessage("������:"+sendUser+"\r\n"+"����"+"\r\n"+sendmessage)).toString());
        } 
	}
	//������Ϣ��ָ���û�
    public void sendMessageToUser(String userId, TextMessage message) throws IOException {
    	list = getEmployeeNameDao.getEmployeePwd();
    		 if(userId.equals("13218039275")) {
				if(users.get("13218039275").isOpen()) {
					users.get("13218039275").sendMessage(message);
				}
				//�洢������Ϣ
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
	//�㲥��Ϣ
    public void sendMessageToUsers(TextMessage message) throws IOException {
    	list = getEmployeeNameDao.getEmployeePwd();
    	try {
    		for (Iterator<EmployeePwdBean> iterator = list.iterator(); iterator.hasNext();) {
    			EmployeePwdBean employeePwdBean = (EmployeePwdBean) iterator.next();
    			String empGongHao = employeePwdBean.getEmpgonghao();
    			//���ĳ��Ա�����ߵ�ʱ�������Ա���Ĺ�����ӵ�������Ϣ���У��Ա����Ա����½ʱ�յ�������Ϣ
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
		System.out.println("���ӳ���");
		users.remove(getClientId(session));
	}
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		System.out.println("�����ѹر�"+status);
		users.remove(getClientId(session));
	}
	@Override
	public boolean supportsPartialMessages() {
		return false;
	}
	
}
