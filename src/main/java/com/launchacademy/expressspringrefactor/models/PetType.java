package com.launchacademy.expressspringrefactor.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.Id;

@Entity
@Table(name="pet_types")
@Getter
@Setter
@NoArgsConstructor
public class PetType {
  @Id
  @SequenceGenerator(name="pet_types_generator", sequenceName="pet_types_id_seq", allocationSize = 1)
  @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="pet_types_generator")
  @Column(name="id", nullable=false, unique=true)
  private Integer id;

  @Column(name="type")
  private String type;

  @Column(name="description")
  private String description;

  @Column(name = "image_url", nullable = false)
  private String imageUrl;

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

    public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getImageUrl() {
    return imageUrl;
  }
  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }

}