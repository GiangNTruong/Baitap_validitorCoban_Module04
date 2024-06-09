package ra.baitapcoban1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ra.baitapcoban1.module.Product;


import java.util.List;
@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    List<Product> findAllByProductNameContaining(String name);
}
