package nonageshop.controller.handler;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import nonageshop.controller.Command;
import nonageshop.dto.Kind;

public class KindListHandler implements Command {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Kind> kindList = Arrays.asList(
				new Kind(1, "Heels"),
				new Kind(2, "Boots"),
				new Kind(3, "Sandals"),
				new Kind(4, "Sneakers"),
				new Kind(5, "On Sale")
		);
		
		Gson gson = new Gson();
		String result = gson.toJson(kindList, new TypeToken<List<Kind>>() {}.getType());
		System.out.println(result);
		
		response.setContentType("application/json");
		response.setStatus(HttpServletResponse.SC_ACCEPTED);
		
		PrintWriter pw = response.getWriter();
		pw.print(result);
		pw.flush();
		
		return null;
	}

	}

/*
	★	Array -> List로 바꿀때
	List<String> outList = Arrays.asList("a", "b", "C");
	List<String> outList2 = Arrays.asList(new String[] { "a", "b", "C" });
	int[] list = { 1, 2, 3, 4, 5, 6};
	List list = Arrays.asList(list);

	★	List -> Array로 바꿀때
	List<String> arrayList = Arrays.asList("a","b","C");
	String[] array = arrayList.toArray(arrayList);


	★	JsonObject -> 객체 변환
	Gson gson = new Gson();
	String jsonString = "{'id':'jekalmin','name':'Min','age':26,'address':'Seoul'}";
	System.out.println(gson.fromJson(jsonString, Member.class));

	★	JsonArray -> List 변환
	Gson gson = new Gson(); 
	String jsonString = "[
		{'id':'jekalmin','name':'Min','age':26,'address':'Seoul'},
		{'id':'park','name':'park','age':27,'address':'Seoul'},
		{'id':'kim','name':'kim','age':28,'address':'Incheon'}
	]";
	// 방법1
	Member[] array = gson.fromJson(jsonString, Member[].class);
	List<Member> list = Arrays.asList(array);
	
	// 방법2
	List<Member> list2 = gson.fromJson(jsonString, new TypeToken<List<Member>>(){}.getType());
	
	

*/