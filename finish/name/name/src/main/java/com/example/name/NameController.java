package com.example.name;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NameController {
  private static final Logger LOG = Logger.getLogger(NameController.class.getName());

  @Autowired
  private NameProperties nameProperties;

  @GetMapping("/")
  public String getName() {
    LOG.info("Name: " + nameProperties.getName());
    return nameProperties.getName();
  }
}
