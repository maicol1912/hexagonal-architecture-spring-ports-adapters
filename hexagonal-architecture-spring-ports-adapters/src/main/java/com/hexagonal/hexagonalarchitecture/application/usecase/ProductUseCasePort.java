package com.hexagonal.hexagonalarchitecture.application.usecase;

import com.hexagonal.hexagonalarchitecture.domain.Product;
import com.hexagonal.hexagonalarchitecture.infraestructure.annotation.Port;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@Port
public interface ProductUseCasePort {
    Optional<Product> getProductById(Long id);
    Product saveProduct(Product product);
    List<Product> getAllProducts();
    Product updateProduct(Product product);
    String deleteProduct(Long id);
}
