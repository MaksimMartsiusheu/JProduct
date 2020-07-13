package com.jhipster.repository;

import com.jhipster.domain.Product;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the Product entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ProductRepository extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product> {

    @Modifying
    @Query("update Product p set p.categoryId=null where p.categoryId=:categoryId")
    void changeCategoryToDefault(Long categoryId);
}
