package kr.or.connect.reservationrestapi.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import kr.or.connect.reservationrestapi.dto.*;
import kr.or.connect.reservationrestapi.service.ReservationService;

@RestController
public class ReservationApiController {
	@Autowired
	ReservationService reservationService;
	
	@GetMapping("/reservationlists")
	public Map<String, Object> list(@RequestParam(name="start", required=false, defaultValue="0") int start) {
		List<FileInfo> list = reservationService.getPromotionImage();
		//List<Product> productInfo = reservationService.getProductInfo();
		//List<DisplayInfo> placeName = reservationService.getPlaceName();
		List<FileInfo> productImg = reservationService.getProductImage();
		List<WholeServiceInfo> wholeServiceInfo = reservationService.getAllItems(start);
		
		int count = reservationService.getCount();
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
		
		Map<String, Object> map = new HashMap<>();
		map.put("list",list);
		map.put("productImg",productImg);
		map.put("allItem",wholeServiceInfo);
		map.put("pageStartList",pageStartList);
		map.put("count",count);
		map.put("countCategory",countCategory);
		return map;
	}
	
	@PostMapping("/reservationlists")//ajax 통신 할것임
	public List<WholeServiceInfo> moreItems(@RequestBody CategoryIdStartNum categoryItem) throws Exception {
		int category = categoryItem.getCategoryId();
		int startNum = categoryItem.getStart();
		if(category != 0) {
			
			List<WholeServiceInfo> moreItemsCategory = reservationService.getItemsCategory(category, startNum);
			
			return moreItemsCategory;
		}
		else {
			
			List<WholeServiceInfo> moreServiceInfo = reservationService.getAllItems(startNum);
			
			return moreServiceInfo;
		}
		//if 조건문으로 어떤 list를 전송해 줄것인지 선택하는 로직 작성
	}
	
	@GetMapping("/details")
	public Map<String, Object> detail(int id) throws Exception{
		
		List<FileInfo> productImg = reservationService.getProductImage();
		List<WholeServiceInfo> itemDetail = reservationService.getItemDetail(id);
		List<DisplayInfo> location = reservationService.getLocation(id);
		List<DisplayInfo> to_id = reservationService.getId(id);
		int countComment = reservationService.getCountComment(to_id.get(0).getProductId());
		List<FileInfo> mapImg = reservationService.getMapImg(id);
		List<CommentLists> commentLists = reservationService.getCommentLists(to_id.get(0).getProductId());
		double avg;
		try {
			avg = reservationService.avgRate(to_id.get(0).getProductId());
		}catch(NullPointerException e) {
			avg = 0.0;
		}
		
		Map<String, Object> map = new HashMap<>();
		map.put("id",id);
		map.put("countComment",countComment);
		map.put("productImg",productImg);
		map.put("itemDetail",itemDetail);
		map.put("location",location);
		map.put("toId",to_id);
		map.put("mapImg",mapImg);
		map.put("commentLists",commentLists);
		map.put("avg",avg);
		for(CommentLists a : commentLists) {
			System.out.println(a.getCreateDate());
		}
		/*
		ModelAndView mav = new ModelAndView();
        mav.setViewName("detail");
        mav.addObject("map", map);
        
        return mav;*/
		return map;
	}
	
	@GetMapping("/reviews")
	public Map<String, Object> review(HttpServletRequest request, Model model) {
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
		
		Map<String, Object> map = new HashMap<>();
		map.put("id",id);
		map.put("id_product", id_product);
		map.put("productImg",productImg);
		map.put("avgRate",avg);
		map.put("countComment",countComment);
		map.put("allComment",allComment);
		
		return map;
	}
	
	@GetMapping("/reserves")
	public Map<String, Object> reserve(int id){
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
		
		Map<String, Object> map = new HashMap<>();
		
		map.put("id",id);
		map.put("productImg",productImg);
		map.put("id_product",id_product);
		map.put("placeAndOpeninghours",placeAndOpeninghours);
		map.put("reservationDate",dateFormat.format(cal.getTime()));//예약 페이지에서 사용할 예약일자
		map.put("reservationDateTime",dateFormat2.format(cal.getTime()));//DB에 적용할 예약일자 포맷
		
		return map;
	}
}
