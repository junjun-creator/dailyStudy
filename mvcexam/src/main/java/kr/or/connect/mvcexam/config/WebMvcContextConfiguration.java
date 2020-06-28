// 1번 configuration 설정  >> dispatcherServlet이 실행될 때 읽어들이는 설정 파일이다.

package kr.or.connect.mvcexam.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"kr.or.connect.mvcexam.controller"})  //요기 url을 스캔해라~~~
public class WebMvcContextConfiguration extends WebMvcConfigurerAdapter {
	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/assets/**").addResourceLocations("classpath:/META-INF/resources/webjars/").setCachePeriod(31556926);
        registry.addResourceHandler("/css/**").addResourceLocations("/css/").setCachePeriod(31556926);
        registry.addResourceHandler("/img/**").addResourceLocations("/img/").setCachePeriod(31556926);
        registry.addResourceHandler("/js/**").addResourceLocations("/js/").setCachePeriod(31556926);
    }//asset,css,img,js 로 들어오는 요청은 뒤에 위치에서 찾아라~~~~ 하고 연결해주는 설정이다.(xml에서 url mapping을 슬래쉬'/'로 해놔서 모든 요청을 다 받아버리기 때문에 이런 설정 필요
 
    // default servlet handler를 사용하게 합니다.
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable(); // mapping 정보가 없는 url은 defaultServletRequestHandler가 처리하도록 한다.
    }
   
    @Override
    public void addViewControllers(final ViewControllerRegistry registry) {
    		System.out.println("addViewControllers가 호출됩니다. ");
        registry.addViewController("/").setViewName("main"); // 요청 자체가 '/'로 들어오면 main이라고 하는 이름의 view로 보여주도록 한다.
    } // 특정 url에 대한 처리를 컨트롤러 클래스 작성 없이 매핑할 수 있도록 해주는 것이다.
    // 이걸로 view가 완성되는것이 아니라 아래의 viewresolver가 필요하다.
    
    @Bean// controller에서 String으로 return한 애들이 viewname이 되고, 그 이름을 가지고 아래의 경로로 View를 제공한다(?) 이런 것 인듯 하다
    public InternalResourceViewResolver getInternalResourceViewResolver() { 
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");//viewname 앞에다가 붙이고
        resolver.setSuffix(".jsp"); // view 뒤에다가 붙이고.
        //해당 위치에 파일이 존재해야함. resolver가 그걸 찾아서 view해주는거 같다
        return resolver;
    }
}
