package nonageshop.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
		urlPatterns = { "*.do" }, 
		loadOnStartup = 1,	//컨트롤러가 여러개 실행시 처음으로 실행되게 함
		initParams = { 
				@WebInitParam(name="configFile",
						value="/WEB-INF/commandHandler.properties")
		})
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Map<String, Command> handlerMap = new HashMap<>();
	

public void init(ServletConfig config) throws ServletException {
      String configFile = config.getInitParameter("configFile");
      try(InputStream is = config.getServletContext().getResourceAsStream(configFile)){
         Properties props = new Properties();
         props.load(is);
         //imputstream 이용ㅇ하여 props에 넘겨주어 load하면 key=value 형태로 만들어진다??? (commandHandler.properties 파일 참조)
         
         for(Entry<Object, Object> entry : props.entrySet()) {
//	            System.out.println(entry.getKey() + " : " + entry.getValue());
            Class<?> cls = Class.forName((String) entry.getValue());
            Command command = (Command) cls.newInstance();
            handlerMap.put((String) entry.getKey(), command);
         }
            for(Entry<String, Command> e : handlerMap.entrySet()) {
               System.out.println(e.getKey() + " : " + e.getValue());
            }
         }catch (IOException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
         }
      
}
//	/boardlist.do = " ~ "	<~ prop  

//		key			value
//	handlerMap 에는 key : /boardList.do
//					value : BoardListModel 객체가 있다


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = request.getRequestURI();				//	/web-study-12/board~~.do
		String contextPath = request.getContextPath();			//	/web-study-12
		
		System.out.println("command > " + command + " contextPath > " + contextPath);
		System.out.println(command.substring(contextPath.length()));
		if(command.indexOf(contextPath) == 0) {		// 존재한다면
			command = command.substring(contextPath.length());
		}
		Command commandHandler = handlerMap.get(command);
		System.out.println(commandHandler);
		
		
		
//		String viewPage = null;
//		commandHandler.process(request, response);
		String viewPage = commandHandler.process(request, response);
		//다형성....
		System.out.println("viewPage > " + viewPage);
		
		if(viewPage != null) {
			request.getRequestDispatcher(viewPage).forward(request, response);
		}
	}

}
