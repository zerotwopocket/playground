package com.zerotwopocket.product.web;

import java.math.BigDecimal;
import java.util.List;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ProductDto {
  private Long id;
  private String productName;
  private String productCode;
  private String category;
  private List<String> tags;
  private String releaseDate;
  private String description;
  private BigDecimal price;
  private Double rating;
  private Integer quantity;
  private List<String> images;
}
