package org.sopt.cdsserver.product.repository;

import org.sopt.cdsserver.category.domain.Category;
import org.sopt.cdsserver.product.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ProductJpaRepository extends JpaRepository<Product, Long> {
    List<Product> findAllByCategory(final Category category);
}
