package com.hexagonal.hexagonalarchitecture.adapter.http.api.controller;

import com.hexagonal.hexagonalarchitecture.adapter.http.api.adapter.ProductAdapter;
import com.hexagonal.hexagonalarchitecture.adapter.http.api.adapter.UserAdapter;
import com.hexagonal.hexagonalarchitecture.adapter.http.api.model.ProductDTO;
import com.hexagonal.hexagonalarchitecture.adapter.http.api.model.UserDTO;
import com.hexagonal.hexagonalarchitecture.domain.Product;
import com.hexagonal.hexagonalarchitecture.domain.User;
import com.hexagonal.hexagonalarchitecture.infraestructure.config.MapStructClassMapper;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/product")
@AllArgsConstructor
public class ProductController {

    private ProductAdapter productAdapter;
    private MapStructClassMapper mapper;

    @GetMapping
    public ResponseEntity<List<ProductDTO>> getAllProducts(){
        return ResponseEntity.ok(productAdapter.getAllProducts().stream()
                .map(product -> mapper.mapperClass(product, ProductDTO.class)).toList());

    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<ProductDTO>>getProduct(@PathVariable("id")Long id){
        return ResponseEntity.ok(Optional.ofNullable(mapper
                .mapperClass(productAdapter.getProductById(id), ProductDTO.class)));
    }

    @PostMapping
    public ResponseEntity<ProductDTO>saveProduct(@Valid @RequestBody ProductDTO productDTO){
        Product product = mapper.mapperClass(productDTO,Product.class);
        return ResponseEntity.ok(mapper.mapperClass(productAdapter.saveProduct(product),ProductDTO.class));
    }

    @PutMapping
    public ResponseEntity<ProductDTO>updateProduct(@RequestBody ProductDTO productDTO){
        Product product = mapper.mapperClass(productDTO,Product.class);
        return ResponseEntity.ok(mapper.
                mapperClass(productAdapter.updateProduct(product),ProductDTO.class));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String>deleteProduct(@PathVariable("id")Long id){
        return ResponseEntity.ok(productAdapter.deleteProduct(id));
    }
}
