//1번

package kr.or.connect.daoexam.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class DBConfig { //DB 연결을 책임지는 클래스이므로 연결에 관련된 정보가 필요하다.
	private String driverClassName = "com.mysql.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/connectdb?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC";
	private String username = "connectuser";
	private String password = "connect123!@#";
	
	//datasource를 통해서 db 접속을 할 것이므로 필요한 소스를 작성한다.
	@Bean
	public DataSource dataSource() { //이미 정의된 클래스를 공장에서 객체로 만들어 낼 것이기 때문에 메소드의 이름은 bean을 등록할때 id값과 같아야한다.
		BasicDataSource dataSource = new BasicDataSource();// connection관리를 할 것이기 때문에 관련된 정보를 setting 해야한다.
		dataSource.setDriverClassName(driverClassName);
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		return dataSource;
		
	}
}
