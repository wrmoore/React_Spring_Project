package com.launchacademy.expressspringrefactor.controllers.restcontrollers;

import com.launchacademy.expressspringrefactor.models.PetType;
import com.launchacademy.expressspringrefactor.repositories.PetTypesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class PetTypesRestController {
  private final PetTypesRepository petTypesRepository;

  @Autowired
  private PetTypesRestController(PetTypesRepository petTypesRepository) {
    this.petTypesRepository = petTypesRepository;
  }

  @GetMapping("/pet_types")
  public Iterable<PetType> getPetTypes() {
    return petTypesRepository.findAll();
  }
}

