package kr.or.connect.reservation.service;

import java.util.List;

import kr.or.connect.reservation.dto.*;

public interface ReservationService {
	public List<FileInfo> getPromotionImage();
	public List<Product> getProductInfo();
	public List<DisplayInfo> getPlaceName();
	public List<WholeServiceInfo> getAllItems(Integer start);
	public int getCount();
	
	public List<FileInfo> getProductImage();
	public static final Integer LIMIT = 4;
}
