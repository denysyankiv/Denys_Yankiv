package com.epam.spring.homework2.beans;

import javax.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class BeanF implements BeanWithNameAndValue {
  private String name;
  private int value;
  public BeanF() {
    System.out.println(this.getClass().getSimpleName());
  }

  @PostConstruct
  public void postConstruct(){
    System.out.println(this.getClass().getSimpleName() + " postConstruct");
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
    return "BeanF{" +
        "name='" + name + '\'' +
        ", value=" + value +
        '}';
  }
}
