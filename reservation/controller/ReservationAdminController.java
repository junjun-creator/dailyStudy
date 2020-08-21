package kr.or.connect.reservation.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import kr.or.connect.reservation.dto.ReservationInfo;
import kr.or.connect.reservation.service.ReservationService;

@Controller
public class ReservationAdminController {
	@Autowired
	ReservationService reservationService;
	
	@RequestMapping(path="/myreservation")
	public String myreservation(@RequestParam(name="resrv_email", required=false) String resrv_email, HttpSession session, Model model,
			HttpServletRequest request) {
		session.setAttribute("resrv_email", "true");
		session.setAttribute("email", resrv_email);
		System.out.println(5);
		if(resrv_email == null)
			System.out.println("이메일 값이 없다");
		List<ReservationInfo> myReservation = reservationService.getMyReservation(resrv_email);
		/*
		Map<String,? > flashMap = RequestContextUtils.getInputFlashMap(request); 
		if(flashMap != null ) { 
			System.out.println(flashMap.get("resrv_email")); 
			myReservation = reservationService.getMyReservation((String)flashMap.get("resrv_email"));
		} 
		else { 
			myReservation = reservationService.getMyReservation(resrv_email);
		}*/

		
		model.addAttribute("myreservation",myReservation);
		return "myreservation";
	}
	
	@PostMapping("/cancel")
	public String cancelItem(@RequestParam(name="item_display_id", required=true) String display_id,
			@RequestParam(name="resrv_email", required=true) String resrv_email,
			RedirectAttributes redirectAttributes, Model model) {
		int item_display_id = Integer.parseInt(display_id);
		System.out.println(item_display_id);
		
		ReservationInfo reservationInfo = new ReservationInfo();
		reservationInfo.setDisplayInfoId(item_display_id);
		reservationInfo.setReservationEmail(resrv_email);
		
		int update = reservationService.cancelItem(reservationInfo);
		//redirectAttributes.addFlashAttribute("resrv_email", resrv_email);
		model.addAttribute("resrv_email", resrv_email);
		
		return "cancel";
	}//redirect 문제만 해결하자!!
}
