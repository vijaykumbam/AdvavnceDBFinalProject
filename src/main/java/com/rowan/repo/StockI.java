package com.rowan.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rowan.model.Stock;


@Repository
public interface StockI  extends JpaRepository<Stock, Integer> {
    Stock findByProductId(int productId);

    long deleteByProductId(int productId);

}
