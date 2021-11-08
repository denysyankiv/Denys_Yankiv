package com.epam.spring.homework1.pet;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Pet {

  @Autowired
  private List<Animal> animalList;

  public void printPets() {
    for (Animal animal : animalList) {
      System.out.println(animal);
    }
  }
}
