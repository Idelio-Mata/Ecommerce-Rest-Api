package com.api.rest.ifood.shopCart.repository;

import com.api.rest.ifood.shopCart.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
}
