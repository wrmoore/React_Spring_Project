package com.launchacademy.expressspringrefactor.seeders;

import com.launchacademy.expressspringrefactor.models.AdoptablePet;
import com.launchacademy.expressspringrefactor.models.PetType;
import com.launchacademy.expressspringrefactor.repositories.AdoptablePetsRepository;
import com.launchacademy.expressspringrefactor.repositories.PetTypesRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class AdoptablePetsSeeder {
  private AdoptablePetsRepository adoptablePetsRepository;
  private PetTypesRepository petTypesRepository;

  @Autowired
  public AdoptablePetsSeeder(AdoptablePetsRepository adoptablePetsRepository, PetTypesRepository petTypesRepository) {
    this.adoptablePetsRepository = adoptablePetsRepository;
    this.petTypesRepository = petTypesRepository;
  }
  public void seed() {
    List<AdoptablePet> adoptablePets = new ArrayList<>();
    AdoptablePet petTypeOne = new AdoptablePet();
    petTypeOne.setName("Rick");
    petTypeOne.setImageUrl("https://www.indiewire.com/wp-content/uploads/2020/05/Rick-Morty-Rick-Five-Arms.png?resize=800,515");
    petTypeOne.setAge(68);
    petTypeOne.setVaccinationStatus(true);
    petTypeOne.setAdoptionStory("I was not adopted and then I became adopted");
    petTypeOne.setAdoptionStatus("Adoption Pending");
    Optional<PetType> petType = petTypesRepository.findByType("Cats");
    if (petType.isPresent()) petTypeOne.setPetType(petType.get());
    adoptablePets.add(petTypeOne);

    AdoptablePet petTypeTwo = new AdoptablePet();
    petTypeTwo.setName("Lady Amalthea");
    petTypeTwo.setImageUrl("https://assets.wired.com/photos/w_582/wp-content/uploads/2020/05/Cul-lastunicorn-W786CE.jpg");
    petTypeTwo.setAge(1000);
    petTypeTwo.setVaccinationStatus(true);
    petTypeTwo.setAdoptionStory("Why am I not called a unihorn?");
    petTypeTwo.setAdoptionStatus("Adoption Pending");
    Optional<PetType> petType2 = petTypesRepository.findByType("Other");
    if (petType2.isPresent()) petTypeTwo.setPetType(petType2.get());
    adoptablePets.add(petTypeTwo);

    AdoptablePet petTypeThree = new AdoptablePet();
    petTypeThree.setName("Snowball");
    petTypeThree.setImageUrl("https://heavy.com/wp-content/uploads/2020/04/snuffles-e1585726869132.jpg?quality=65&strip=all&w=780");
    petTypeThree.setAge(13);
    petTypeThree.setVaccinationStatus(false);
    petTypeThree.setAdoptionStory("I have not been adopted because I'm old?");
    petTypeThree.setAdoptionStatus("Adoption Pending");
    Optional<PetType> petType3 = petTypesRepository.findByType("Dogs");
    if (petType3.isPresent()) petTypeThree.setPetType(petType3.get());
    adoptablePets.add(petTypeThree);

    AdoptablePet petTypeFour = new AdoptablePet();
    petTypeFour.setName("Morty");
    petTypeFour.setImageUrl("https://vignette.wikia.nocookie.net/rickandmorty/images/4/41/Morty_Smith.jpg/revision/latest?cb=20200519152019");
    petTypeFour.setAge(15);
    petTypeFour.setVaccinationStatus(true);
    petTypeFour.setAdoptionStory("Gosh gee, I dunno, Rick...");
    petTypeFour.setAdoptionStatus("Adoption Pending");
    Optional<PetType> petType4 = petTypesRepository.findByType("Hamsters");
    if (petType4.isPresent()) petTypeFour.setPetType(petType4.get());
    adoptablePets.add(petTypeFour);

    for (AdoptablePet pet : adoptablePets) {
      if (!adoptablePetsRepository.findByName(pet.getName()).isPresent()) {
        adoptablePetsRepository.save(pet);
      }
    }
  }
}