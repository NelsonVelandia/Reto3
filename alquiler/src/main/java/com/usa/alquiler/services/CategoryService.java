
package com.usa.alquiler.services;

import com.usa.alquiler.entity.Category;
import com.usa.alquiler.repository.crud.CategoryRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author NELSON
 */
@Service
public class CategoryService {
    
    @Autowired
    private CategoryRepository categoryRepository;
    
    public List<Category> getAllCategory(){
        return categoryRepository.getAllCategory();
    }
    
    public Optional<Category> getIdCategory(int idCategory){
        return categoryRepository.getIdCategory(idCategory);
    }
    
    public Category save(Category category){
         if(category.getId() == null){
            return categoryRepository.save(category);
        }else{
            Optional<Category> categor = categoryRepository.getIdCategory(category.getId());
            if(categor.isPresent()){
                return category;
            }else{
                return categoryRepository.save(category);
            }
        
        }
    }
    
}
