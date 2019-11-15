package cn.edu.scau.employee.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 主启动类
 *
 * @author chen.jiale
 * @date 2019/10/16 11:05
 */
@SpringBootApplication
@ComponentScan(basePackages = "cn.edu.scau.employee")
@MapperScan(basePackages = "cn.edu.scau.employee.dao.mapper")
@EnableSwagger2
public class EmployeeWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(EmployeeWebApplication.class,args);
    }
}
