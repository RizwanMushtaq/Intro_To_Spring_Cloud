package com.example.web;

import java.net.http.HttpRequest;
import java.util.logging.Logger;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.RequestContextUtils;

@RestController
public class WebController {
  private static final Logger LOG = Logger.getLogger(WebController.class.getName());

  @Autowired
  private NameService nameService;
  @Autowired
  private GreetingService greetingService;

  @GetMapping("/")
  public String getGreeting(HttpServletRequest request) {
    String locale =
        RequestContextUtils.getLocaleResolver(request).resolveLocale(request).toLanguageTag();
    String greeting =
        new StringBuilder().append(greetingService.getGreeting(locale)).append(" ").append(nameService.getName()).toString();

    LOG.info("Greeting: " + greeting);
    LOG.info("Locale: " + locale);

    return greeting;
  }
}
