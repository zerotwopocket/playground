package com.zerotwopocket.product.web;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("product")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class ProductController {


  private final ProductService productService;

  @GetMapping("{id}")
  public ProductDto find(@PathVariable("id") Long id){
    return productService.find(id);
  }

  @GetMapping("")
  @CrossOrigin(origins = "*")
  public List<Product> find() throws InterruptedException {
    Thread.sleep(500);
    return productService.find();
  }

  @PostMapping("")
  public Product create(@RequestBody Product product){
    return productService.create(product);
  }


  @PutMapping("")
  public Product update(@RequestBody Product product){
    return productService.update(product);
  }
}
