package com.springcloud.refresh.issue;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.sql.DataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GreetingDao {

  Logger logger = LoggerFactory.getLogger(GreetingDao.class);

  @Autowired
  private DataSource dataSource;

  public Greeting getGreeting() {

    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null;
    try {
      connection = dataSource.getConnection();
      statement = connection.createStatement();
      resultSet = statement.executeQuery("SELECT id, content FROM GREETING LIMIT 1");
      resultSet.next();

      Long id = resultSet.getLong(1);
      String value = resultSet.getString(2);

      return new Greeting(id, value);
    } catch (SQLException e) {
      e.printStackTrace();
      logger.error("Error getting information from database");
    } finally {
      try {
        resultSet.close();
        statement.close();
        connection.close();
      } catch (SQLException e) {
        logger.error("Error closing the DataSource objects.");
      }
    }
    return null;
  }
}