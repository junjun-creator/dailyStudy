package kr.or.connect.reservation.service.impl;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.or.connect.reservation.config.ApplicationConfig;
import kr.or.connect.reservation.dto.FileInfo;
import kr.or.connect.reservation.service.ReservationService;

public class ReservationServiceTest {

	public static void main(String[] args) {
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		ReservationService reservationService = ac.getBean(ReservationService.class);
		
		List<FileInfo> list = reservationService.getPromotionImage();
		for(FileInfo promotionFileName : list) {
			System.out.println(promotionFileName.getFileName());
		}
	}

}
