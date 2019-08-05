**Description:** This project allows to replicate the refresh endpoint issue that cause a **datasource shutdown** when is created through `DataSourceBuilder` class and `@ConfigurationProperties` annotation using springboot either 2.1.4.RELEASE or 2.1.5.RELEASE or 2.1.6.RELEASE. 


Run the project:
`mvn spring-boot:run`

In Order To Replicate The Datasource Shut Down, Do The Next Api Calls:
- `curl -X GET http://localhost:9000/greeting;`
- `curl -X POST http://localhost:9000/actuator/refresh;`
- `curl -X GET  http://localhost:9000/greeting;`


**Application properties**:
```
web.datasource.password=
web.datasource.userName=sa
web.datasource.jdbcUrl=jdbc:h2:mem:testdb
web.datasource.driverClassName=org.h2.Driver
web.datasource.type=HikariDataSource

server.port: 9000
management.server.port: 9000
management.server.address: 127.0.0.1
management.endpoints.web.exposure.include=*

spring.cloud.refresh.extra-refreshable=javax.sql.DataSource
```

**Bean creation:**
```
  @Bean
  @ConfigurationProperties(prefix = "web.datasource")
  public DataSource getDataSource() {
    return DataSourceBuilder.create().build();
  }
```

**Issue after refresh endpoint call:**
```
2019-06-10 11:27:48.407  INFO 18530 --- [nio-9000-exec-2] trationDelegate$BeanPostProcessorChecker : Bean 'org.springframework.cloud.autoconfigure.ConfigurationPropertiesRebinderAutoConfiguration' of type [org.springframework.cloud.autoconfigure.ConfigurationPropertiesRebinderAutoConfiguration$$EnhancerBySpringCGLIB$$b0795841] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)
2019-06-10 11:27:48.608  INFO 18530 --- [nio-9000-exec-2] o.s.boot.SpringApplication               : No active profile set, falling back to default profiles: default
2019-06-10 11:27:48.635  INFO 18530 --- [nio-9000-exec-2] o.s.boot.SpringApplication               : Started application in 0.449 seconds (JVM running for 17.377)
2019-06-10 11:27:49.087  INFO 18530 --- [nio-9000-exec-2] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Shutdown initiated...
2019-06-10 11:27:49.115  INFO 18530 --- [nio-9000-exec-2] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Shutdown completed.
```
