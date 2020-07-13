package kr.or.connect.reservation.dao;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.or.connect.reservation.config.ApplicationConfig;
import kr.or.connect.reservation.dao.ReservationDao;
import kr.or.connect.reservation.dto.Category;
import kr.or.connect.reservation.dto.FileInfo;
import kr.or.connect.reservation.dto.Product;
import kr.or.connect.reservation.dto.ProductImage;
import kr.or.connect.reservation.dto.Promotion;

public class ReservationDaoTest {

	public static void main(String[] args) {
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		ReservationDao reservationDao = ac.getBean(ReservationDao.class);
		/*
		List<Category> list= reservationDao.selectAllCategory();
		
		for(Category category : list) {
			System.out.println(category);
		}
		
		List<Promotion> list_promotion = reservationDao.selectAllPromotion();
		for(Promotion promotion : list_promotion) {
			System.out.println(promotion.getProductId());
		}
		
		List<FileInfo> list_promotionImage = reservationDao.selectAllPromotionFileName();
		for(FileInfo promotionImage : list_promotionImage) {
			System.out.println(promotionImage.getFileName()); // 프로모션에 애니메이션 걸어둘 이미지 파일들 이름 가져오기 성공
		}
		*/
		
	}

}
