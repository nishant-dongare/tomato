package dn.spring.tomato.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dn.spring.tomato.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
