package com.launchacademy.expressspringrefactor.seeders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MainSeeder implements CommandLineRunner {
  @Autowired AdoptablePetsSeeder adoptablePetsSeeder;
  @Autowired PetTypesSeeder petTypesSeeder;

  @Override
  public void run(String... args) throws Exception {
    petTypesSeeder.seed();
    adoptablePetsSeeder.seed();
  }
}

