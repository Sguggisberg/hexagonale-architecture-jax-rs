package ch.guggisberg.stefan.hex.adapter.in.rest.cart;

import ch.guggisberg.stefan.hex.adapter.in.rest.common.CustomerIdParser;
import ch.guggisberg.stefan.hex.model.customer.CustomerId;
import ch.guggisberg.stefan.hex.spring.application.port.in.cart.EmptyCartUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class EmptyCartController {
    private final EmptyCartUseCase emptyCartUseCase;


    @DeleteMapping("/{customerId}")
    public ResponseEntity<Void> deleteCart(@PathVariable("customerId") final String customerIdString) {
        CustomerId customerId = CustomerIdParser.parseCustomerId(customerIdString);
        emptyCartUseCase.emptyCart(customerId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
