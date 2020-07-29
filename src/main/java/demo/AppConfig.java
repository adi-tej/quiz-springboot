package demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import demo.dao.UserHardCodeRepository;
import demo.dao.UserRepository;
import demo.service.UserService;
import demo.service.UserServiceImpl;

@Configuration
public class AppConfig {

	@Bean
	UserService userService(){
	    return new UserServiceImpl();
	}
	
	@Bean
	UserRepository userRepository() {
		return new UserHardCodeRepository();
	}
}
