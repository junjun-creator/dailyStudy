package kr.or.connect.daoexam.main;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.or.connect.daoexam.config.ApplicationConfig;
import kr.or.connect.daoexam.dao.RoleDao;
import kr.or.connect.daoexam.dto.Role;

public class SelectAllTest {

	public static void main(String[] args) {
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class); // connection 하고
		
		RoleDao roleDao =ac.getBean(RoleDao.class); // roleDao 객체 공장에서 가져오고

		List<Role> list = roleDao.selectAll(); // db의 column 이름과 DTO 변수 이름이 같아야함 
		
		for(Role role: list) {
			System.out.println(role); 
		}
	}

}
