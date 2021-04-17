package com.example.XYZ.repository;

import com.example.XYZ.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findProductById(Long id);

    /*@Query("FROM Product AS p GROUP BY p.price, p.id ORDER BY p.id ASC")
    List<Product> groupByPrice();

    @Query("FROM Product AS p GROUP BY p.color, p.id ORDER BY p.id ASC")
    List<Product> groupByColor();

    @Query("FROM Product AS p GROUP BY p.pSize, p.id ORDER BY p.id ASC")
    List<Product> groupBySize();

    @Query("FROM Product AS p GROUP BY p.brandName, p.id ORDER BY p.id ASC")
    List<Product> groupByBrand();*/

    List<Product> findAll();
}
