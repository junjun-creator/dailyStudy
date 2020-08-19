package kr.or.connect.reservation.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.connect.reservation.dto.ReservationInfo;
import kr.or.connect.reservation.service.ReservationService;

@Controller
public class ReservationAdminController {
	@Autowired
	ReservationService reservationService;
	
	@PostMapping("/myreservation")
	public String myreservation(@RequestParam(name="resrv_email", required=true) String resrv_email, HttpSession session, Model model) {
		session.setAttribute("resrv_email", "true");
		session.setAttribute("email", resrv_email);
		
		List<ReservationInfo> myReservation = reservationService.getMyReservation(resrv_email);
		
		model.addAttribute("myreservation",myReservation);
		//이메일 정보를 가지고 DB에서 예약정보 가져와서 jsp로 출력하면 될듯... 근데 DB내용이 이상하다... ㅠㅠ
		return "myreservation";
	}
}
