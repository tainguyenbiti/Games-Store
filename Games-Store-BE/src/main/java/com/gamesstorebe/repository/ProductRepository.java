package com.gamesstorebe.repository;

import com.gamesstorebe.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository(value = "productRepository")
public interface ProductRepository extends JpaRepository<Product, Integer> {
     Optional<Product> findProductById(Integer id);
     Optional<Product> deleteProductById(Integer id);
}
