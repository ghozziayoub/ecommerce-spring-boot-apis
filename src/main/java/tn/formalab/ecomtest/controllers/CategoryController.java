package tn.formalab.ecomtest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.formalab.ecomtest.models.Category;
import tn.formalab.ecomtest.repositories.CategoryRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("categories")
public class CategoryController {

    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @PostMapping(path = "")
    public ResponseEntity<Category> addCategory(@RequestBody Category category) {
        Category savedCategory = this.categoryRepository.save(category);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCategory);
    }

    @GetMapping(path = "")
    public ResponseEntity<List<Category>> getAllCategories() {
        List<Category> categories = this.categoryRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(categories);
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<Optional<Category>> getCategoryById(@PathVariable Integer id) {
        // try {
        Optional<Category> category = this.categoryRepository.findById(id);//.get();

        if (category.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(category);
        else
            return ResponseEntity.status(HttpStatus.OK).body(category);

        //return ResponseEntity.status(HttpStatus.OK).body(category);
       /* } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Category());
        }*/
    }

    @GetMapping(path = "name/{name}")
    public ResponseEntity<Category> getCategoryByName(@PathVariable String name) {

        Category category = this.categoryRepository.findByName(name);

        if (category == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Category());
        else
            return ResponseEntity.status(HttpStatus.OK).body(category);

    }


    @DeleteMapping(path = "{id}")
    public ResponseEntity<Map<String, Object>> deleteCategory(@PathVariable Integer id) {
        this.categoryRepository.deleteById(id);

        HashMap<String, Object> response = new HashMap<>();
        response.put("message", "category deleted");

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PatchMapping(path = "")
    public ResponseEntity<Category> updateCategory(@RequestBody Category category) {
        Category updatedCategroy = this.categoryRepository.save(category);
        return ResponseEntity.status(HttpStatus.OK).body(updatedCategroy);
    }

}
