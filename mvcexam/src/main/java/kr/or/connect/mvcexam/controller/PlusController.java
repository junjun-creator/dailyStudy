//2번 Controller 만들기!!

package kr.or.connect.mvcexam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PlusController {
	@GetMapping(path="/plusform") //요청들어오는 url
	public String plusform() {
		return "plusForm"; //이 컨트롤러에서는 특별히 하는 일이 없으므로 view의 이름만 전달해주면 됨 ~~ 이 view 보여주세요~
	}
	
	@PostMapping(path="/plus") // RequestParam 의 name과  input상자의 name이 일치하는 것 끼리 값을 매핑 해줌. required 필수인지?
	public String plus(@RequestParam(name = "value1", required = true) int value1,
			@RequestParam(name = "value2", required = true) int value2, ModelMap modelMap) {
		int result = value1 + value2;						// http request scope을 사용해도 된다. 하지만 그러면 web에 종속 되므로 ModelMap 사용한다.

		modelMap.addAttribute("value1", value1);			// 이렇게 ModelMap에 넣어두면 spring mvc가 알아서 request scope에다가 값을 매핑 해줌.
		modelMap.addAttribute("value2", value2);
		modelMap.addAttribute("result", result);  // key value 구조.
		return "plusResult"; // viewname
	}
	
	
			
}
