package com.grupo10.app.rents.controller;

import com.grupo10.app.rents.entities.Client;
import com.grupo10.app.rents.interfaces.IQuadbikeRepository;
import com.grupo10.app.rents.entities.Quadbike;
import com.grupo10.app.rents.interfaces.IClientRepository;
import com.grupo10.app.rents.service.ClientService;
import java.util.ArrayList;
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
@RequestMapping("/api/Client")
@CrossOrigin(origins = "*")
public class ClientController {

    @Autowired
    ClientService service;

    @GetMapping("/all")
    public Iterable<Client> get() {
        return service.get();
    }
    
    @GetMapping("/{id}")
    public Optional<Client> get(@PathVariable("id") Integer id) {

        return service.get(id);
    }
    
    //@GetMapping("/reports/year")
   // public List<Object[]> getReport() {

   //     return service.getReportClent();
   // }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody Client request) {
        service.create(request);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void update(@RequestBody Client request) {
        service.update(request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void delete(@PathVariable("id") Integer id) {
        service.delete(id);
    }

}
