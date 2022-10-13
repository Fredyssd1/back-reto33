
package com.grupo10.app.rents.service;

import com.grupo10.app.rents.interfaces.IQuadbikeRepository;
import com.grupo10.app.rents.entities.Category;
import com.grupo10.app.rents.interfaces.ICategoryRepository;
//import com.grupo10.app.rents.entities.Quadbike;
import com.grupo10.app.rents.repository.CategoryRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;


@Service
public class CategoryService {

    @Autowired
    CategoryRepository repository;


    public Iterable<Category> get() {
        Iterable<Category> response = repository.getAll();
        return response;
    }

    public Optional<Category> get(Integer id) {

        Optional<Category> response = repository.findById(id);
        return response;
    }
    
    
        public Category create(@RequestBody  Category request) {       
           
        return repository.save(request);
     

    }
    
    public Category update(Category category) {
        Category categoryToUpdate=new Category();
        if(repository.existsById(category.getId())){
            categoryToUpdate = category;
            repository.save(categoryToUpdate);
        }        
        return categoryToUpdate;
    }
    
    public Boolean delete(Integer id) {
        repository.deleteById(id);
        Boolean deleted = true;
        return deleted;
    }
}
