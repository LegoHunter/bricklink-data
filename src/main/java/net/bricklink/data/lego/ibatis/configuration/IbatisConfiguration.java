package net.bricklink.data.lego.ibatis.configuration;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@MapperScan("net.bricklink.data.lego.ibatis.mapper")
@EnableTransactionManagement
public class IbatisConfiguration {
}
