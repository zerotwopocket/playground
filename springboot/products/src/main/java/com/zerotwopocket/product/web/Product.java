package com.zerotwopocket.product.web;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {
  @Id
//  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String productName;
  private String productCode;
  private String category;
  private String tags;
  private LocalDateTime releaseDate;
  private String description;
  private Double starRating;

  private String imageUrl;
  private BigDecimal price;
  @Column(length = 1000)
  private String imageList;
  private Integer quantity;
}
