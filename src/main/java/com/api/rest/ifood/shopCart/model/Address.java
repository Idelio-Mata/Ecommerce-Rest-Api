package com.api.rest.ifood.shopCart.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@AllArgsConstructor // This anotation is for contructors
@Builder  //Anotation to create lazy objects
@Data  // This anotation is for Getters & Setters
@Embeddable // This anotation avoid to create Table address on database
@NoArgsConstructor
public class Address {
  private String cep;
  private String complement;

}
