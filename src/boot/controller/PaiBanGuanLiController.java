package boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PaiBanGuanLiController {
	
	//to�Ű����
	@RequestMapping("pbgl.action")
	public String toPaiBanGuanLi() {
		return "paibanguanli";
	}
	
}
