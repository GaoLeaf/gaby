package com.smile.admin.mock;

import com.smile.admin.boot.ContextConfiguration;
import com.smile.admin.boot.ServiceConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Import;

/**
 * @author gaowenjin
 * @date 2020/12/31
 * @description:
 */
@Import({ContextConfiguration.class, ServiceConfiguration.class})

@EnableAutoConfiguration
public class MockApplication {
}
