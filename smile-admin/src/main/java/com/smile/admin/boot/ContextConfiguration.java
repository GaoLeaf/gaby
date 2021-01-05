package com.smile.admin.boot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author gaowenjin
 * @date 2020/12/31
 * @description:
 */
@MapperScan("com.smile.admin.mapper.*")

@Configuration
public class ContextConfiguration {



}
