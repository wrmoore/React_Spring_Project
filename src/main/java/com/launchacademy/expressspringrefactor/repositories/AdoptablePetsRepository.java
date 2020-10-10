package com.launchacademy.expressspringrefactor.repositories;

import com.launchacademy.expressspringrefactor.models.AdoptablePet;
import com.launchacademy.expressspringrefactor.models.PetType;
import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdoptablePetsRepository extends CrudRepository<AdoptablePet, Integer> {

  List<AdoptablePet> findAll();

  Iterable<AdoptablePet> findByPetTypeType(String petType);

  Optional<AdoptablePet> findByName(String name);

  Optional<AdoptablePet> findByIdAndPetType(Integer id, Optional<PetType> type);
}