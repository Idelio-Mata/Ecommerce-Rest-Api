package com.api.rest.ifood.shopCart.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@AllArgsConstructor // This anotation is for contructors
@Builder  //Anotation to create lazy objects
@Data  // This anotation is for Getters & Setters
@Entity  // This anotation convert class name to Table on database
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@NoArgsConstructor
public class Restaurant {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String name;
  @OneToMany(cascade = CascadeType.ALL)
  private List<Product> menu;

  @Embedded
  private Residence residence;

}
