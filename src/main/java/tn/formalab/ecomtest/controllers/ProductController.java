package tn.formalab.ecomtest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.formalab.ecomtest.models.Product;
import tn.formalab.ecomtest.repositories.ProductRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("products")
public class ProductController {

    private ProductRepository productRepository;

    @Autowired
    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @PostMapping(path = "")
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        Product savedProduct = this.productRepository.save(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedProduct);
    }

    @GetMapping(path = "")
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = this.productRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(products);
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Integer id) {
        try {
            Product product = this.productRepository.findById(id).get();
            return ResponseEntity.status(HttpStatus.OK).body(product);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Product());
        }
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<Map<String ,String>> deleteCategory(@PathVariable Integer id) {
        this.productRepository.deleteById(id);

        HashMap<String,String> response = new HashMap<>();
        response.put("message","product deleted");

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PatchMapping(path = "")
    public ResponseEntity<Product> updateCategory(@RequestBody Product product) {
        Product updatedProduct = this.productRepository.save(product);
        return ResponseEntity.status(HttpStatus.OK).body(updatedProduct);
    }

}
