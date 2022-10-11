package com.api.rest.ifood.shopCart.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@AllArgsConstructor // This anotation is for contructors
@Builder  //Anotation to create lazy objects
@Data  // This anotation is for Getters & Setters
@Entity  // This anotation convert class name to Table on database
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private double unitaryValue;

    @Builder.Default
    private Boolean available = true;

    @ManyToOne
    @JsonIgnore
    private Restaurant restaurant;


}
