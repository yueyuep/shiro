package group.yueyue.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * Create by lp on 2020/6/24
 * jdbcTemplate的配置类
 */
@Configuration
public class JdbcConfig {
    @Bean
    public JdbcTemplate jdbcTemplate() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(driverManagerDataSource());
        return jdbcTemplate;
    }

    @Bean
    public DriverManagerDataSource driverManagerDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        /*数据库连接的一些驱动、url等信息*/
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/testdb?serverTimezone=GMT%2B8");
        dataSource.setUsername("root");
        dataSource.setPassword("password");
        return dataSource;
    }
}
