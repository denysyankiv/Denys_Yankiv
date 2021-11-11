package com.epam.spring.homework2.beans.process;

import com.epam.spring.homework2.beans.BeanWithNameAndValue;
import org.springframework.beans.factory.config.BeanPostProcessor;


public class MyBeanPostProcessor implements BeanPostProcessor {

  @Override
  public Object postProcessBeforeInitialization(Object bean, String beanName) {
    System.out.println("In " + MyBeanPostProcessor.class.getSimpleName() + " BeforeInitialization"
        + " for " + beanName);
    return bean;
  }

  @Override
  public Object postProcessAfterInitialization(Object bean, String beanName) {
    System.out.println("In " + MyBeanPostProcessor.class.getSimpleName() + " AfterInitialization"
        + " for " + beanName);
    if (bean instanceof BeanWithNameAndValue) {
      BeanWithNameAndValue b = (BeanWithNameAndValue) bean;
      if (b.getName() == null || b.getValue() < 0) {
        System.out.println(beanName + " is not valid");
      } else {
        System.out.println(beanName + " is valid");
      }
    }
    return bean;
  }

}
