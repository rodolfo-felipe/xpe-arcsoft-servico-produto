package com.xpe.arcsoft.service.product.service.impl;

import com.xpe.arcsoft.service.product.model.Product;
import com.xpe.arcsoft.service.product.model.vo.ProductBasicVo;
import com.xpe.arcsoft.service.product.model.vo.ProductVo;
import com.xpe.arcsoft.service.product.repository.ProductRepository;
import com.xpe.arcsoft.service.product.service.ProductService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;

    public List<ProductVo> findAllProducts() {
        return repository.findAllProducts();
    }

    public Product findById(Long id) {
        return repository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Product not found"));
    }

    public Product create(ProductBasicVo productBasicVo) {
      Product product = Product.builder().name(productBasicVo.getName()).build();
      return repository.save(product);
    }

    public Product update(Long id, ProductBasicVo productBasicVo) {
      Product product = Product.builder().id(id).name(productBasicVo.getName()).build();
      return repository.save(product);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}