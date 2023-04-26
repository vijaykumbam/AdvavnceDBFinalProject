package com.rowan.repo;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rowan.model.Customer;

@Repository
public interface CustomerI extends JpaRepository<Customer, Integer> {
	
    @Override
    Optional<Customer> findById(Integer integer);

    @Override
    void deleteById(Integer integer);

    Customer findByRole(String role);

    List<Customer> findByCustomerNameAndPassword(String customerName, String password);
}
