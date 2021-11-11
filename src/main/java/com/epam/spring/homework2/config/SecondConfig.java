package com.epam.spring.homework2.config;

import com.epam.spring.homework2.beans.BeanB;
import com.epam.spring.homework2.beans.BeanC;
import com.epam.spring.homework2.beans.BeanD;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("application.properties")
@ComponentScan("com.epam.spring.homework2.beans")
public class SecondConfig {

  @Bean(initMethod = "initMethod", destroyMethod = "destroyMethod")
  @DependsOn("beanD")
  public BeanB beanB(@Value("${beanB.name}") String name, @Value("${beanB.value}") int value) {
    return new BeanB(name, value);
  }

  @Bean(initMethod = "initMethod", destroyMethod = "destroyMethod")
  @DependsOn("beanB")
  public BeanC beanC(@Value("${beanC.name}") String name, @Value("${beanC.value}") int value) {
    return new BeanC(name, value);
  }

  @Bean(initMethod = "initMethod", destroyMethod = "destroyMethod")
  public BeanD beanD(@Value("${beanD.name}") String name, @Value("${beanD.value}") int value) {
    return new BeanD(name, value);
  }
}
