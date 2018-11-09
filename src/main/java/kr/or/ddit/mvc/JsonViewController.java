package kr.or.ddit.mvc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

@Controller
public class JsonViewController {
	
	@ModelAttribute
	public void modelAttribute(Model model) {
		List<String> rangers = new ArrayList<>();
		rangers.add("brown");
		rangers.add("cony");
		rangers.add("sally");
		
		model.addAttribute("rangers",rangers);
	}
	
	
	
	
	//json 응답을 생성하는 url 요청
	//레인저스 정보를 json 으로 응답을 생성
	@RequestMapping("/rangersJsonView")
	public String rangersJsonView() {
		
		//json 형태의 직접 작성해야할 문자열을
		// 컬렉션, object 정보를 json 문자열로 생성
		
		
		//json 을 생성하는 uri
		return "jsonView";
		//<bean id="jsonView" class="org.springframework.web.servlet.view.json.MappingJackson2JsonView">
		
		//controller 에서 리턴하는 viewName(jsonView) 를 처리하기 위해
		//처리해줄 viewResolver 를 우선순위에 따라서 
		//1. beanNameViewResolver 를 통해 view 를 생성하려고 시도하게됨
		//2. jsonView 라고 하는 일므의 빈이 있는지를 확인 ===> 존재
		//3. 해당 viewName 과 동일한 이름의 빈이 있으므로 internalResourceViewResolver 까지 가지 않고 
		// beanNameViewResolver 에서 처리하게됨
		
		//만약 viewName 이 "hello" 인경우라면
		// 처리해줄 viewResolver 를 우선순위에 따라서
		//1. beanNameViewResolver 를 통해 view 를 생성하려고 시도하게됨
		//2. jsonView 라고 하는 일므의 빈이 있는지를 확인 ===> 존재하지 않음
		//	<bean id="hello" 이런 빈이 있는지
		//3. 다음 우선순위인 internalResourceViewResolver 가 처리하게됨
		// internalResourceViewResolver 는 해당 리소스(hello.jsp) 가 있는지 여부를 상관하지않고 
		//prefix, suffix 를 무조건 반영하여 forward 실행 
		//그렇기 때문에 오타, 혹은 존재하지 않는 파일(jsp) 를 리턴하게되면 
		// 에러가 발생
		// 그런 이유로 internalResourceViewResolver 는 viewResolver 설정시
		// 우선 순위를 최 하위로 둔다
		
	}

	//http://localhost:8081/rangersJsonViewObj
	@RequestMapping("rangersJsonViewObj")
	public View rangersJsonViewObj() {
		
		//json 생성을 담당하는 view
		return new MappingJackson2JsonView();
	}
	
	
	
} // 클래스 종료


























//
