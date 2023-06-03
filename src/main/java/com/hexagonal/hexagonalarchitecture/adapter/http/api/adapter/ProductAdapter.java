package com.hexagonal.hexagonalarchitecture.adapter.http.api.adapter;

import com.hexagonal.hexagonalarchitecture.application.port.api.ProductApiPort;
import com.hexagonal.hexagonalarchitecture.application.service.ProductServiceImpl;
import com.hexagonal.hexagonalarchitecture.domain.Product;
import com.hexagonal.hexagonalarchitecture.infraestructure.annotation.Adapter;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

@Adapter
@AllArgsConstructor
public class ProductAdapter implements ProductApiPort {

    private ProductServiceImpl productService;
    @Override
    public Optional<Product> getProductById(Long id) {
        return productService.getProductById(id);
    }

    @Override
    public Product saveProduct(Product product) {
        return productService.saveProduct(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @Override
    public Product updateProduct(Product product) {
        return productService.updateProduct(product);
    }

    @Override
    public String deleteProduct(Long id) {
        return productService.deleteProduct(id);
    }
}
