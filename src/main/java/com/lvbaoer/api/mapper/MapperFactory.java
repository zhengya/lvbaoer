/**
 * Copyright (C) 2016 MPen, Inc. All Rights Reserved.
 */
package com.lvbaoer.api.mapper;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

@Configuration
@EnableTransactionManagement
public class MapperFactory implements TransactionManagementConfigurer {

    @Autowired
    private DataSource dataSource;

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
        sqlSessionFactory.setDataSource(dataSource);
        return (SqlSessionFactory) sqlSessionFactory.getObject();
    }

    protected <T> MapperFactoryBean<T> getMapper(Class<T> mapperInterface) throws Exception {
        MapperFactoryBean<T> mapperFactoryBean = new MapperFactoryBean<T>();
        mapperFactoryBean.setSqlSessionFactory(sqlSessionFactory());
        mapperFactoryBean.setMapperInterface(mapperInterface);
        return mapperFactoryBean;
    }

    @Bean
    public MapperFactoryBean<UserMapper> userMapper() throws Exception {
        return getMapper(UserMapper.class);
    }

    @Bean
    public MapperFactoryBean<ReciveAddressMapper> reciveAddressMapper() throws Exception {
        return getMapper(ReciveAddressMapper.class);
    }

    @Bean
    public MapperFactoryBean<HealthTitleMapper> healthTitleMapper() throws Exception {
        return getMapper(HealthTitleMapper.class);
    }

    @Bean
    public MapperFactoryBean<CommentMapper> commentMapper() throws Exception {
        return getMapper(CommentMapper.class);
    }

    @Bean
    public MapperFactoryBean<ServeMapper> serveMapper() throws Exception {
        return getMapper(ServeMapper.class);
    }

    @Bean
    public MapperFactoryBean<HealthCenterMapper> healthCenterMapper() throws Exception {
        return getMapper(HealthCenterMapper.class);
    }

    @Bean
    public MapperFactoryBean<OrderServeMapper> orderServeMapper() throws Exception {
        return getMapper(OrderServeMapper.class);
    }

    @Bean
    public MapperFactoryBean<GoodsMapper> goodsMapper() throws Exception {
        return getMapper(GoodsMapper.class);
    }

    @Bean
    public MapperFactoryBean<StandardMapper> standardMapper() throws Exception {
        return getMapper(StandardMapper.class);
    }

    @Bean
    public MapperFactoryBean<OrderGoodsMapper> orderGoodsMapper() throws Exception {
        return getMapper(OrderGoodsMapper.class);
    }

    @Bean
    public MapperFactoryBean<OrderGoodsListMapper> orderGoodsListMapper() throws Exception {
        return getMapper(OrderGoodsListMapper.class);
    }

    @Bean
    public MapperFactoryBean<ShopCartMapper> shopCartMapper() throws Exception {
        return getMapper(ShopCartMapper.class);
    }

    @Bean
    public MapperFactoryBean<GoodsTypeMapper> goodsTypeMapper() throws Exception {
        return getMapper(GoodsTypeMapper.class);
    }

    @Bean
    public MapperFactoryBean<HealthCenterInfoMapper> healthCenterInfoMapper() throws Exception {
        return getMapper(HealthCenterInfoMapper.class);
    }

    @Override
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return new DataSourceTransactionManager(dataSource);
    }

}
