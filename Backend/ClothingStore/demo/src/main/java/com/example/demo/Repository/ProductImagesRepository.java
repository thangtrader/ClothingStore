package com.example.demo.Repository;

import com.example.demo.Models.ProductImages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductImagesRepository extends JpaRepository<ProductImages, Long> {
    List<ProductImages> findByProductId(Long productId);
    ProductImages findByImageUrl(String imageUrl);
//    Optional<ProductImage> findByProductId(Long productId);
}