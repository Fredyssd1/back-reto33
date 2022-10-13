
package com.grupo10.app.rents.service;

import com.grupo10.app.rents.interfaces.IQuadbikeRepository;
import com.grupo10.app.rents.entities.Category;
import com.grupo10.app.rents.entities.Client;
import com.grupo10.app.rents.entities.Message;
import com.grupo10.app.rents.interfaces.ICategoryRepository;
import com.grupo10.app.rents.entities.Quadbike;
import com.grupo10.app.rents.interfaces.IMessageRepository;
import com.grupo10.app.rents.repository.ClientRepository;
import com.grupo10.app.rents.repository.MessageRepository;
import com.grupo10.app.rents.repository.QuadbikeRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;


@Service
public class MessageService {

    @Autowired
    MessageRepository repository;

    @Autowired
    QuadbikeRepository quadbikeRepository; 
    
    @Autowired
    ClientRepository clientRepository;

    public Iterable<Message> get() {
        Iterable<Message> response = repository.getAll();
        return response;
    }

     public Optional<Message> get(Integer id) {
        Optional<Message> response = repository.findById(id);
        return response;
    }   
    
    
    public Message create(@RequestBody Message request) {

        Optional<Quadbike> quad = quadbikeRepository.findById(request.getQuadbike().getId());
        if (!quad.isEmpty()) {
            request.setQuadbike(quad.get());
        }
        
        Optional<Client> cli;
        cli = clientRepository.findById(request.getClient().getIdClient());
        if (!cli.isEmpty()) {
            request.setClient(cli.get());
        }
        return repository.saveMessage(request);
        }
    
        public Message update(Message message) {
        Message messageToUpdate=new Message();
        
        if(repository.existsById(message.getIdMessage())){
            messageToUpdate = message;
            repository.saveMessage(messageToUpdate);
        }

        return messageToUpdate;
    }
}
