package com.xpe.arcsoft.service.product.service;

import com.xpe.arcsoft.service.product.model.vo.ProductBasicVo;
import com.xpe.arcsoft.service.product.model.vo.ProductVo;
import java.util.List;

public interface ProductService {

  List<ProductVo> findAllProducts();

  Long countProducts();

  ProductVo findById(Long id);

  List<ProductVo> findByName(String name);

  ProductVo create(ProductBasicVo productBasicVo);

  ProductVo update(Long id, ProductBasicVo productBasicVo);

  void deleteById(Long id);

}
