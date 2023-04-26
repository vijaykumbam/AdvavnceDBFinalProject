package com.rowan.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rowan.model.AdventureWorks;

@Repository
public interface AdventureWorksI extends JpaRepository<AdventureWorks, Integer> {
}
