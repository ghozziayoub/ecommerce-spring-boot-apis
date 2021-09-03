package tn.formalab.ecomtest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.formalab.ecomtest.models.Category;
import tn.formalab.ecomtest.models.User;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByEmail(String email);

}
