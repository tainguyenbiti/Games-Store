package com.gamesstorebe;

import com.gamesstorebe.customHandleError.system.Result;
import com.gamesstorebe.entity.Product;
import com.gamesstorebe.repository.ProductRepository;
import com.gamesstorebe.service.ProductService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

    @Test
    public void testDeleteProductById() {
        // Giả lập một sản phẩm tồn tại
        Product existingProduct = new Product();
        existingProduct.setId(1);
        existingProduct.setName("Test Product");

        // Giả lập khi gọi findById
        Mockito.when(productRepository.findProductById(1)).thenReturn(Optional.of(existingProduct));

        // Giả lập khi gọi deleteById
        Mockito.when(productRepository.deleteProductById(1)).thenReturn(Optional.of(existingProduct));

        // Thực hiện xóa sản phẩm
        Result result = productService.deleteProductById(1);

        // Kiểm tra kết quả
        assertNotNull(result);
        assertEquals(200, result.getCode());
    }

    @Test
    public void testDeleteNonexistentProductById() {
        // Giả lập khi gọi findById cho một sản phẩm không tồn tại
        Mockito.when(productRepository.findById(2)).thenReturn(Optional.empty());

        // Thực hiện xóa sản phẩm không tồn tại
        Result result = productService.deleteProductById(2);

        // Kiểm tra kết quả
        assertNotNull(result);
        assertEquals(404, result.getCode());
    }
    @Test
    public void testEditProduct(){
        Product productTest = new Product();
        productTest.setId(1);
        productTest.setName("Test Product");

        Mockito.when(productRepository.findProductById(1)).thenReturn(Optional.of(productTest));

        Product product = productRepository.findProductById(1).get();
        product.setName("Test Product edit");

        Result result = productService.saveProduct(product);

        assertNotNull(result);

        assertEquals(200, result.getCode());
    }
    @Test
    public void testFindProduct(){
        Product productTest = new Product();
        productTest.setId(1);
        productTest.setName("Test Product");
        Mockito.when(productRepository.findProductById(1)).thenReturn(Optional.of(productTest));
        Result result = productService.findProductById(1);
        assertNotNull(result);
        assertEquals(200, result.getCode());
    }
}
