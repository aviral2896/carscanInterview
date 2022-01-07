package com.example.carscaninterview.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseDAO<T> extends JpaRepository<T, String> {
}