package kr.or.connect.reservation.controller;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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

import kr.or.connect.reservation.dto.CommentLists;
import kr.or.connect.reservation.dto.DisplayInfo;
import kr.or.connect.reservation.dto.FileInfo;
import kr.or.connect.reservation.dto.Product;
import kr.or.connect.reservation.dto.ReservationInfo;
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
		
		List<FileInfo> productImg = reservationService.getProductImage();
		List<WholeServiceInfo> itemDetail = reservationService.getItemDetail(id);
		List<DisplayInfo> location = reservationService.getLocation(id);
		List<DisplayInfo> to_id = reservationService.getId(id);
		int id_product = to_id.get(0).getProductId();
		int countComment = reservationService.getCountComment(id_product);
		List<FileInfo> mapImg = reservationService.getMapImg(id);
		List<CommentLists> commentLists = reservationService.getCommentLists(to_id.get(0).getProductId());
		double avg;
		try {
			avg = reservationService.avgRate(to_id.get(0).getProductId());
		}catch(NullPointerException e) {
			avg = 0.0;
		}

		model.addAttribute("id",id);
		model.addAttribute("toId",to_id);
		model.addAttribute("id_product",id_product);
		model.addAttribute("productImg",productImg);
		model.addAttribute("itemDetail",itemDetail);
		model.addAttribute("commentLists",commentLists);
		model.addAttribute("avgRate",avg);
		model.addAttribute("countComment",countComment);
		model.addAttribute("itemLocation",location);
		model.addAttribute("mapImg",mapImg);
		return "detail";
	}
	
	@GetMapping("/review")
	public String review(HttpServletRequest request, Model model) {
		int id = Integer.parseInt(request.getParameter("id"));
		
		List<DisplayInfo> to_id = reservationService.getId(id);
		int id_product = to_id.get(0).getProductId();
		int countComment = reservationService.getCountComment(id_product);
		List<CommentLists> allComment = reservationService.getAllComment(to_id.get(0).getProductId());
		List<FileInfo> productImg = reservationService.getProductImage();
		double avg;
		try {
			avg = reservationService.avgRate(to_id.get(0).getProductId());
		}catch(NullPointerException e) {
			avg = 0.0;
		}
		
		
		model.addAttribute("id",id);
		model.addAttribute("id_product",id_product);
		model.addAttribute("productImg",productImg);
		model.addAttribute("avgRate",avg);
		model.addAttribute("countComment",countComment);
		model.addAttribute("allComment",allComment);
		return "review";
	}
	
	@GetMapping("/reserve")
	public String reserve(HttpServletRequest request, Model model) {
		int id = Integer.parseInt(request.getParameter("id"));
		
		List<DisplayInfo> to_id = reservationService.getId(id);
		int id_product = to_id.get(0).getProductId();
		List<FileInfo> productImg = reservationService.getProductImage();
		List<DisplayInfo> placeAndOpeninghours = reservationService.getPlaceAndOpeninghours(id);
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd.");//날짜 포맷 형식 지정
		SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss");
		String currentDate = dateFormat.format(new Date());
		System.out.println(currentDate);
		
		Calendar cal = Calendar.getInstance();//캘린더 클래스를 통해 날짜 인스턴스 생성
		cal.set(2020, Calendar.AUGUST, 18);//날짜 정보 입력
		cal.add(Calendar.DATE, (int)(Math.random()*5+1));//date를 1~5일 뒤의 날로 랜덤 수정
		System.out.println(dateFormat.format(cal.getTime()));//캘린더 클래스로 생성한 날짜를 날짜 포맷 형식으로 적용해서 출력
		
		model.addAttribute("id",id);
		model.addAttribute("productImg",productImg);
		model.addAttribute("id_product",id_product);
		model.addAttribute("placeAndOpeninghours",placeAndOpeninghours);
		model.addAttribute("reservationDate",dateFormat.format(cal.getTime()));//예약 페이지에서 사용할 예약일자
		model.addAttribute("reservationDateTime",dateFormat2.format(cal.getTime()));//DB에 적용할 예약일자 포맷
		return "reserve";
	}
	
	@GetMapping("/bookinglogin")
	public String bookinglogin() {
		return "bookinglogin";
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
		return "redirect:main";
	}
}
