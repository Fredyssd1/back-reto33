package com.grupo10.app.rents.repository;

import com.grupo10.app.rents.entities.Message;
import com.grupo10.app.rents.entities.Quadbike;
import com.grupo10.app.rents.interfaces.IMessageRepository;
import com.grupo10.app.rents.interfaces.IQuadbikeRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MessageRepository {
    
    @Autowired
    IMessageRepository repository;
    
    public Iterable<Message> getAll(){
        return repository.findAll();
    }
    
    public Optional<Message> findById(Integer id){
        Optional<Message> response= repository.findById(id);
        return response;
    }
    
    public Boolean existsById(Integer id){
        return repository.existsById(id);
    }
    
    public void deleteById(Integer id){
        repository.deleteById(id);
    }
    
    public Message saveMessage(Message message){
        return repository.save(message);
    }
    
    
}
