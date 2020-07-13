package kr.or.connect.reservation.dao;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import kr.or.connect.reservation.dto.*;

import static kr.or.connect.reservation.dao.ReservationDaoSqls.SELECT_COUNT;
import static kr.or.connect.reservation.dao.ReservationDaoSqls.*;

@Repository
public class ReservationDao {
	private NamedParameterJdbcTemplate jdbc;
    private SimpleJdbcInsert insertAction;
    private RowMapper<Category> rowMapper_category = BeanPropertyRowMapper.newInstance(Category.class);
    private RowMapper<Promotion> rowMapper_promotion = BeanPropertyRowMapper.newInstance(Promotion.class);
    private RowMapper<FileInfo> rowMapper_promotionImage = BeanPropertyRowMapper.newInstance(FileInfo.class);
    private RowMapper<WholeServiceInfo> rowMapper_wholeServiceInfo = BeanPropertyRowMapper.newInstance(WholeServiceInfo.class);
    
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
    
    public List<WholeServiceInfo> selectAllWholeServiceInfo(Integer start, Integer limit){
    	Map<String, Integer> params = new HashMap<>(); // 쿼리문에 바인딩을 위해 map을 씀
		params.put("start", start);
		params.put("limit", limit);
    	return jdbc.query(SELECT_ALL_ITEMS,params,rowMapper_wholeServiceInfo);
    }
    
    public List<WholeServiceInfo> selectItemsCategory(Integer categoryId, Integer start, Integer limit){
    	Map<String,Integer> params = new HashMap<>();
    	params.put("categoryId", categoryId);
    	params.put("start", start);
    	params.put("limit", limit);
    	return jdbc.query(SELECT_ITEMS_CATEGORY, params,rowMapper_wholeServiceInfo);
    }
    public int selectCount() {
		return jdbc.queryForObject(SELECT_COUNT, Collections.emptyMap(), Integer.class);
	}
    public int selectCountCategory(Integer categoryId) {
    	Map<String,Integer> params = new HashMap<>();
    	params.put("categoryId", categoryId);
		return jdbc.queryForObject(SELECT_COUNT_CATEGORY, params, Integer.class);
	}
    public List<FileInfo> selectAllProductImage(){
    	return jdbc.query(SELECT_ALL_PRODUCTIMG, Collections.emptyMap(), rowMapper_productImage);
    }
}
