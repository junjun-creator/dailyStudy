package kr.or.connect.daoexam.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({DBConfig.class}) //설정 파일을 여러개로 나눠서 작성 할 수 있다. Config를 각개로 만들어서 사용할 수 있다.
@ComponentScan(basePackages = {"kr.or.connect.daoexam.dao"})
public class ApplicationConfig {

}
