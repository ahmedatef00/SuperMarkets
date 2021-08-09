package com.supermarket.supermarket.repository;

import com.supermarket.supermarket.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.NamedQuery;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

//User DAO
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    //    List<User> findUsersByRoleName(String roleName);
    Optional<User> findByUsername(String username);

}
