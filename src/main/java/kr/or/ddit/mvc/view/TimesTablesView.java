package kr.or.ddit.mvc.view;

import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.View;

//9*9 단 출력 custom view
//spring customview 를 만들기 위해서는 View interface 를 구현할 필요가 있음
public class TimesTablesView implements View {

	@Override
	public String getContentType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter pw = response.getWriter();
		
		int max = (int) model.get("tables");
		
//		if(request.getParameter("table")==null) {
//			max=9;
//		} else {
//			max=Integer.parseInt(request.getParameter("table"));
//		}
		
		pw.println("<!DOCTYPE html>");
		pw.println("<html>");
		pw.println("	<head>");
		pw.println("		<meta charset=\"UTF-8\">");
		pw.println("		<title>Insert title here</title>");
		pw.println("			<style>");
		pw.println("				td {border: 1px solid pink}");
		pw.println("			</style>");
		pw.println("	</head>");
		pw.println("	<body>");
		pw.println("		<table>");
		for(int gob = 1;gob<10;gob++ ){
			pw.println("		<tr>");
			for(int dan = 2; dan <(max+1); dan++){
				pw.println("			<td>@"+dan+" 곱하기 " + gob +" = " + dan*gob + "@</td>");
			}
			pw.println("		</tr>");
			
		}
		pw.println("		</table>");
		pw.println("	</body>");
		pw.println("</html>");
		
	}

}
