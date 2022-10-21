package com.zerotwopocket.product.web;

import java.text.MessageFormat;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductService {

  private final ProductRepo productRepo;
  private final Random random = new Random();

  public ProductDto find(Long id) {

    int i = random.nextInt(10);

    if (i > 5) {
      try {
        Thread.sleep(2000);
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
        throw new ProductApiException(
            MessageFormat.format("Thread interrupted {0}", e.getMessage()));
      }
    }

    Product product =
        productRepo
            .findById(id)
            .orElseThrow(() -> new ProductApiException("Product" + id + "not found!"));

    return ProductDto.builder()
        .id(product.getId())
        .productName(product.getProductName())
        .productCode(product.getProductCode())
        .category(product.getCategory())
        .tags(
            product.getTags() != null
                ? Arrays.asList(product.getTags().split(","))
                : Arrays.asList())
        .releaseDate(product.getReleaseDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")))
        .description(product.getDescription())
        .price(product.getPrice())
        .quantity(product.getQuantity())
        .images(
            product.getImageList() != null
                ? Arrays.asList(product.getImageList().split(","))
                : Arrays.asList())
        .build();
  }

  public List<Product> find() {
    return productRepo.findAll();
  }

  public Product create(Product product) {
    return productRepo.save(product);
  }

  public Product update(Product product) {

    Product oldProduct =
        productRepo
            .findById(product.getId())
            .orElseThrow(
                () -> new ProductApiException("Product " + product.getId() + " cannot be found"));

    oldProduct.setProductName(product.getProductName());
    oldProduct.setCategory(product.getCategory());
    oldProduct.setDescription(product.getDescription());
    oldProduct.setTags(product.getTags());
    oldProduct.setImageUrl(product.getImageUrl());
    oldProduct.setReleaseDate(product.getReleaseDate());
    oldProduct.setStarRating(product.getStarRating());
    return productRepo.save(oldProduct);
  }
}
