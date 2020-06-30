package kr.or.connect.reservation.dao;

public class ReservationDaoSqls {
	public static final String SELECT_ALL_CATEGORY = "SELECT id,name FROM category order by id";
	public static final String SELECT_ALL_PROMOTION = "SELECT product_id FROM promotion order by product_id";
	public static final String SELECT_PROMOTION_IMAGE = "SELECT file_name FROM file_info WHERE id IN (SELECT file_id FROM product_image WHERE type = 'th' AND product_id IN (SELECT product_id FROM promotion))";
//	public static final String UPDATE = "UPDATE role SET description = :description WHERE ROLE_ID = :roleId";
//	public static final String SELECT_BY_ROLE_ID = "SELECT role_id, description FROM role where role_id = :roleId";
//	public static final String DELETE_BY_ROLE_ID = "DELETE FROM role WHERE role_id = :roleId";
}
