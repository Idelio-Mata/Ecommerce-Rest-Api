package com.api.rest.ifood.shopCart.resource;

import com.api.rest.ifood.shopCart.model.Cart;
import com.api.rest.ifood.shopCart.model.Item;
import com.api.rest.ifood.shopCart.resource.dto.ItemDto;
import com.api.rest.ifood.shopCart.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


/**
 * THis class contain the endPoints *
 **/
@RestController
@RequestMapping("/ifood/cart")  //Describe the url refer to Cart
@RequiredArgsConstructor
public class CartResource {
    private final CartService cartService;

    /**
     * Here I create the end points to the methods that must be public, now they are comming
     * from Service/cartService
     **/

    @PostMapping   //Method add items to db.
    public Item addItemToCart(@RequestBody ItemDto itemDto) {
        return cartService.addItemToCart(itemDto);
    }

    @GetMapping("/{id}")     //Method to get data from db.
    public Cart showCart(@PathVariable("id") Long id) {
        return cartService.showCart(id);
    }

    @PatchMapping("/closeCart/{cartId}") //Method to close the buy
    public Cart closeCart(@PathVariable("cartId") Long cartId,
                          @RequestParam("paymentForm") int paymentForm) {
        return cartService.closeCart(cartId, paymentForm);
    }

}
