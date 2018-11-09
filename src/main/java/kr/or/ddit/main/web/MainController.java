package kr.or.ddit.main.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	
	/**  
	* Method   : main 
	* 작성자 : bms 
	* 변경이력 :  
	* @return  
	* Method 설명 : main 화면 요청  
	*/
	@RequestMapping("/main")
	public String main() {
		
		return "main";
		
		//viewName "main"
		// 우선순위에 따라 viewResolver 를 검색
		// 1. beanNameViewResolver
		/*	1-1. bean id(name)가 "main" 인 bean 이 있는지 확인	 ==> 없음
		 * 2. tilesViewResolver
		 *  2-1. tiles-config.xml 에서 main 이라는 이름의 definition 이 있는지 확인 ==> 있음
		 *  2-2. 해당 definition 에 맞는 layout 이 적용된 jsp를 결합하여 응답 생성 
		 */
	}
	
}
