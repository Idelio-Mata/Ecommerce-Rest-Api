package com.api.rest.ifood.shopCart.repository;

import com.api.rest.ifood.shopCart.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

}
