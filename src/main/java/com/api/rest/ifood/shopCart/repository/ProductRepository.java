package com.api.rest.ifood.shopCart.repository;


import com.api.rest.ifood.shopCart.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
