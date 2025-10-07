package com.example.name;

import brave.sampler.Sampler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class NameApplication {
  public static void main(String[] args) {
    SpringApplication.run(NameApplication.class, args);
  }

  @Bean
  public Sampler getSampler() {
    return Sampler.ALWAYS_SAMPLE;
  }
}
