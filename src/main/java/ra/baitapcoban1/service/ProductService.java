package ra.baitapcoban1.service;



import ra.baitapcoban1.dto.ProductDto;
import ra.baitapcoban1.module.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    Product findEmployeeById(Long proId);
    Product save(ProductDto productDto);
    Product update(ProductDto productDto, Long id);
    void delete(Long proId);
    List<Product> findAllByFullNameContaining(String name);
}
