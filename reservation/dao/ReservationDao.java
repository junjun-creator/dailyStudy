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
}
