package ra.baitapcoban1.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ra.baitapcoban1.dto.ProductDto;
import ra.baitapcoban1.module.Product;
import ra.baitapcoban1.service.ProductService;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/v1/product")
public class ProductController {
    private final ProductService productService;
    @GetMapping
    public ResponseEntity<List<Product>> getAll(){
        return ResponseEntity.ok(productService.findAll());
    }
    @GetMapping("{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id){
        return ResponseEntity.ok(productService.findEmployeeById(id));
    }

    @PostMapping
    public ResponseEntity<Product> add(@Valid  @RequestBody ProductDto productDto){
        return new ResponseEntity<>(productService.save(productDto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@Valid @RequestBody ProductDto productDto, @PathVariable Long id) {
        return ResponseEntity.ok(productService.update(productDto, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        productService.delete(id);
        return ResponseEntity.ok("Delete Success");
    }
}
