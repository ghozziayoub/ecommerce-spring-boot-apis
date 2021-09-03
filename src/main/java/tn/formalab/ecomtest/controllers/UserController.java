package tn.formalab.ecomtest.controllers;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import tn.formalab.ecomtest.models.User;
import tn.formalab.ecomtest.models.User;
import tn.formalab.ecomtest.repositories.UserRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("users")
public class UserController {

    private UserRepository userRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping(path = "")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        user.password = this.bCryptPasswordEncoder.encode(user.password);
        User savedUser = userRepository.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    }

    @PostMapping(path = "login")
    public ResponseEntity<Map<String, Object>> loginUser(@RequestBody User user) {

        HashMap<String, Object> response = new HashMap<>();

        User userFromDB = userRepository.findByEmail(user.email);

        if (userFromDB == null) {
            response.put("message", "user not found !");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        } else {

            Boolean compare = this.bCryptPasswordEncoder.matches(user.password, userFromDB.password);

            if (!compare) {
                response.put("message", "user not found !");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
            } else {
                String token = Jwts.builder()
                        .claim("data", userFromDB)
                        .signWith(SignatureAlgorithm.HS256, "SECRET")
                        .compact();
                response.put("token", token);

                return ResponseEntity.status(HttpStatus.OK).body(response);
            }
        }
    }

    @GetMapping(path = "")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> categories = this.userRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(categories);
    }


}
