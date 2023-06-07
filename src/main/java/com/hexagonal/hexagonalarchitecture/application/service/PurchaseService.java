package com.hexagonal.hexagonalarchitecture.application.service;

import com.hexagonal.hexagonalarchitecture.adapter.http.api.model.PurchaseDTO;
import com.hexagonal.hexagonalarchitecture.adapter.persistence.model.ProductEntity;
import com.hexagonal.hexagonalarchitecture.adapter.persistence.model.PurchaseDetailEntity;
import com.hexagonal.hexagonalarchitecture.adapter.persistence.model.PurchaseEntity;
import com.hexagonal.hexagonalarchitecture.adapter.persistence.model.UserEntity;
import com.hexagonal.hexagonalarchitecture.adapter.persistence.repository.ProductRepository;
import com.hexagonal.hexagonalarchitecture.adapter.persistence.repository.PurchaseDetailRepository;
import com.hexagonal.hexagonalarchitecture.adapter.persistence.repository.PurchaseRepository;
import com.hexagonal.hexagonalarchitecture.adapter.persistence.repository.UserRepository;
import com.hexagonal.hexagonalarchitecture.domain.Product;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class PurchaseService {

    @Autowired
    private PurchaseRepository purchaseRepository;
    @Autowired
    private PurchaseDetailRepository purchaseDetailRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private UserRepository userRepository;
    public String createPurchase(PurchaseDTO purchaseDTO){
        PurchaseEntity savedPurchase = new PurchaseEntity();
        UserEntity user = userRepository.findById(purchaseDTO.getClientId()).orElseThrow(()->new RuntimeException("User not found"));

        List<ProductEntity>products = purchaseDTO.getProductId()
                .stream().map(product -> productRepository.findById(product)
                        .orElseThrow(()-> new RuntimeException("Product Not Found"))
                ).toList();
        savedPurchase.setAmount(calculateAmount(products));
        savedPurchase.setUser(user);
        purchaseRepository.save(savedPurchase);
        for (int i = 0; i < products.size(); i++) {
            PurchaseDetailEntity purchaseDetail = PurchaseDetailEntity.builder().purchase(savedPurchase).amount(products.get(i).getPrice()).product(products.get(i)).build();
            purchaseDetailRepository.save(purchaseDetail);
        }
        return "Purchase Created Successfully";
    }

    private Integer calculateAmount(List<ProductEntity>products){
        Integer amount = products.stream()
                .mapToInt(product-> product.getPrice())
                .sum();
        return amount;
    }
}
