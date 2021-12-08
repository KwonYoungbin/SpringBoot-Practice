package com.springbootTest.starterTest.jdbc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.*;
import com.springbootTest.starterTest.jdbc.util.JDBCConnectionManager;

@Configuration
@EnableConfigurationProperties(JDBCConnectionManagerProperties.class)
public class BoardAutoConfiguration {
	
	@Autowired
	private JDBCConnectionManagerProperties properties;
	
	@Bean
	@ConditionalOnMissingBean
	public JDBCConnectionManager getJDBCConnectionManager() {
		JDBCConnectionManager manager = new JDBCConnectionManager();
		manager.setDriverClass(properties.getDriverClass());
		manager.setUrl(properties.getUrl());
		manager.setUsername(properties.getUsername());
		manager.setPassword(properties.getPassword());
		return manager;
	}
}



//@Configuration
//public class BoardAutoConfiguration {
//	@Bean
//	@ConditionalOnMissingBean
//	public JDBCConnectionManager getJDBCConnectionManager() {
//		JDBCConnectionManager manager = new JDBCConnectionManager();
////		manager.setDriverClass("oracle.jdbc.driver.OracleDriver");
////		manager.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
////		manager.setUsername("hr");
////		manager.setPassword("hr");
//		manager.setDriverClass("org.h2.Driver");
//		manager.setUrl("jdbc:h2:tcp://localhost/~/test");
//		manager.setUsername("sa");
//		manager.setPassword("");
//		return manager;
//	}
//}
