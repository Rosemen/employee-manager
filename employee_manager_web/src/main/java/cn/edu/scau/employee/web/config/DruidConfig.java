package cn.edu.scau.employee.web.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * druid数据源配置类
 *
 * @author chen.jiale
 * @date 2019/10/16 15:56
 */
@Configuration
public class DruidConfig {
    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DruidDataSource dataSource() {
        return new DruidDataSource();
    }
}
