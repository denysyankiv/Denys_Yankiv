package com.epam.spring.homework1.config;

import com.epam.spring.homework1.pet.Cheetah;
import com.epam.spring.homework1.pet.Spider;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Primary;

@Configuration
@ComponentScan(basePackages = {"com.epam.spring.homework1.pet"}, excludeFilters = {
    @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = Spider.class)})
public class PetConfig {

  @Bean
  @Primary
  public Cheetah getCheetah1(){
    return new Cheetah();
  }

  @Bean
  @Qualifier
  public Cheetah getCheetah2(){
    return new Cheetah();
  }
}
