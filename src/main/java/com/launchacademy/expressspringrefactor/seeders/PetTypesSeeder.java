package com.launchacademy.expressspringrefactor.seeders;

import com.launchacademy.expressspringrefactor.models.AdoptablePet;
import com.launchacademy.expressspringrefactor.models.PetType;
import com.launchacademy.expressspringrefactor.repositories.AdoptablePetsRepository;
import com.launchacademy.expressspringrefactor.repositories.PetTypesRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PetTypesSeeder {
  private PetTypesRepository petTypesRepository;
  private AdoptablePetsRepository adoptablePetsRepository;

  @Autowired
  public void setPetTypesRepository(PetTypesRepository petTypesRepository) {
    this.petTypesRepository = petTypesRepository;
  }

  @Autowired
  public void setAdoptablePetsRepository(AdoptablePetsRepository adoptablePetsRepository) {
    this.adoptablePetsRepository = adoptablePetsRepository;
  }

  public void seed() {
    List<AdoptablePet> adoptablePetList = new ArrayList();
    List<PetType> petTypeList = (List) petTypesRepository.findAll();
    if(petTypeList.size() == 0) {
      PetType petTypeOne = new PetType();
      petTypeOne.setType("Cats");
      petTypeOne.setImageUrl("https://icatcare.org/app/uploads/2018/07/Thinking-of-getting-a-cat.png");
      petTypeOne.setDescription("Fluffy and aloof, will eat you after three days if you die.");
      petTypesRepository.save(petTypeOne);

      PetType petTypeTwo = new PetType();
      petTypeTwo.setType("Dogs");
      petTypeTwo.setImageUrl("https://i.insider.com/5df126b679d7570ad2044f3e?width=900&format=jpeg&auto=webp");
      petTypeTwo.setDescription("Also fluffy, definitely not aloof, will wait longer than cats to eat you because they actually love you.");
      petTypesRepository.save(petTypeTwo);

      PetType petTypeThree = new PetType();
      petTypeThree.setType("Hamsters");
      petTypeThree.setImageUrl("https://upload.wikimedia.org/wikipedia/commons/thumb/d/de/Pearl_Winter_White_Russian_Dwarf_Hamster_-_Front.jpg/1920px-Pearl_Winter_White_Russian_Dwarf_Hamster_-_Front.jpg");
      petTypeThree.setDescription("Will eat their friends, wives, children.  Not really great people, cuz of the cannibalism.");
      petTypesRepository.save(petTypeThree);

      PetType petTypeFour = new PetType();
      petTypeFour.setType("Other");
      petTypeFour.setImageUrl("https://imaginarycreatureauthority.files.wordpress.com/2017/06/batman-unicorn.jpg");
      petTypeFour.setDescription("Anything that is not a cat, dog, or hamster.  Maybe it is mythical, maybe it is an illegal animal that you are not supposed to have.");
      petTypesRepository.save(petTypeFour);


    }

  }

}
