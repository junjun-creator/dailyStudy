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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import kr.or.connect.reservation.dto.CommentLists;
import kr.or.connect.reservation.dto.DisplayInfo;
import kr.or.connect.reservation.dto.FileInfo;
import kr.or.connect.reservation.dto.Product;
import kr.or.connect.reservation.dto.WholeServiceInfo;
import kr.or.connect.reservation.service.ReservationService;

@Controller
public class ReservationController {
	@Autowired
	ReservationService reservationService;
	
	@GetMapping("/main")
	public String list(@RequestParam(name="start", required=false, defaultValue="0") int start,
			   ModelMap model) {
		List<FileInfo> list = reservationService.getPromotionImage();
		//List<Product> productInfo = reservationService.getProductInfo();
		//List<DisplayInfo> placeName = reservationService.getPlaceName();
		List<FileInfo> productImg = reservationService.getProductImage();
		List<WholeServiceInfo> wholeServiceInfo = reservationService.getAllItems(start);
		
		int count = reservationService.getCount(); //requestparam 설정 하기.
		List<Integer> countCategory = new ArrayList<>();
		for(int categoryId=1;categoryId<=5;categoryId++) {
			countCategory.add(reservationService.getCountCategory(categoryId));
		}
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
		model.addAttribute("countCategory",countCategory);
		return "main";
	}
	
	@PostMapping("/main")//ajax 통신 할것임
	public @ResponseBody List moreItems(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
		int categoryId = Integer.parseInt(request.getParameter("categoryId"));
		
		if(categoryId != 0) {
			int start = Integer.parseInt(request.getParameter("start"));
			List<WholeServiceInfo> moreItemsCategory = reservationService.getItemsCategory(categoryId, start);
			response.setCharacterEncoding("UTF-8");
			response.setContentType("application/json");
			
			return moreItemsCategory;
		}
		else {
			int start = Integer.parseInt(request.getParameter("start"));
			List<WholeServiceInfo> moreServiceInfo = reservationService.getAllItems(start);
			
			response.setCharacterEncoding("UTF-8");
			response.setContentType("application/json");
			
			return moreServiceInfo;
		}
		//if 조건문으로 어떤 list를 전송해 줄것인지 선택하는 로직 작성
	}
	
	@GetMapping("/detail")
	public String details(HttpServletRequest request, Model model) {
		int id = Integer.parseInt(request.getParameter("id"));
		double avg = reservationService.avgRate();
		int countComment = reservationService.getCountComment();
		List<FileInfo> productImg = reservationService.getProductImage();
		List<WholeServiceInfo> itemDetail = reservationService.getItemDetail(id);
		List<CommentLists> commentLists = reservationService.getCommentLists();
		List<DisplayInfo> location = reservationService.getLocation(id);
		List<DisplayInfo> to_id = reservationService.getId(id);
		List<FileInfo> mapImg = reservationService.getMapImg(id);
		
		model.addAttribute("id",id);
		model.addAttribute("toId",to_id);
		model.addAttribute("productImg",productImg);
		model.addAttribute("itemDetail",itemDetail);
		model.addAttribute("commentLists",commentLists);
		model.addAttribute("avgRate",avg);
		model.addAttribute("countComment",countComment);
		model.addAttribute("itemLocation",location);
		model.addAttribute("mapImg",mapImg);
		return "detail";
	}
	
}
