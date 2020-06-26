package kr.or.connect.daoexam.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.or.connect.daoexam.config.ApplicationConfig;
import kr.or.connect.daoexam.dao.RoleDao;
import kr.or.connect.daoexam.dto.Role;

public class JDBCTest {

	public static void main(String[] args) {
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class); // connection 하고
		
		RoleDao roleDao =ac.getBean(RoleDao.class);
		
		Role role = new Role();
		
//		role.setRoleId(600);
//		role.setDescription("ABC"); // 넣을 Role 정보 저장하고
//		
//		int count  = roleDao.insert(role); // insert
//		System.out.println("입력 되었습니다");
		
//		role.setRoleId(101);
//		role.setDescription("WEB PROGRAMMER");
//		
//		int count = roleDao.update(role);  // update
//		
//		System.out.println(count+"건 수정되었습니다");
		
		Role resultRole = roleDao.selectById(101); // 하나의 row만 뽑아옴
		System.out.println(resultRole);
		
		int deleteCount = roleDao.deleteById(600); // id 하나 삭제.
		System.out.println(deleteCount + "건 삭제하였습니다.");
	}

}
