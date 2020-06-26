package kr.or.connect.daoexam.main;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource; //data source는 sql꺼.... 이걸로 20분 버림..

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.or.connect.daoexam.config.ApplicationConfig;

public class DataSourceTest {

	public static void main(String[] args) {
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class); //해당 클래스파일에서 정보를 가져와서 객체공장을 만들거다!
		
		DataSource ds = ac.getBean(DataSource.class); // 데이터 소스 객체를 bean을 통하여 얻어낼 수 있다.
		Connection conn = null;
		try {
			conn = ds.getConnection(); //connection 변수에 bean으로 생성한 객체의 getConnection 메소드를 통해서 연결.
			if(conn!=null) {
				System.out.println("접속성공!");
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
