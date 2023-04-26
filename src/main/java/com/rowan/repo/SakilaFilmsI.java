package com.rowan.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rowan.model.Sakila_Films;

@Repository
public interface SakilaFilmsI extends JpaRepository<Sakila_Films, Integer> {
}
