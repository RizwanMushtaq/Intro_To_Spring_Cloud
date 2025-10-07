package com.example.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NameService {
  private static final String URL = "http://localhost:6060";
  private RestTemplate rest = AppConfig.restTemplate();

  public String getName() {
    return rest.getForObject(URL, String.class);
  }
}
