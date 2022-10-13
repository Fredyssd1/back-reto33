package com.grupo10.app.rents.repository;

import com.grupo10.app.rents.entities.Category;
import com.grupo10.app.rents.entities.Quadbike;
import com.grupo10.app.rents.interfaces.ICategoryRepository;
import com.grupo10.app.rents.interfaces.IQuadbikeRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CategoryRepository {
    
    @Autowired
    ICategoryRepository repository;
    
    public Iterable<Category> getAll(){
        return repository.findAll();
    }
    
    public Optional<Category> findById(Integer id){
        Optional<Category> response= repository.findById(id);
        return response;
    }
    
    public Boolean existsById(Integer id){
        return repository.existsById(id);
    }
    
    public void deleteById(Integer id){
        repository.deleteById(id);
    }
    
    public Category save(Category category){
        return repository.save(category);
    }
    
}
