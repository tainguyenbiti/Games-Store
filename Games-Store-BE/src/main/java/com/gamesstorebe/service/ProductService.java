package com.gamesstorebe.service;

import com.gamesstorebe.customHandleError.system.Result;
import com.gamesstorebe.entity.Product;
import com.gamesstorebe.entity.RatingReview;
import com.gamesstorebe.repository.ProductRepository;
import com.gamesstorebe.repository.RatingReviewRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("productService")
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository, RatingReviewRepository ratingReviewRepository) {
        this.productRepository = productRepository;
    }

    public Result getAllProducts() {
        try {
            List<Product> products = productRepository.findAll();
            Optional<List<Product>> optionalProducts = Optional.ofNullable(products);
            if (!optionalProducts.get().isEmpty()) {
                return new Result(true, HttpStatus.OK, "Find all products", optionalProducts.get());
            } else {
                return new Result(false, HttpStatus.NO_CONTENT, "No products found", null);
            }
        }
        catch (Exception e){
            return new Result(false,HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), null);
        }
    }

    public Result saveProduct(Product product) {
        try {
            Optional<Product> productOptional = Optional.ofNullable(product);
            if (productOptional.isPresent()) {
                return new Result(true, HttpStatus.OK, "The product has been successfully created", product);
            }
            return new Result(false, HttpStatus.BAD_REQUEST, "Invalid request or incorrect input data", null);
        }
        catch (Exception e) {
            return new Result(false,HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), null);
        }
    }

    public Result findProductById(Integer id) {
        try {
            Optional<Product> product = productRepository.findProductById(id);
            if (product.isPresent()) {
                return new Result(true, HttpStatus.OK, "The product has been successfully found", product);
            }
            return new Result(false, HttpStatus.NOT_FOUND, "The product does not exist", null);
        }
        catch (Exception e) {
            return new Result(false,HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), null);
        }
    }
    public Result deleteProductById(Integer id) {
        try {
            Optional<Product> existingProduct  = productRepository.findProductById(id);
            if (existingProduct.isPresent()) {
                productRepository.deleteProductById(id);
                return new Result(true,HttpStatus.OK, "Product deleted successfully", null);
            } else {
                return new Result(true, HttpStatus.NOT_FOUND, "Product not found or could not be deleted", null);
            }

        } catch (Exception e) {
            return new Result(false,HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), null);
        }
    }
}
