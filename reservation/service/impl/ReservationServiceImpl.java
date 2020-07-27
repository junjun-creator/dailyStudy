package kr.or.connect.reservation.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.connect.reservation.dao.ReservationDao;
import kr.or.connect.reservation.dto.CommentLists;
import kr.or.connect.reservation.dto.DisplayInfo;
import kr.or.connect.reservation.dto.FileInfo;
import kr.or.connect.reservation.dto.Product;
import kr.or.connect.reservation.dto.WholeServiceInfo;
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
	public List<WholeServiceInfo> getAllItems(Integer start) {
		List<WholeServiceInfo> list = reservationDao.selectAllWholeServiceInfo(start,ReservationService.LIMIT);
		return list;
	}
	@Override
	@Transactional
	public List<WholeServiceInfo> getItemDetail(Integer id) {
		List<WholeServiceInfo> list = reservationDao.selectItemDetail(id);
		return list;
	}
	@Override
	public int getCount() {
		return reservationDao.selectCount();
	}
	@Override
	public int getCountCategory(Integer categoryId) {
		return reservationDao.selectCountCategory(categoryId);
	}
	@Override
	@Transactional
	public List<WholeServiceInfo> getItemsCategory(Integer categoryId, Integer start){
		List<WholeServiceInfo> list = reservationDao.selectItemsCategory(categoryId, start, ReservationService.LIMIT);
		return list;
	}

	@Override
	@Transactional
	public List<FileInfo> getProductImage() {
		List<FileInfo> list = reservationDao.selectAllProductImage();
		return list;
	}
	
	@Override
	@Transactional
	public List<CommentLists> getCommentLists() {
		List<CommentLists> list = reservationDao.selectAllComment(ReservationService.COMMENTLIMIT);
		return list;
	}
	@Override
	public double avgRate() {
		return reservationDao.avgRate();
	}
	@Override
	public int getCountComment() {
		return reservationDao.countComment();
	}

	@Override
	@Transactional
	public List<DisplayInfo> getLocation(Integer productId) {
		List<DisplayInfo> list = reservationDao.selectLocation(productId);
		return list;
	}

	@Override
	public List<DisplayInfo> getId(Integer id) {
		List<DisplayInfo> list = reservationDao.getId(id);
		return list;
	}
	
}
