package kr.or.connect.reservation.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.connect.reservation.dao.ReservationDao;
import kr.or.connect.reservation.dto.DisplayInfo;
import kr.or.connect.reservation.dto.FileInfo;
import kr.or.connect.reservation.dto.Product;
import kr.or.connect.reservation.service.ReservationService;

@Service
public class ReservationServiceImpl implements ReservationService {
	@Autowired
	ReservationDao reservationDao;

	@Override
	@Transactional
	public List<FileInfo> getPromotionImage() {
		List<FileInfo> list = reservationDao.selectAllPromotionFileName();
		return list;
	}

	@Override
	@Transactional
	public List<Product> getProductInfo() {
		List<Product> list = reservationDao.selectAllProductInfo();
		return list;
	}

	@Override
	@Transactional
	public List<DisplayInfo> getPlaceName() {
		List<DisplayInfo> list = reservationDao.selectAllPlaceName();
		return list;
	}

	@Override
	@Transactional
	public List<FileInfo> getProductImage() {
		List<FileInfo> list = reservationDao.selectAllProductImage();
		return list;
	}
	

}
