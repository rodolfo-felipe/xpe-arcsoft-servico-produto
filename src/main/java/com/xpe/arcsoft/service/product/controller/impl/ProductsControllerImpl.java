package com.xpe.arcsoft.service.product.controller.impl;

import com.xpe.arcsoft.service.product.controller.ProductsController;
import com.xpe.arcsoft.service.product.model.Product;
import com.xpe.arcsoft.service.product.model.vo.ProductBasicVo;
import com.xpe.arcsoft.service.product.model.vo.ProductVo;
import com.xpe.arcsoft.service.product.service.ProductService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductsControllerImpl implements ProductsController {

    private final ProductService service;

  @GetMapping
  public List<ProductVo> getAllProducts() {
    return service.findAllProducts();
  }

  @GetMapping("/{id}")
  public Product getProductById(@PathVariable Long id) {
    return service.findById(id);
  }

  @PostMapping
  public Product createProduct(@RequestBody ProductBasicVo product) {
    return service.create(product);
  }

  @PutMapping("/{id}")
  public Product updateProduct(@PathVariable Long id, @RequestBody ProductBasicVo product) {
    return service.update(id, product);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
    service.deleteById(id);
    return ResponseEntity.noContent().build();
  }
}