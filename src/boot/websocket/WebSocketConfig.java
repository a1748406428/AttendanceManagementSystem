package boot.websocket;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import boot.controller.MyHandler;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSocket
@EnableWebMvc
public class WebSocketConfig extends WebMvcConfigurerAdapter implements WebSocketConfigurer {
	@Bean
	public TextWebSocketHandler myHandler() {
		return (TextWebSocketHandler) new MyHandler();
	}
	//×¢²áws´¦ÀíÆ÷
	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		registry.addHandler(myHandler(), "myHandler.action").addInterceptors(new WebSocketInterceptor());
	}

}
