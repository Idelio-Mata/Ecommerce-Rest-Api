package com.api.rest.ifood.shopCart.repository;

import com.api.rest.ifood.shopCart.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
}
