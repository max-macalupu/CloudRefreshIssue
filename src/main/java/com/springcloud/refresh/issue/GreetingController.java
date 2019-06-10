package com.springcloud.refresh.issue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GreetingController {

  @Autowired
  private GreetingDao greetingDao;

  @GetMapping("/greeting")
  @ResponseBody
  public Greeting sayHello() {
    Greeting greeting = greetingDao.getGreeting();
    return new Greeting(greeting.getId(), greeting.getContent());
  }
}