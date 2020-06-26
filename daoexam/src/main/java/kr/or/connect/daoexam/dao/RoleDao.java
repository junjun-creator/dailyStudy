// 4번

package kr.or.connect.daoexam.dao;

import java.util.*;

import javax.sql.DataSource;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import kr.or.connect.daoexam.dto.Role;

import static kr.or.connect.daoexam.dao.RoleDaoSqls.*; // 상수(static 변수)를 가져오기 위해 import

@Repository
public class RoleDao {
	private NamedParameterJdbcTemplate jdbc; //이름을 이용해서 바인딩(?에 값을 주는것)하거나 결과값을 가져올때 사용하는것
	private SimpleJdbcInsert insertAction;
	private RowMapper<Role> rowMapper = BeanPropertyRowMapper.newInstance(Role.class); //rowMapper는 select 한건한건의 결과를  DTO에 저장하는 목적으로 사용
										//BeanPropertyRowMapper 객체를 사용하여 column의 값을 자동으로 DTO에 담아주게 

	public RoleDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
		this.insertAction = new SimpleJdbcInsert(dataSource)
                .withTableName("role");

	}
	
	public List<Role> selectAll(){
		return jdbc.query(SELECT_ALL,Collections.emptyMap(), rowMapper); //Collections.emptyMap()은 sql문에 바인딩할 값이 있을경우에  바인딩할 값을 전달할 목적으로 사용하는 객체
	}
	
	public int insert(Role role) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(role); // dto의 변수명과 db의 column명을 매핑해서 알아서 객체를 생성해줌.
		return insertAction.execute(params); // execute메소드의 파라미터로 맵 객체를 전달하면 insert 완료
	}
	
	public int update(Role role) { // update는 NamedParameterJdbcTemplate 객체의 메소드를 이용해서 가져와야한다.
		SqlParameterSource params = new BeanPropertySqlParameterSource(role); // 변경하고자 하는 column과 dto의 변수를 매핑해서 객체 생성한것을
		return jdbc.update(UPDATE, params); // 두번째 인자의 파라미터로 넣어주면 적용된다.
	}
	
	public int deleteById(Integer id) {
		Map<String,?> params = Collections.singletonMap("roleId",id); // 이 메소드의 파라미터인 id값을 roleId와 매핑함. 그리고 roleId와 db column명 role_id를 mapping
		return jdbc.update(DELETE_BY_ROLE_ID, params);
	}
	
	public Role selectById(Integer id) {
		try {
			Map<String, ?> params = Collections.singletonMap("roleId", id); // 하나의 변수만 매핑할땐 이 방법으로 하면 된다.
			return jdbc.queryForObject(SELECT_BY_ROLE_ID, params, rowMapper);	 //해당 조건에 맞는 결과가 없다면 exception발생	
		}catch(EmptyResultDataAccessException e) {
			return null;
		}
	}
}
