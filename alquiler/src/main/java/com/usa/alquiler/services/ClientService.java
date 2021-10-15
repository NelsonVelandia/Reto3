
package com.usa.alquiler.services;

import com.usa.alquiler.entity.Client;
import com.usa.alquiler.repository.crud.ClientRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author NELSON
 */
@Service
public class ClientService {
    
    @Autowired
    private ClientRepository clientRepository;
    
    public List<Client> getAllClient(){
        return clientRepository.getAllClient();
    }
    
    public Optional<Client> getIdClient(int idCliente){
        return clientRepository.getIdClient(idCliente);
    }
    
    public Client save(Client client){
         if(client.getIdClient() == null){
            return clientRepository.save(client);
        }else{
            Optional<Client> clie = clientRepository.getIdClient(client.getIdClient());
            //if(evt.isEmpty()){ //java 11?
            if(clie.isPresent()){
                return client;
            }else{
                return clientRepository.save(client);
            }
        
        }
    }
    
}
