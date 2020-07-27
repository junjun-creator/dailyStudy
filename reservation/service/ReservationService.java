package kr.or.connect.reservation.service;

import java.util.List;

import kr.or.connect.reservation.dto.*;

public interface ReservationService {
	public List<FileInfo> getPromotionImage();
	public List<WholeServiceInfo> getAllItems(Integer start);
	public List<WholeServiceInfo> getItemDetail(Integer id);
	public List<CommentLists> getCommentLists();
	public List<DisplayInfo> getLocation(Integer productId);
	public List<DisplayInfo> getId(Integer id);
	public int getCount();
	public double avgRate();
	public int getCountComment();
	public List<WholeServiceInfo> getItemsCategory(Integer categoryId, Integer start);
	public int getCountCategory(Integer categoryId);
	public List<FileInfo> getProductImage();
	public static final Integer LIMIT = 4;
	public static final Integer COMMENTLIMIT = 3;
}
