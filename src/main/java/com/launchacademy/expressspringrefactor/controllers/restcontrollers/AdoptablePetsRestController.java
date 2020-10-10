package com.launchacademy.expressspringrefactor.controllers.restcontrollers;

import com.launchacademy.expressspringrefactor.models.AdoptablePet;
import com.launchacademy.expressspringrefactor.models.PetType;
import com.launchacademy.expressspringrefactor.repositories.AdoptablePetsRepository;
import com.launchacademy.expressspringrefactor.repositories.PetTypesRepository;
import java.util.Optional;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class AdoptablePetsRestController {
  private AdoptablePetsRepository adoptablePetsRepository;
  private PetTypesRepository petTypesRepository;

  @Autowired
  public void AdoptablePetsRepository(AdoptablePetsRepository adoptablePetsRepository, PetTypesRepository petTypesRepository){
    this.adoptablePetsRepository = adoptablePetsRepository;
    this.petTypesRepository = petTypesRepository;
  }

  @GetMapping("/adoptable_pets")
  public Iterable<AdoptablePet> getAdoptablePets(){
    return  adoptablePetsRepository.findAll();
  }

  @NoArgsConstructor
  private class AdoptablePetNotFoundException extends RuntimeException {};

  @ControllerAdvice
  private class AdoptablePetNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(AdoptablePetNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String adoptablePetNotFoundHandler(AdoptablePetNotFoundException ex) {
      return ex.getMessage(); }
  }

  @GetMapping("/pets/{petType}/{id}")
  public AdoptablePet getAdoptablePets(@PathVariable Integer id, @PathVariable String petType){
    Optional<PetType> type = petTypesRepository.findByType(petType);
    return  adoptablePetsRepository.findByIdAndPetType(id, type).orElseThrow(AdoptablePetNotFoundException::new);
  }

  @GetMapping("/pets/{petType}")
  public Iterable<AdoptablePet> getPetsByType(@PathVariable String petType) {
    return adoptablePetsRepository.findByPetTypeType(petType);
  }
}

