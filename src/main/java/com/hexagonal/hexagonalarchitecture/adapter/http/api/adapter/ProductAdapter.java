package com.hexagonal.hexagonalarchitecture.adapter.http.api.adapter;

import com.hexagonal.hexagonalarchitecture.adapter.http.api.model.ProductDTO;
import com.hexagonal.hexagonalarchitecture.adapter.persistence.model.CategoryEntity;
import com.hexagonal.hexagonalarchitecture.adapter.persistence.repository.CategoryRepository;
import com.hexagonal.hexagonalarchitecture.application.port.api.ProductApiPort;
import com.hexagonal.hexagonalarchitecture.application.service.ProductServiceImpl;
import com.hexagonal.hexagonalarchitecture.domain.Category;
import com.hexagonal.hexagonalarchitecture.domain.Product;
import com.hexagonal.hexagonalarchitecture.infraestructure.annotation.Adapter;
import com.hexagonal.hexagonalarchitecture.infraestructure.config.MapStructClassMapper;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.Optional;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

@Adapter
@AllArgsConstructor
public class ProductAdapter implements ProductApiPort {
    private MapStructClassMapper mapper;
    private ProductServiceImpl productService;
    private CategoryRepository categoryRepository;
    @Override
    public Optional<Product> getProductById(Long id) {
        return productService.getProductById(id);
    }

    @Override
    @SneakyThrows
    public Product saveProduct(ProductDTO productDto) {
        Category category = mapper.mapperClass(categoryRepository.findById(productDto.getCategory()),Category.class);
        System.out.println("BYTES"+productDto.getImage().getBytes());
        Product product = Product.builder().nameProduct(productDto.getNameProduct())
                .category(category).image(compressImage(productDto.getImage().getBytes()))
                .price(productDto.getPrice()).build();
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


    public  byte[] compressImage(byte[] data) {
        Deflater deflater = new Deflater();
        deflater.setLevel(Deflater.BEST_COMPRESSION);
        deflater.setInput(data);
        deflater.finish();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] tmp = new byte[4*1024];
        while (!deflater.finished()) {
            int size = deflater.deflate(tmp);
            outputStream.write(tmp, 0, size);
        }
        try {
            outputStream.close();
        } catch (Exception ignored) {
        }
        return outputStream.toByteArray();
    }


    public  byte[] decompressImage(byte[] data) {
        Inflater inflater = new Inflater();
        inflater.setInput(data);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] tmp = new byte[4*1024];
        try {
            while (!inflater.finished()) {
                int count = inflater.inflate(tmp);
                outputStream.write(tmp, 0, count);
            }
            outputStream.close();
        } catch (Exception ignored) {
        }
        return outputStream.toByteArray();
    }
}
