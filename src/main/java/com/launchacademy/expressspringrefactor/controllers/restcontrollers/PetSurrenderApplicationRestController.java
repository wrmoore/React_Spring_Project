package com.launchacademy.expressspringrefactor.controllers.restcontrollers;

import com.launchacademy.expressspringrefactor.models.PetSurrenderApplication;
import com.launchacademy.expressspringrefactor.models.PetType;
import com.launchacademy.expressspringrefactor.repositories.AdoptablePetsRepository;
import com.launchacademy.expressspringrefactor.repositories.PetSurrenderApplicationsRepository;
import com.launchacademy.expressspringrefactor.repositories.PetTypesRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class PetSurrenderApplicationRestController {

  private PetSurrenderApplicationsRepository petSurrenderApplicationsRepository;
  private PetTypesRepository petTypesRepository;

  @Autowired
  public PetSurrenderApplicationRestController(
      PetSurrenderApplicationsRepository petSurrenderApplicationsRepository,
      PetTypesRepository petTypesRepository) {

    this.petSurrenderApplicationsRepository = petSurrenderApplicationsRepository;
    this.petTypesRepository = petTypesRepository;
  }

  @PostMapping("/adoptions/new/{type_id}")
  public PetSurrenderApplication newSurrenderApplication(
      @RequestBody PetSurrenderApplication petSurrenderApplication, @PathVariable Integer type_id) {
    Optional<PetType> petType = petTypesRepository.findById(type_id);
    petSurrenderApplication.setPetType(petType.get());
    petSurrenderApplication.setApplicationStatus(false);
    return petSurrenderApplicationsRepository.save(petSurrenderApplication);
  }
}
