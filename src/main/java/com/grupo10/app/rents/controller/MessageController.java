
package com.grupo10.app.rents.controller;

import com.grupo10.app.rents.entities.Message;
import com.grupo10.app.rents.entities.Quadbike;
import com.grupo10.app.rents.interfaces.IMessageRepository;
import com.grupo10.app.rents.interfaces.IQuadbikeRepository;
import com.grupo10.app.rents.service.MessageService;
import com.grupo10.app.rents.service.QuadbikeService;
import java.util.List;
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
@RequestMapping("/api/Message")
@CrossOrigin(origins = "*")
public class MessageController {

    @Autowired
    MessageService service;

    @GetMapping("/all")
    public Iterable<Message> get() {
        return service.get();
    }
    
    @GetMapping("/{id}")
    public Optional<Message> get(@PathVariable("id") Integer id) {
        return service.get(id);
    }
    

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody Message request) {
        service.create(request);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void update(@RequestBody Message request) {
        service.update(request);
    }
    

}