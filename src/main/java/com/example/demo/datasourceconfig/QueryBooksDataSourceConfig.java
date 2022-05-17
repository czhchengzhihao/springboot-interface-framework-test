package com.example.demo.datasourceconfig;


import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @Author ChengZhiHao
 * @Description //TODO admin
 * @Date 14:59 2022/5/17
 * @Param
 * @return
 **/
@Configuration
@MapperScan(basePackages = {"com.example.demo.mapper.querybooks"}, sqlSessionFactoryRef = "ssmBuildSqlSessionFactory")
public class QueryBooksDataSourceConfig {
    @Bean(name = "ssmBuildDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.ssmbuild")
    @Primary
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "ssmBuildSqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("ssmBuildDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:mapper/*.xml"));
        return bean.getObject();
    }

    @Bean(name = "ssmBuildTransactionManager")
    @Primary
    public DataSourceTransactionManager transactionManager(@Qualifier("ssmBuildDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "ssmBuildSqlSessionTemplate")
    @Primary
    public SqlSessionTemplate sqlSessionTemplate(@Qualifier("ssmBuildSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}

