package kr.or.connect.reservationrestapi.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
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
		int countComment = reservationService.getCountComment();
		List<FileInfo> productImg = reservationService.getProductImage();
		List<WholeServiceInfo> itemDetail = reservationService.getItemDetail(id);
		List<DisplayInfo> location = reservationService.getLocation(id);
		List<DisplayInfo> to_id = reservationService.getId(id);
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
		/*
		ModelAndView mav = new ModelAndView();
        mav.setViewName("detail");
        mav.addObject("map", map);
        
        return mav;*/
		return map;
	}
}
