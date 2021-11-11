package com.epam.spring.homework2.beans;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class BeanE implements BeanWithNameAndValue {
  private String name;
  private int value;
  public BeanE() {
    System.out.println(this.getClass().getSimpleName());
  }

  @PostConstruct
  public void postConstruct(){
    System.out.println(this.getClass().getSimpleName() + " postConstruct");
  }

  @PreDestroy
  public void preDestroy(){
    System.out.println(this.getClass().getSimpleName() + " preDestroy");
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
    return "BeanE{" +
        "name='" + name + '\'' +
        ", value=" + value +
        '}';
  }
}
