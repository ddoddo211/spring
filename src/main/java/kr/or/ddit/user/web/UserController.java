package kr.or.ddit.user.web;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.ddit.user.model.UserVo;

@RequestMapping("/user")
@Controller
public class UserController {
	
	public final String ID = "brown";
	public final String PW = "brownpass";
	
	@RequestMapping("/loginView")
	public String login() {
		
		
		
		return "/login/login";
	}
	
	@RequestMapping(value="/loginProcess", method=RequestMethod.POST)
	public String loginProcess(UserVo userVo) {
		
		if(userVo.getUserId().equals(ID)&&userVo.getPass().equals(PW)) {
			return "main";
		} else {
			return "/login/login";
			
		}
		
		
	}
	
	
	

}
