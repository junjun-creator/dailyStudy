package kr.or.connect.reservation.dao;

public class ReservationDaoSqls {
	public static final String SELECT_ALL_CATEGORY = "SELECT id,name FROM category order by id";
	public static final String SELECT_ALL_PROMOTION = "SELECT product_id FROM promotion order by product_id";
	public static final String SELECT_PROMOTION_IMAGE = "SELECT file_name FROM file_info WHERE id IN (SELECT file_id FROM product_image WHERE type = 'th' AND product_id IN (SELECT product_id FROM promotion))";
	//전체리스트 정보 및 사진이름 쿼리
	public static final String SELECT_ALL_PRODUCT = "SELECT id,category_id, description, content FROM product ORDER BY id";
	public static final String SELECT_ALL_PLACENAME = "SELECT product_id,place_name FROM display_info ORDER BY product_id";
	public static final String SELECT_ALL_PRODUCTIMG = "SELECT file_name FROM file_info WHERE id IN (SELECT file_id FROM product_image WHERE type = 'th')";

	//카테고리 별 정보 및 사진이름 쿼리
	public static final String SELECT_PRODUCTS_CATEGORY = "SELECT category_id, description, content FROM product WHERE category_id = :category_id ORDER BY id";
	public static final String SELECT_PLACENAMES_CATEGORY = "SELECT product_id,place_name FROM display_info WHERE product_id in (SELECT id FROM product WHERE category_id = :category_id) ORDER BY product_id";
	public static final String SELECT_PRODUCTIMGS_CATEGORY = "SELECT file_name FROM file_info WHERE id IN (SELECT file_id FROM product_image WHERE type = 'th' AND product_id IN (SELECT id FROM product WHERE category_id = :category_id))";
		//dao 구현하고 service 구현하고, impl 구현하고, controller 구현.
}
