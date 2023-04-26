package com.rowan.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rowan.model.Supplier;

import java.util.Optional;


@Repository
public interface SupplierI extends JpaRepository<Supplier, Integer> {
    @Override
    Optional<Supplier> findById(Integer integer);
}
