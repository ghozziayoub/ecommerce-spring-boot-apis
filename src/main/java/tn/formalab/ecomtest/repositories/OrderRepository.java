package tn.formalab.ecomtest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.formalab.ecomtest.models.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}
