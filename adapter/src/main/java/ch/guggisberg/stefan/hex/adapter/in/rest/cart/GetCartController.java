package ch.guggisberg.stefan.hex.adapter.in.rest.cart;

import ch.guggisberg.stefan.hex.adapter.in.rest.common.CustomerIdParser;
import ch.guggisberg.stefan.hex.model.cart.Cart;
import ch.guggisberg.stefan.hex.model.customer.CustomerId;
import ch.guggisberg.stefan.hex.spring.application.port.in.cart.GetCartUseCase;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class GetCartController {
    private final GetCartUseCase getCartUseCase;


    @GetMapping("/{customerId}")
    public ResponseEntity<CartWebModel> getCart(@PathParam("customerId") String customerIdString) {
        CustomerId customerId = CustomerIdParser.parseCustomerId(customerIdString);
        Cart cart = getCartUseCase.getCart(customerId);
        return new ResponseEntity<>(CartWebModel.fromDomainModel(cart), HttpStatus.OK);
    }
}
