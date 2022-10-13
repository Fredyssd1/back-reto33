
package com.grupo10.app.rents.interfaces;

import com.grupo10.app.rents.entities.Category;
import org.springframework.data.repository.CrudRepository;


public interface ICategoryRepository extends CrudRepository<Category, Integer> {
    
}
