package kr.or.connect.reservationrestapi.controller;

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

import kr.or.connect.reservationrestapi.dto.*;
import kr.or.connect.reservationrestapi.service.ReservationService;

@Controller
public class ReservationController {
	@Autowired
	ReservationService reservationService;
	
	@GetMapping("/detail")
	public String details(HttpServletRequest request, Model model) {
		int id = Integer.parseInt(request.getParameter("id"));
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
	
	@GetMapping("/review")
	public String review(HttpServletRequest request, Model model) {
		int id = Integer.parseInt(request.getParameter("id"));
		int countComment = reservationService.getCountComment();
		List<DisplayInfo> to_id = reservationService.getId(id);
		List<CommentLists> allComment = reservationService.getAllComment(to_id.get(0).getProductId());
		List<FileInfo> productImg = reservationService.getProductImage();
		double avg;
		try {
			avg = reservationService.avgRate(to_id.get(0).getProductId());
		}catch(NullPointerException e) {
			avg = 0.0;
		}
		
		
		model.addAttribute("id",id);
		model.addAttribute("productImg",productImg);
		model.addAttribute("avgRate",avg);
		model.addAttribute("countComment",countComment);
		model.addAttribute("allComment",allComment);
		return "review";
	}
}
