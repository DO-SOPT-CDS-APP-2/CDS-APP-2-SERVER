package org.sopt.cdsserver.category.repository;

import org.sopt.cdsserver.category.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryJpaRepository extends JpaRepository<Category, Long> {
}