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
import com.hexagonal.hexagonalarchitecture.application.usecase.PurchaseUseCasePort;
import com.hexagonal.hexagonalarchitecture.domain.Product;
import com.hexagonal.hexagonalarchitecture.domain.Purchase;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class PurchaseService implements PurchaseUseCasePort {

    private PurchaseRepository purchaseRepository;
    private PurchaseDetailRepository purchaseDetailRepository;
    private ProductRepository productRepository;
    private UserRepository userRepository;
    @Override
    public String createPurchase(Purchase purchase){
        PurchaseEntity savedPurchase = new PurchaseEntity();
        UserEntity user = userRepository.findById(purchase.getClientId()).orElseThrow(()->new RuntimeException("User not found"));

        List<ProductEntity>products = purchase.getProductId()
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
