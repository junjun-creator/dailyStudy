package kr.or.connect.mvcexam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import kr.or.connect.mvcexam.dto.User;

@Controller
public class UserController {
	@GetMapping(path="/userform")
	public String userform() {
		return "userForm";
	}
	
	@PostMapping(path="/regist")
	public String regist(@ModelAttribute User user) { // DTO를 만들어서 객체에 저장해서 데이터를 전송하면 편함. 
													//해당 dto의 변수 명과 input태그들의 name들이 각각 같아야 spring이 알아서 매핑을 해서 정보를 저장함
													// User 객체를 생성하고 input 태그의 값들을 해당 객체 안에다가 넣어줌
		System.out.println("사용자가 입력한 user 정보입니다. 해당 정보를 이용하는 코드가 와야합니다.");
		System.out.println(user);
		return "regist";
		
	}
}
