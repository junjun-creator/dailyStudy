package kr.or.connect.mvcexam.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

@Controller
public class GoodsController {
	@GetMapping("/goods/{id}") // PathVariable 값이 들어옴 {id} 
	public String getGoodsById(@PathVariable(name="id") int id, // PathVariable로 들어온 값을 저장
							   @RequestHeader(value="User-Agent", defaultValue="myBrowser") String userAgent, //RequestHeader 정보를 읽어서 저장
							  HttpServletRequest request, // httprequest를 호출해서 request 저장.
							  ModelMap model // 각각 값들을 저장할 공간
							  ) {
		
		String path = request.getServletPath(); // http request에서 servlet path 값 가져와서 저장
		
		System.out.println("id : " + id);
		System.out.println("user_agent : " + userAgent);
		System.out.println("path : " + path);
		
		model.addAttribute("id", id);
		model.addAttribute("userAgent", userAgent);
		model.addAttribute("path", path);
		return "goodsById";
	}
}
