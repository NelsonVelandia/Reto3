
package com.usa.alquiler.services;

import com.usa.alquiler.entity.Ortopedic;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.usa.alquiler.repository.crud.OrtopedicRepository;

/**
 *
 * @author NELSON
 */
@Service
public class OrtopedicService {
    
    @Autowired
    private OrtopedicRepository ortopedicRepository;
    
    public List<Ortopedic> getAll(){
        //return (List<Ortopedic>) ortopedicRepository.findAll();
        return ortopedicRepository.getAll();
        
    }
    
    public Optional<Ortopedic> getOrtopedic(int idOrtopedic){
        return ortopedicRepository.getOrtopedic(idOrtopedic);
    }
    
    public Ortopedic save(Ortopedic ortopedic){
         if(ortopedic.getId() == null){
            return ortopedicRepository.save(ortopedic);
        }else{
            Optional<Ortopedic> ortop = ortopedicRepository.getOrtopedic(ortopedic.getId());
            //if(evt.isEmpty()){ //java 11?
            if(ortop.isPresent()){
                return ortopedic;
            }else{
                return ortopedicRepository.save(ortopedic);
            }
        
        }
    }
    
}

 
