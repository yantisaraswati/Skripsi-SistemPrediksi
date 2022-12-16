package com.yanti.inventorycontroll.config;

import javax.annotation.Resource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("classpath:META-INF/spring/inventorycontroll-infra.properties")
@ImportResource("classpath:META-INF/spring/inventorycontroll-env.xml")
public class DatabaseConfig {

	private static final String DATABASE_DRIVER = "database.driverClassName";
	private static final String DATABASE_URL = "database.url";
	private static final String DATABASE_USERNAME = "database.username";
	private static final String DATABASE_PASSWORD = "database.password";

	@Resource
	Environment env;

	@Bean(destroyMethod = "close")
	public BasicDataSource realDataSource() {

		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(env.getProperty(DATABASE_DRIVER));
		dataSource.setUrl(env.getProperty(DATABASE_URL));
		dataSource.setUsername(env.getProperty(DATABASE_USERNAME));
		dataSource.setPassword(env.getProperty(DATABASE_PASSWORD));
		dataSource.setMaxTotal(Integer.parseInt(env.getProperty("cp.maxActive")));
		dataSource.setMaxIdle(Integer.parseInt(env.getProperty("cp.maxIdle")));
		dataSource.setMinIdle(Integer.parseInt(env.getProperty("cp.minIdle")));
		dataSource.setMaxWaitMillis(Integer.parseInt(env.getProperty("cp.maxWait")));
		dataSource.setDefaultAutoCommit(false);

		return dataSource;
	}
}