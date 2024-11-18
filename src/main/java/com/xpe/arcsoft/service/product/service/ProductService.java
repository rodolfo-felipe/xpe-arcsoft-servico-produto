package com.xpe.arcsoft.service.product.service;

import com.xpe.arcsoft.service.product.model.Product;
import com.xpe.arcsoft.service.product.model.vo.ProductBasicVo;
import com.xpe.arcsoft.service.product.model.vo.ProductVo;
import java.util.List;

public interface ProductService {

  public List<ProductVo> findAllProducts();

  public Product findById(Long id);

  public Product create(ProductBasicVo productBasicVo);

  public Product update(Long id, ProductBasicVo productBasicVo);

  public void deleteById(Long id);

}
