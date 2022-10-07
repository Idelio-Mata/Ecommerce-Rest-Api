package com.api.rest.ifood.shopCart.model;

import com.api.rest.ifood.shopCart.enumeration.PaymentForm;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@AllArgsConstructor // This anotation is for contructors
@Builder
@Data  // This anotation is for Getters & Setters
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@NoArgsConstructor
public class Cart {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JsonIgnore
  private Client client;
  @OneToMany(cascade = CascadeType.ALL)
  private List<Item> itens;
  private Double totalValue;

  @Enumerated
  private PaymentForm PaymentForm;
  private boolean closed;


}
