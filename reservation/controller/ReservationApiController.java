package kr.or.connect.reservation.controller;

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

import kr.or.connect.reservation.dto.FileInfo;
import kr.or.connect.reservation.dto.WholeServiceInfo;
import kr.or.connect.reservation.service.ReservationService;

@RestController
@RequestMapping(path="/reservationlists")
public class ReservationApiController {
	@Autowired
	ReservationService reservationService;
	
	@GetMapping
	public Map<String, Object> list(@RequestParam(name="start", required=false, defaultValue="0") int start) {
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
		
		Map<String, Object> map = new HashMap<>();
		map.put("list",list);
		//model.addAttribute("productInfo",productInfo);
		//model.addAttribute("placeName",placeName);
		map.put("productImg",productImg);
		map.put("allItem",wholeServiceInfo);
		map.put("pageStartList",pageStartList);
		map.put("count",count);
		map.put("countCategory",countCategory);
		return map;
	}
	
	@PostMapping//ajax 통신 할것임
	public List<WholeServiceInfo> moreItems(@RequestBody int categoryId,@RequestBody int start) throws Exception {
		int category = categoryId;
		
		if(categoryId != 0) {
			int startNum = start;
			List<WholeServiceInfo> moreItemsCategory = reservationService.getItemsCategory(category, startNum);
			
			return moreItemsCategory;
		}
		else {
			int startNum = start;
			List<WholeServiceInfo> moreServiceInfo = reservationService.getAllItems(startNum);
			
			return moreServiceInfo;
		}
		//if 조건문으로 어떤 list를 전송해 줄것인지 선택하는 로직 작성
	}
}
