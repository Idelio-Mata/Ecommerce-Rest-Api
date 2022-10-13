package com.api.rest.ifood.shopCart.service;

import com.api.rest.ifood.shopCart.model.Cart;
import com.api.rest.ifood.shopCart.model.Item;
import com.api.rest.ifood.shopCart.resource.dto.ItemDto;

public interface CartService {
    Item addItemToCart(ItemDto itemDto);

    Cart showCart(Long id);

    Cart closeCart(Long id, int paymentForm);

}
