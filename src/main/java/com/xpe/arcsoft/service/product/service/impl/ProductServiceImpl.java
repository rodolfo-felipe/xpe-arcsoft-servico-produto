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

  public Long countProducts() {
    return repository.count();
  }

  public ProductVo findById(Long id) {
    Product product = repository.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("Product not found"));
    return buildProductVo(product);
  }

  public List<ProductVo> findByName(String name) {
    return repository.findByName(name);
  }

  public ProductVo create(ProductBasicVo productBasicVo) {
    Product product = Product.builder().name(productBasicVo.getName()).build();
    return saveProduct(product);
  }

  public ProductVo update(Long id, ProductBasicVo productBasicVo) {
    Product product = Product.builder().id(id).name(productBasicVo.getName()).build();
    return saveProduct(product);
  }

  private ProductVo saveProduct(Product product) {
    product = repository.save(product);
    return buildProductVo(product);
  }


  private ProductVo buildProductVo(Product product) {
    return ProductVo.builder().id(product.getId()).name(product.getName()).build();
  }

  public void deleteById(Long id) {
    repository.deleteById(id);
  }
}