package kr.or.connect.reservation.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ReservationAdminController {
	@PostMapping("/myreservation")
	public String myreservation(@RequestParam(name="resrv_email", required=true) String resrv_email, HttpSession session) {
		session.setAttribute("resrv_email", "true");
		session.setAttribute("email", resrv_email);
		
		//이메일 정보를 가지고 DB에서 예약정보 가져와서 jsp로 출력하면 될듯... 근데 DB내용이 이상하다... ㅠㅠ
		return "myreservation";
	}
}
