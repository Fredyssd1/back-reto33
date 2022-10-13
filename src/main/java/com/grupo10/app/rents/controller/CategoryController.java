
package com.grupo10.app.rents.controller;

import com.grupo10.app.rents.entities.Category;
import com.grupo10.app.rents.interfaces.ICategoryRepository;
import com.grupo10.app.rents.service.CategoryService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/Category")
@CrossOrigin(origins = "*")
public class CategoryController {

    @Autowired
    CategoryService service;

    @GetMapping("/all")
    public Iterable<Category> get() {
        //Iterable<Category> response = service.get();

        return service.get();
    }
    
    @GetMapping("/{id}")
    public Optional<Category> get(@PathVariable("id") Integer id) {

        return service.get(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody Category request) {
        service.create(request);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void update(@RequestBody Category request) {
        service.update(request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void delete(@PathVariable("id") Integer id) {
        service.delete(id);
    }

}
