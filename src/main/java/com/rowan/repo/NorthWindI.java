package com.rowan.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rowan.model.NorthWind;

@Repository
public interface NorthWindI extends JpaRepository<NorthWind, Integer> {
}
