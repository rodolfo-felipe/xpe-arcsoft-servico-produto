package com.xpe.arcsoft.service.product.controller;

import com.xpe.arcsoft.service.product.model.Product;
import com.xpe.arcsoft.service.product.model.vo.ProductBasicVo;
import com.xpe.arcsoft.service.product.model.vo.ProductVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name = "Products API", description = "Handles products")
@ApiResponse(responseCode = "500", description = "Unexpected error", content = @Content)
public interface ProductsController {

  @Operation(
      description = "Retrieves all products",
      responses = {
          @ApiResponse(responseCode = "200", description = "Products successfully retrieved"),
      })
  List<ProductVo> getAllProducts();

  @Operation(
      description = "Retrieves all products",
      responses = {
          @ApiResponse(responseCode = "200", description = "Products successfully retrieved"),
      })
  Product getProductById(@Parameter(description = "Product id") Long id);

  @Operation(
      description = "Create product",
      responses = {
          @ApiResponse(responseCode = "200", description = "Product successfully created"),
      })
  Product createProduct(
      @Parameter(description = "Product data to be created") ProductBasicVo product) ;

  @Operation(
      description = "Update product by id",
      responses = {
          @ApiResponse(responseCode = "200", description = "Product successfully updated"),
      })
  Product updateProduct(
      @Parameter(description = "Product id") Long id,
      @Parameter(description = "Product data to be updated") ProductBasicVo product);

  @Operation(
      description = "Deletes product by id",
      responses = {
          @ApiResponse(responseCode = "204", description = "Product successfully deleted")
      })
  ResponseEntity<Void> deleteProduct(@Parameter(description = "Product id") Long id);
}
