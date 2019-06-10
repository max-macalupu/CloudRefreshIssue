package com.springcloud.refresh.issue;

import javax.sql.DataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSourceConfig {

  @Bean
  @ConfigurationProperties(prefix = "web.datasource")
  public DataSource getDataSource() {
    return DataSourceBuilder.create().build();
  }
}