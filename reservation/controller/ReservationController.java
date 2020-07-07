package kr.or.connect.reservation.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.connect.reservation.dto.DisplayInfo;
import kr.or.connect.reservation.dto.FileInfo;
import kr.or.connect.reservation.dto.Product;
import kr.or.connect.reservation.service.ReservationService;

@Controller
public class ReservationController {
	@Autowired
	ReservationService reservationService;
	
	@GetMapping(path="/main")
	public String list(Model model) {
		List<FileInfo> list = reservationService.getPromotionImage();
		List<Product> productInfo = reservationService.getProductInfo();
		List<DisplayInfo> placeName = reservationService.getPlaceName();
		List<FileInfo> productImg = reservationService.getProductImage();
		
		model.addAttribute("list",list);
		model.addAttribute("productInfo",productInfo);
		model.addAttribute("placeName",placeName);
		model.addAttribute("productImg",productImg);
		
		return "main";
	}
	
}
