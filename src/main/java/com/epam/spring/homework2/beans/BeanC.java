package com.epam.spring.homework2.beans;


import org.springframework.stereotype.Component;

@Component
public class BeanC implements BeanWithNameAndValue {

  private String name;
  private int value;

  public BeanC() {
    System.out.println(this.getClass().getSimpleName());
  }

  public BeanC(String name, int value) {
    this.name = name;
    this.value = value;
  }

  public void initMethod() {
    System.out.println(this.getClass().getSimpleName() + " initMethod");
  }

  public void destroyMethod() {
    System.out.println(this.getClass().getSimpleName() + " destroyMethod");
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
    return "BeanC{" +
        "name='" + name + '\'' +
        ", value=" + value +
        '}';
  }
}
