package ra.baitapcoban1.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ra.baitapcoban1.dto.ProductDto;
import ra.baitapcoban1.module.Product;
import ra.baitapcoban1.repository.ProductRepository;
import ra.baitapcoban1.service.ProductService;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findEmployeeById(Long proId) {
        return productRepository.findById(proId).orElseThrow(()->new NoSuchElementException("Khong co ton tai id "+proId));
    }

    @Override
    public Product save(ProductDto productDto) {
        return Product.builder()
                .productName(productDto.getProductName())
                .producer(productDto.getProducer())
                .yearOfManufacture(productDto.getYearOfManufacture())
                .expirationDate(productDto.getExpirationDate())
                .price(productDto.getPrice())
                .build();
    }

    @Override
    public Product update(ProductDto productDto, Long id) {
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Khong co ton tai id " + id));

        Product updatedProduct = Product.builder()
                .id(existingProduct.getId())
                .productName(productDto.getProductName())
                .producer(productDto.getProducer())
                .yearOfManufacture(productDto.getYearOfManufacture())
                .expirationDate(productDto.getExpirationDate())
                .price(productDto.getPrice())
                .build();

        return productRepository.save(updatedProduct);
    }


    @Override
    public void delete(Long proId) {
        productRepository.findById(proId).orElseThrow(()->new NoSuchElementException("Khong co ton tai id "+proId));
        productRepository.deleteById(proId);
    }

    @Override
    public List<Product> findAllByFullNameContaining(String name) {
        return productRepository.findAllByProductNameContaining(name);
    }
}
