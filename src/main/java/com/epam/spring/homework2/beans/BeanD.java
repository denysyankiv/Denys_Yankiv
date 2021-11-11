package com.epam.spring.homework2.beans;


import org.springframework.stereotype.Component;

@Component
public class BeanD implements BeanWithNameAndValue {
  private String name;
  private int value;
  public BeanD() {
    System.out.println(this.getClass().getSimpleName());
  }

  public BeanD(String name, int value) {
    this.name = name;
    this.value = value;
  }

  public void initMethod(){
    System.out.println(this.getClass().getSimpleName() + " initMethod");
  }

  public void destroyMethod(){
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
    return "BeanD{" +
        "name='" + name + '\'' +
        ", value=" + value +
        '}';
  }
}
