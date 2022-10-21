package com.zerotwopocket.product;

import com.zerotwopocket.product.web.Product;
import com.zerotwopocket.product.web.ProductRepo;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class ProductApplication {

  @Autowired private ProductRepo productRepo;

  public static void main(String[] args) {
    SpringApplication.run(ProductApplication.class);
  }

  @EventListener
  public void onAppReady(ApplicationReadyEvent readyEvent) {
    productRepo.save(
        new Product(
            1L,
            "Leaf Rake",
            "GDN-0011",
            "Garden",
            null,
            LocalDateTime.now(),
            "Leaf rake with 48-inch wooden handle",
            3.2,
            "assets/images/leaf_rake.png",
            BigDecimal.valueOf(19.95),
            "https://lzd-img-global.slatic.net/g/p/dc7c72727fdf31913a00096be2ba7a66.jpg_120x120q80.jpg_.webp,https://lzd-img-global.slatic.net/g/p/818655f79fef8dbe329e7a86feb136d5.jpg_120x120q80.jpg_.webp,https://lzd-img-global.slatic.net/g/p/c97af93d8450315ffdd4b0a3399fcc1c.jpg_120x120q80.jpg_.webp",
            10));

    productRepo.save(
        new Product(
            2L,
            "Garden Cart",
            "GDN-0023",
            "Garden",
            null,
            LocalDateTime.now(),
            "15 gallon capacity rolling garden cart",
            4.2,
            "assets/images/garden_cart.png",
            BigDecimal.valueOf(32.99),
            "",
            10));

    productRepo.save(
        new Product(
            3L,
            "Hammer",
            "TBX-0048",
            "Toolbox",
            null,
            LocalDateTime.now(),
            "Curved claw steel hammer",
            4.8,
            "assets/images/hammer.png",
            BigDecimal.valueOf(8.9),
            "",
            10));

    productRepo.save(
        new Product(
            4L,
            "Saw",
            "TBX-0022",
            "Toolbox",
            null,
            LocalDateTime.now(),
            "15-inch steel blade hand saw",
            3.7,
            "assets/images/saw.png",
            BigDecimal.valueOf(11.55),
            "",
            10));
    productRepo.save(
        new Product(
            5L,
            "Video Game Controller",
            "GMG-0042",
            "Gaming",
            null,
            LocalDateTime.now(),
            "Standard two-button video game controller",
            4.6,
            "assets/images/xbox-controller.png",
            BigDecimal.valueOf(35.95),
            "",
            10));
  }

  /*

       {
       id: 1,
       productName: 'Leaf Rake',
       productCode: 'GDN-0011',
       releaseDate: 'March 19, 2018',
       description: 'Leaf rake with 48-inch wooden handle',
       price: 19.95,
       starRating: 3.2,
       imageUrl: 'assets/images/leaf_rake.png',
       category: 'Garden',
       tags: ['rake', 'leaf', 'yard', 'home']
     },
     {
       id: 2,
       productName: 'Garden Cart',
       productCode: 'GDN-0023',
       releaseDate: 'March 18, 2018',
       description: '15 gallon capacity rolling garden cart',
       price: 32.99,
       starRating: 4.2,
       imageUrl: 'assets/images/garden_cart.png',
       category: 'Garden'
     },
     {
       id: 5,
       productName: 'Hammer',
       productCode: 'TBX-0048',
       releaseDate: 'May 21, 2018',
       description: 'Curved claw steel hammer',
       price: 8.9,
       starRating: 4.8,
       imageUrl: 'assets/images/hammer.png',
       category: 'Toolbox',
       tags: ['tools', 'hammer', 'construction']
     },
     {
       id: 8,
       productName: 'Saw',
       productCode: 'TBX-0022',
       releaseDate: 'May 15, 2018',
       description: '15-inch steel blade hand saw',
       price: 11.55,
       starRating: 3.7,
       imageUrl: 'assets/images/saw.png',
       category: 'Toolbox'
     },
     {
       id: 10,
       productName: 'Video Game Controller',
       productCode: 'GMG-0042',
       releaseDate: 'October 15, 2018',
       description: 'Standard two-button video game controller',
       price: 35.95,
       starRating: 4.6,
       imageUrl: 'assets/images/xbox-controller.png',
       category: 'Gaming'
     }
   ];

  */

}
