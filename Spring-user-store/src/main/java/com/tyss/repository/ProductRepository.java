package com.tyss.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tyss.entity.Product;
import com.tyss.entity.User;

public interface ProductRepository extends JpaRepository<Product, Long> {

	Optional<Product> findByPid(Long id);
}
