package kr.or.connect.reservationrestapi.controller;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import kr.or.connect.reservationrestapi.dto.*;
import kr.or.connect.reservationrestapi.service.ReservationService;

@Controller
public class ReservationController {
	@Autowired
	ReservationService reservationService;
	
	@GetMapping("/detail")
	public String details() {
		return "detail";
	}
	
	@GetMapping("/review")
	public String review() {
		return "review";
	}
	
	@GetMapping("/reserve")
	public String reserve() {
		return "reserve";
	}
	
	@PostMapping("/enroll")
	public String enroll(@RequestParam(name="name", required=true) String name,
			@RequestParam(name="tel", required=true) String tel,
			@RequestParam(name="email", required=true) String email,
			@RequestParam(name="item_id", required=true) String id,
			@RequestParam(name="reserve_date", required=true) String reserve_date) {
		
		List<DisplayInfo> to_id = reservationService.getId(Integer.parseInt(id));
		SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss");
		String currentDate = dateFormat2.format(new Date());
		System.out.println(currentDate);
		
		int id_product = to_id.get(0).getProductId();
		ReservationInfo reservationInfo = new ReservationInfo();
		
		reservationInfo.setProductId(id_product);
		reservationInfo.setDisplayInfoId(Integer.parseInt(id));
		reservationInfo.setReservationName(name);
		reservationInfo.setReservationTel(tel);
		reservationInfo.setReservationEmail(email);
		reservationInfo.setReservationDate(reserve_date);
		reservationInfo.setCreateDate(new Date());
		reservationInfo.setModifyDate(new Date());
		
		System.out.println(reservationInfo);
		System.out.println(id);
		System.out.println(id_product);
		System.out.println(name);
		System.out.println(tel);
		System.out.println(email);
		System.out.println(reserve_date);
		
		reservationService.addReservation(reservationInfo);
		return "redirect:reservationlists";
	}
}
