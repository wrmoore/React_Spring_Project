package com.launchacademy.expressspringrefactor.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.Id;

@Entity
@Table(name = "adoptable_pets")
@Getter
@Setter
@NoArgsConstructor
public class AdoptablePet {

  @Id
  @SequenceGenerator(name = "adoptable_pet_generator", sequenceName = "adoptable_pets_id_seq", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "adoptable_pet_generator")
  @Column(name = "id", nullable = false, unique = true)
  private Integer id;

  @NotNull
  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "age", nullable = false)
  private Integer age;

  @Column(name = "vaccination_status", nullable = false)
  private Boolean vaccinationStatus;

  @Column(name = "adoption_story", nullable = false)
  private String adoptionStory;

  @Column(name = "adoption_status", nullable = false)
  private String adoptionStatus;

  @Column(name= "img_url", nullable = false)
  private String imageUrl;

  @ManyToOne
  @JoinColumn(name = "type_id", nullable = false)
  @JsonIgnoreProperties("adoptable_pets")
  private PetType petType;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public Boolean getVaccinationStatus() {
    return vaccinationStatus;
  }

  public void setVaccinationStatus(Boolean vaccinationStatus) {
    this.vaccinationStatus = vaccinationStatus;
  }

  public String getAdoptionStory() {
    return adoptionStory;
  }

  public void setAdoptionStory(String adoptionStory) {
    this.adoptionStory = adoptionStory;
  }

  public String getAdoptionStatus() {
    return adoptionStatus;
  }

  public void setAdoptionStatus(String adoptionStatus) {
    this.adoptionStatus = adoptionStatus;
  }

  public PetType getPetType() {
    return petType;
  }

  public void setPetType(PetType petType) {
    this.petType = petType;
  }

  public String getImageUrl() {
    return imageUrl;
  }

  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }
}





