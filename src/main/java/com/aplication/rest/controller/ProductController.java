package com.aplication.rest.controller;

import com.aplication.rest.controller.dto.ProductDTO;
import com.aplication.rest.entities.Product;
import com.aplication.rest.repository.ProductRepository;
import com.aplication.rest.service.IProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    private ProductRepository productRepository;
    private IProductService productService;

    public ProductController(ProductRepository productRepository, IProductService productService) {
        this.productRepository = productRepository;
        this.productService = productService;
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Optional<Product> productOptional = productService.findById(id);

        if (productOptional.isPresent()) {
            Product product = productOptional.get();

            ProductDTO productDTO = ProductDTO.builder()
                    .id(product.getId())
                    .name(product.getName())
                    .price(product.getPrice())
                    .maker(product.getMaker())
                    .build();
            return ResponseEntity.ok(productDTO);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll() {
        List<ProductDTO> productDTOList = productService.findAll()
                .stream()
                .map(product -> ProductDTO.builder()
                        .id(product.getId())
                        .name(product.getName())
                        .price(product.getPrice())
                        .maker(product.getMaker())
                        .build())
                .toList();
        return ResponseEntity.ok(productDTOList);
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody ProductDTO productDTO) throws URISyntaxException {
        if (productDTO.getName().isBlank() || productDTO.getPrice() == null || productDTO.getMaker() == null) {
            return ResponseEntity.badRequest().build();
        }

        Product product = Product.builder()
                .name(productDTO.getName())
                .price(productDTO.getPrice())
                .maker(productDTO.getMaker())
                .build();

        this.productService.save(product);

        return ResponseEntity.created(new URI("/api/product/save")).build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable Long id, @RequestBody ProductDTO productDTO) {
        Optional<Product> productOptional = productService.findById(id);

        if (productOptional.isPresent()) {
            Product product = productOptional.get();
            product.setName(productDTO.getName());
            product.setPrice(productDTO.getPrice());
            product.setMaker(productDTO.getMaker());
            this.productService.save(product);
            return ResponseEntity.ok("Product updated");
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        if (id != null) {
            this.productService.deleteById(id);
            return ResponseEntity.ok("Product deleted");
        }
        return ResponseEntity.badRequest().build();
    }
}
