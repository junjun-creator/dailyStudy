package kr.or.connect.reservation.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.or.connect.reservation.dto.ReservationInfo;
import kr.or.connect.reservation.service.ReservationService;

@Controller
public class ReservationAdminController {
	@Autowired
	ReservationService reservationService;
	
	@PostMapping("/myreservation")
	public String myreservation(@RequestParam(name="resrv_email", required=true) String resrv_email, HttpSession session, Model model,
			HttpServletRequest request) {
		session.setAttribute("resrv_email", "true");
		session.setAttribute("email", resrv_email);
		
		List<ReservationInfo> myReservation = reservationService.getMyReservation(resrv_email);
		
		model.addAttribute("myreservation",myReservation);
		//이메일 정보를 가지고 DB에서 예약정보 가져와서 jsp로 출력하면 될듯... 근데 DB내용이 이상하다... ㅠㅠ
		return "myreservation";
	}
	
	@PostMapping("/cancel")
	public String cancelItem(@RequestParam(name="item_display_id", required=true) String display_id,
			@RequestParam(name="resrv_email", required=true) String resrv_email,
			RedirectAttributes redirectAttributes) {
		int item_display_id = Integer.parseInt(display_id);
		System.out.println(item_display_id);
		
		ReservationInfo reservationInfo = new ReservationInfo();
		reservationInfo.setDisplayInfoId(item_display_id);
		
		int update = reservationService.cancelItem(reservationInfo);
		redirectAttributes.addFlashAttribute("resrv_email", resrv_email);
		return "redirect:myreservation";
	}
}
