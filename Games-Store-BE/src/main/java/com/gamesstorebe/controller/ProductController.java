package com.gamesstorebe.controller;

import com.gamesstorebe.customHandleError.system.Result;
import com.gamesstorebe.entity.Product;
import com.gamesstorebe.service.ProductService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public Result getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/get-product-by-id/{productId}")
    public Result getProductByProductId(@PathVariable (name = "productId") Integer productId) {
        return productService.findProductById(productId);
    }

    @PostMapping("save-product")
    public Result saveProduct (@RequestBody Product product){
        return productService.saveProduct(product);
    }

    @GetMapping("/get-product-by-featured/{featuredId}")
    public Result getProductByFeatured(@PathVariable (name = "featuredId") int featuredId) {
        return productService.findProductByFeatures(featuredId);
    }

}
