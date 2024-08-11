package ch.guggisberg.stefan.hex.adapter.in.rest.cart;

import ch.guggisberg.stefan.hex.model.cart.NotEnoughItemsInStockException;
import ch.guggisberg.stefan.hex.model.customer.CustomerId;
import ch.guggisberg.stefan.hex.model.product.ProductId;
import ch.guggisberg.stefan.hex.spring.application.port.in.cart.AddToCartUseCase;
import ch.guggisberg.stefan.hex.spring.application.port.in.cart.ProductNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

import static ch.guggisberg.stefan.hex.adapter.in.rest.common.CustomerIdParser.parseCustomerId;
import static ch.guggisberg.stefan.hex.adapter.in.rest.common.ProductIdParser.parseProductId;

@RestController
@RequiredArgsConstructor
public class AddToCartController {
    private final AddToCartUseCase addToCartUseCase;

    @PostMapping("/{customerId}/line-items")
    public ResponseEntity<Void> addLineItem(
            @PathVariable("customerId") String customerIdString,
            @RequestParam("productId") String productIdString,
            @RequestParam("quantity") int quantity) {
        CustomerId customerId = parseCustomerId(customerIdString);
        ProductId productId = parseProductId(productIdString);
        try {
            addToCartUseCase.addToCart(customerId,productId,quantity);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (ProductNotFoundException e) {
            throw new RuntimeException(e);
        } catch (NotEnoughItemsInStockException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
