package com.hexagonal.hexagonalarchitecture.application.service;

import com.hexagonal.hexagonalarchitecture.adapter.persistence.model.CategoryEntity;
import com.hexagonal.hexagonalarchitecture.adapter.persistence.model.ProductEntity;
import com.hexagonal.hexagonalarchitecture.adapter.persistence.repository.CategoryRepository;
import com.hexagonal.hexagonalarchitecture.adapter.persistence.repository.ProductRepository;
import com.hexagonal.hexagonalarchitecture.application.usecase.ProductUseCasePort;
import com.hexagonal.hexagonalarchitecture.domain.Category;
import com.hexagonal.hexagonalarchitecture.domain.Product;
import com.hexagonal.hexagonalarchitecture.infraestructure.config.MapStructClassMapper;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.Optional;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

@Service
@AllArgsConstructor
@Transactional
public class ProductServiceImpl implements ProductUseCasePort {

    private CategoryRepository categoryRepository;
    private ProductRepository productRepository;
    private MapStructClassMapper mapper;
    @Override
    public Optional<Product> getProductById(Long id) {
        return Optional.ofNullable(mapper.mapperClass(productRepository.getById(id), Product.class));
    }

    @Override
    public Product saveProduct(Product product) {
        ProductEntity productEntity = mapper.mapperClass(product,ProductEntity.class);
        return mapper.mapperClass(productRepository.save(productEntity),Product.class);
    }

    @Override
    public List<Product> getAllProducts() {
        return null;
    }

    @Override
    public Product updateProduct(Product product) {
        return null;
    }

    @Override
    public String deleteProduct(Long id) {
        return null;
    }

}
