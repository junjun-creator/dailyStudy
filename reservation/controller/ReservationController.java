package kr.or.connect.reservation.controller;

import java.io.PrintWriter;
import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.connect.reservation.dto.DisplayInfo;
import kr.or.connect.reservation.dto.FileInfo;
import kr.or.connect.reservation.dto.Product;
import kr.or.connect.reservation.dto.WholeServiceInfo;
import kr.or.connect.reservation.service.ReservationService;

@Controller
public class ReservationController {
	@Autowired
	ReservationService reservationService;
	
	@GetMapping(path="/main")
	public String list(@RequestParam(name="start", required=false, defaultValue="0") int start,
			   ModelMap model) {
		List<FileInfo> list = reservationService.getPromotionImage();
		//List<Product> productInfo = reservationService.getProductInfo();
		//List<DisplayInfo> placeName = reservationService.getPlaceName();
		List<FileInfo> productImg = reservationService.getProductImage();
		List<WholeServiceInfo> wholeServiceInfo = reservationService.getAllItems(start);
		
		int count = reservationService.getCount(); //requestparam 설정 하기.
		int pageCount = count/ReservationService.LIMIT;
		if(count % ReservationService.LIMIT > 0)
			pageCount++;
		
		List<Integer> pageStartList = new ArrayList<>();
		for(int i = 0; i < pageCount; i++) {
			pageStartList.add(i * ReservationService.LIMIT);
		}
		
		model.addAttribute("list",list);
		//model.addAttribute("productInfo",productInfo);
		//model.addAttribute("placeName",placeName);
		model.addAttribute("productImg",productImg);
		model.addAttribute("allItem",wholeServiceInfo);
		model.addAttribute("pageStartList",pageStartList);
		model.addAttribute("count",count);
		return "main";
	}
	
	@PostMapping(path="/main")//ajax 통신 할것임
	public @ResponseBody List<WholeServiceInfo> moreItems(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
		int start = Integer.parseInt(request.getParameter("start"));
		List<WholeServiceInfo> moreServiceInfo = reservationService.getAllItems(start);
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		
		return moreServiceInfo;
	}
	
}
