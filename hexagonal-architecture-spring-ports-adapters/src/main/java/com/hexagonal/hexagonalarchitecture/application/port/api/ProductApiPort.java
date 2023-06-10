package com.hexagonal.hexagonalarchitecture.application.port.api;

import com.hexagonal.hexagonalarchitecture.adapter.http.api.model.ProductDTO;
import com.hexagonal.hexagonalarchitecture.domain.Product;
import com.hexagonal.hexagonalarchitecture.infraestructure.annotation.Port;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@Port
public interface ProductApiPort {
    Optional<Product> getProductById(Long id);
    Product saveProduct(ProductDTO product);
    List<Product> getAllProducts();
    Product updateProduct(Product product);
    String deleteProduct(Long id);
}
