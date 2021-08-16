package com.supermarket.supermarket.repository;

import com.supermarket.supermarket.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Role DAO
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(String name);

}
