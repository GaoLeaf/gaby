package com.smile.admin.boot;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author gaowenjin
 * @date 2021/1/6
 * @description:
 */
@ComponentScan("com.smile.admin.controller")
@ComponentScan("com.smile.admin.security")

@Configuration
public class MvcConfiguration {
}
