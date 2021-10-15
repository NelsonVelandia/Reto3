
package com.usa.alquiler.controller;

import com.usa.alquiler.entity.Ortopedic;
import com.usa.alquiler.services.OrtopedicService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author NELSON
 */
//@RestController
//
//public class OrtopediController {
//    
//    @Autowired
//    OrtopedicService ortopedicService;
//    
//   @GetMapping("/api/Ortopedic")
//    public Object obtenerOrtopedicAll(){
//        return ortopedicService.getOrtopedicAll();
//    }
//    
//    @GetMapping("/{id}")
//    public Object obtenerOrtopedicId(){
//        return ortopedicService.getOrtopedicId(id);
//    }
//    
//}

@RestController
@RequestMapping("/api/Ortopedic")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class OrtopediController {
    
   
    @Autowired
    private OrtopedicService ortopedicService ;
    
    @GetMapping("/all")
    public List <Ortopedic> getOrtopedic(){
        return ortopedicService.getAll();
    }
    
    @GetMapping("/{id}")
    public Optional<Ortopedic> getOrtopedic(@PathVariable("id") int idOrtopedic){
        return ortopedicService.getOrtopedic(idOrtopedic);
    }
    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Ortopedic save(@RequestBody Ortopedic ortopedic){
        return ortopedicService.save(ortopedic);
    }
}
