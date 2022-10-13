package com.api.rest.ifood.shopCart.service.Impl;

import com.api.rest.ifood.shopCart.enumeration.PaymentForm;
import com.api.rest.ifood.shopCart.model.Cart;
import com.api.rest.ifood.shopCart.model.Item;
import com.api.rest.ifood.shopCart.model.Restaurant;
import com.api.rest.ifood.shopCart.repository.CartRepository;
import com.api.rest.ifood.shopCart.repository.ItemRepository;
import com.api.rest.ifood.shopCart.repository.ProductRepository;
import com.api.rest.ifood.shopCart.resource.dto.ItemDto;
import com.api.rest.ifood.shopCart.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {
    private final CartRepository cartRepository;
    private final ProductRepository productRepository;
    private final ItemRepository itemRepository;

    @Override
    public Item addItemToCart(ItemDto itemDto) {
        Cart cart = showCart(itemDto.getIdCart());

        if (cart.isClosed()) {
            throw new RuntimeException("This Cart is Closed!");
        }

        Item itemToAddToCart = Item.builder()
                .quantity(itemDto.getQuantity())
                .cart(cart)
                .product(productRepository.findById(itemDto.getProductId()).orElseThrow(
                        () -> {
                            throw new RuntimeException("This Product does not exist!");
                        }
                ))
                .build();

        List<Item> itemsInCart = cart.getItems();
        if (itemsInCart.isEmpty()) {
            itemsInCart.add(itemToAddToCart);
        } else {
            Restaurant currentRestaurant = itemsInCart.get(0).getProduct().getRestaurant();
            Restaurant curretItemRestaurant = itemToAddToCart.getProduct().getRestaurant();

            if (currentRestaurant.equals(curretItemRestaurant)) {
                itemsInCart.add(itemToAddToCart);
            } else {
                throw new RuntimeException("Is not possible to add Products from diferent Restaurants. " +
                        "Close the Cart or Clear");
            }
        }
        cartRepository.save(cart);
        return itemRepository.save(itemToAddToCart);
    }

    @Override
    public Cart showCart(Long id) {
        return cartRepository.findById(id).orElseThrow(
                () -> {
                    throw new RuntimeException("This Cart does not exist!");
                }
        );
    }

    @Override
    public Cart closeCart(Long id, int paymentFormNumber) {
        Cart cart = showCart(id);

        if (cart.getItems().isEmpty()) {
            throw new RuntimeException("Include itens to Cart!");
        }
         /*if (paymentFormNumber ==o){
             cart.setPaymentForm(PaymentForm.MONEY);
         } else {
             cart.setPaymentForm(PaymentForm.PAYMENTMACHINE);
         }*/

        PaymentForm paymentForm = paymentFormNumber == 0 ? PaymentForm.MONEY : PaymentForm.PAYMENTMACHINE;

        cart.setPaymentForm(paymentForm);
        cart.setClosed(true);
        return cartRepository.save(cart);

    }
}
