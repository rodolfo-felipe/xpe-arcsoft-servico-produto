package com.xpe.arcsoft.service.product.repository;

import com.xpe.arcsoft.service.product.model.Product;
import com.xpe.arcsoft.service.product.model.vo.ProductVo;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductRepository extends JpaRepository<Product, Long> {

  @Query("SELECT new com.xpe.arcsoft.service.product.model.vo.ProductVo(p.id, p.name)"
      + " FROM Product p ")
  List<ProductVo> findAllProducts();

  @Query("SELECT new com.xpe.arcsoft.service.product.model.vo.ProductVo(p.id, p.name)"
      + " FROM Product p "
      + " WHERE UPPER(p.name) LIKE UPPER(CONCAT('%', :name, '%'))")
  List<ProductVo> findByName(@Param("name") String name);
}
