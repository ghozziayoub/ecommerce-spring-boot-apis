package tn.formalab.ecomtest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.formalab.ecomtest.models.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

    Category findByName(String name);
}
