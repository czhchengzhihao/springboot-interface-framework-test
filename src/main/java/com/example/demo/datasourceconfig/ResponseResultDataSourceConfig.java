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
 * @Description //TODO basePackages 对象相关mapper包
 * @Date 15:00 2022/5/17
 * @Param
 * @return
 **/
@Configuration
@MapperScan(basePackages = {"com.example.demo.mapper.responseresult"}, sqlSessionFactoryRef = "automationSqlSessionFactory")
public class ResponseResultDataSourceConfig {
    @Bean(name = "automationDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.automation")
    @Primary
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "automationSqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("automationDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:mapper/*.xml"));
        return bean.getObject();
    }

    @Primary
    @Bean(name = "automationTransactionManager")
    public DataSourceTransactionManager transactionManager(@Qualifier("automationDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Primary
    @Bean(name = "automationSqlSessionTemplate")
    public SqlSessionTemplate sqlSessionTemplate(@Qualifier("automationSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
