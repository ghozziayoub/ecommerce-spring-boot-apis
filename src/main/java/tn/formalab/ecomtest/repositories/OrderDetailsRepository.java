package tn.formalab.ecomtest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.formalab.ecomtest.models.OrderDetails;

public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Integer> {
}
