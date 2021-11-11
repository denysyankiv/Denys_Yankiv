package com.epam.spring.homework2.beans;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class BeanA implements BeanWithNameAndValue, InitializingBean, DisposableBean {

  private String name;
  private int value;

  public BeanA() {
    System.out.println(this.getClass().getSimpleName());
  }

  @Override
  public void afterPropertiesSet() throws Exception {
    System.out.println(this.getClass().getSimpleName() + " afterPropertiesSet");
  }

  @Override
  public void destroy() throws Exception {
    System.out.println(this.getClass().getSimpleName() + " destroy");
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public int getValue() {
    return value;
  }

  @Override
  public String toString() {
    return "BeanA{" +
        "name='" + name + '\'' +
        ", value=" + value +
        '}';
  }


}
