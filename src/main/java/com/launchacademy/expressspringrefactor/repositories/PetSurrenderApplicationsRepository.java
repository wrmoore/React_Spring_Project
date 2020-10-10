package com.launchacademy.expressspringrefactor.repositories;

import com.launchacademy.expressspringrefactor.models.PetSurrenderApplication;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetSurrenderApplicationsRepository extends CrudRepository<PetSurrenderApplication, Integer> {


}