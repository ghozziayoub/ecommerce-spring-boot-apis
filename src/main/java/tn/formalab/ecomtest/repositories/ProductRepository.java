package tn.formalab.ecomtest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.formalab.ecomtest.models.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
