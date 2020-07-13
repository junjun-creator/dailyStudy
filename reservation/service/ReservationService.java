package kr.or.connect.reservation.service;

import java.util.List;

import kr.or.connect.reservation.dto.*;

public interface ReservationService {
	public List<FileInfo> getPromotionImage();
	public List<WholeServiceInfo> getAllItems(Integer start);
	public int getCount();
	public List<WholeServiceInfo> getItemsCategory(Integer categoryId, Integer start);
	public int getCountCategory(Integer categoryId);
	public List<FileInfo> getProductImage();
	public static final Integer LIMIT = 4;
}
