package com.supermarket.supermarket.repository;

import com.supermarket.supermarket.entity.Supermarket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SupermarketRepository extends JpaRepository<Supermarket, Long> {
    public List<Supermarket> findAllProjectedBy();
}
