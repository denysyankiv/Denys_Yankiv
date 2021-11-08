package com.epam.spring.homework1;

import com.epam.spring.homework1.config.BeansConfig;
import com.epam.spring.homework1.pet.Cheetah;
import com.epam.spring.homework1.pet.Pet;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

  public static void main(String[] args) {
    // Part 1 - 5
    ApplicationContext context = new AnnotationConfigApplicationContext(BeansConfig.class);
    // Part 6 - 10
    Pet pet = context.getBean(Pet.class);
    pet.printPets();

    System.out.println("Get bean by class name " + context.getBean(Cheetah.class));
    System.out.println("Get bean by bean name " + context.getBean("cheetah"));
  }
}
