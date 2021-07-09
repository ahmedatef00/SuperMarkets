package com.supermarket.supermarket.repository;

import com.supermarket.supermarket.entity.Supermarket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupermarketRepository extends JpaRepository<Supermarket,Long> {
}