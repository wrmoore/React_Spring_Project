package com.launchacademy.expressspringrefactor.repositories;

import com.launchacademy.expressspringrefactor.models.PetType;
import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetTypesRepository extends CrudRepository<PetType, Integer> {

  List<PetType> findAll();

  Optional<PetType> findByType(String petType);
}