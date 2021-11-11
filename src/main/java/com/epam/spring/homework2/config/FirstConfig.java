package com.epam.spring.homework2.config;

import com.epam.spring.homework2.beans.BeanA;
import com.epam.spring.homework2.beans.BeanE;
import com.epam.spring.homework2.beans.BeanF;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Lazy;

@Configuration
@Import(SecondConfig.class)
@ComponentScan
public class FirstConfig {

  @Bean
  public BeanA beanA() {
    return new BeanA();
  }

  @Bean
  public BeanE beanE() {
    return new BeanE();
  }

  @Bean
  @Lazy
  public BeanF beanF() {
    return new BeanF();
  }
}
