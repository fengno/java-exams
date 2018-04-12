package com.imooc.config.dao;

import java.io.IOException;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

@Configuration
public class SessionFactoryConfig {

	// mybatis-config.xml配置文件的路径
	@Value("${mybatis_config_file}")
	private String mybatisConfigFilePath;
	// mybatis mapper文件所在路径
	@Value("${mapper_path}")
	private String mapperPath;
	// 实体类所在的package
	@Value("${entity_package}")
	private String entityPackage;
	
	@Autowired
	@Qualifier("dataSource") // 当一个接口有多个实现类时，可以通过该注解表明具体需要哪个实现类
	private DataSource dataSource;

	@Bean(name="sqlSessionFactory")
	public SqlSessionFactoryBean createSqlSessionFactoryBean() throws IOException {
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setConfigLocation(new ClassPathResource(mybatisConfigFilePath));
		PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		String packageSearchPath = PathMatchingResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX + mapperPath;
		bean.setMapperLocations(resolver.getResources(packageSearchPath));
		bean.setDataSource(dataSource);
		bean.setTypeAliasesPackage(entityPackage);
		return bean;
	}
}
