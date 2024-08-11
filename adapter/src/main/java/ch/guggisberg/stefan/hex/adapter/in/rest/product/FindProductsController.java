package ch.guggisberg.stefan.hex.adapter.in.rest.product;

import ch.guggisberg.stefan.hex.adapter.in.rest.common.ProductIdParser;
import ch.guggisberg.stefan.hex.model.product.Product;
import ch.guggisberg.stefan.hex.model.product.ProductId;
import ch.guggisberg.stefan.hex.spring.application.port.in.product.FindProductsUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class FindProductsController {

    private final FindProductsUseCase findProductsUseCase;

    @GetMapping("/id={id}")
    public ResponseEntity<ProductInListWebModel> findById(@PathVariable String id){
        ProductId productId = ProductIdParser.parseProductId(id);
        Product product = findProductsUseCase.findById(productId);
        return new ResponseEntity<>(ProductInListWebModel.fromDomainModel(product), HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<ProductInListWebModel>> findProducts(@RequestParam("query")  String query) {
        List<Product> products = findProductsUseCase.findByNameOrDescription(query);
        return new ResponseEntity<>(products.stream().map(ProductInListWebModel::fromDomainModel).toList(), HttpStatus.OK);
    }


}
