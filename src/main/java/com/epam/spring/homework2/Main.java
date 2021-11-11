package com.epam.spring.homework2;

import com.epam.spring.homework2.config.FirstConfig;
import java.util.stream.Stream;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

  public static void main(String[] args) {
    ApplicationContext context = new AnnotationConfigApplicationContext(FirstConfig.class);

    Stream.of(context.getBeanDefinitionNames()).forEach(System.out::println);
    
    for (String beanName : context.getBeanDefinitionNames()) {
      System.out.println(context.getBean(beanName));
    }


  }
}
