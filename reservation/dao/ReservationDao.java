package kr.or.connect.reservation.dao;

import java.util.Collections;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import kr.or.connect.reservation.dto.*;
import static kr.or.connect.reservation.dao.ReservationDaoSqls.*;

@Repository
public class ReservationDao {
	private NamedParameterJdbcTemplate jdbc;
    private SimpleJdbcInsert insertAction;
    private RowMapper<Category> rowMapper_category = BeanPropertyRowMapper.newInstance(Category.class);
    private RowMapper<Promotion> rowMapper_promotion = BeanPropertyRowMapper.newInstance(Promotion.class);
    private RowMapper<FileInfo> rowMapper_promotionImage = BeanPropertyRowMapper.newInstance(FileInfo.class);
    private RowMapper<Product> rowMapper_productInfo = BeanPropertyRowMapper.newInstance(Product.class);
    private RowMapper<DisplayInfo> rowMapper_placeName = BeanPropertyRowMapper.newInstance(DisplayInfo.class);
    private RowMapper<FileInfo> rowMapper_productImage = BeanPropertyRowMapper.newInstance(FileInfo.class);
    
    public ReservationDao(DataSource dataSource) { //db연결을 위해 datasource 접근
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
        this.insertAction = new SimpleJdbcInsert(dataSource)
                .withTableName("reservation")
                .usingGeneratedKeyColumns("id");
    }
    
    public List<Category> selectAllCategory(){
		return jdbc.query(SELECT_ALL_CATEGORY,Collections.emptyMap(), rowMapper_category);
	}
    public List<Promotion> selectAllPromotion(){
    	return jdbc.query(SELECT_ALL_PROMOTION, Collections.emptyMap(), rowMapper_promotion);
    }
    public List<FileInfo> selectAllPromotionFileName(){
    	return jdbc.query(SELECT_PROMOTION_IMAGE, Collections.emptyMap(), rowMapper_promotionImage);
    }
    public List<Product> selectAllProductInfo(){
    	return jdbc.query(SELECT_ALL_PRODUCT, Collections.emptyMap(), rowMapper_productInfo);
    }
    public List<DisplayInfo> selectAllPlaceName(){
    	return jdbc.query(SELECT_ALL_PLACENAME, Collections.emptyMap(), rowMapper_placeName);
    }
    public List<FileInfo> selectAllProductImage(){
    	return jdbc.query(SELECT_ALL_PRODUCTIMG, Collections.emptyMap(), rowMapper_productImage);
    }
}
