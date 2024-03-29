package com.repository;

import com.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAllByUser_Id(long userId);
    Product findDistinctByIdAndUser_Id(long productId, long userId);

    @Query("select count(distinct users_id) from userproduct")
    long countUniqueUserProducts();
}
