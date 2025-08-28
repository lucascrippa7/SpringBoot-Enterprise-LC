package br.com.LC.Spring_enterprise.controllers;


import br.com.LC.Spring_enterprise.models.Employer;
import br.com.LC.Spring_enterprise.services.EmployerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/employers")
public class EmployerController {

    @Autowired
    private EmployerService service;

    @GetMapping
    public ResponseEntity<List<Employer>> findAll(){
        List<Employer> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Employer> findById(@PathVariable Long id){
        Employer obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Employer> insert (@RequestBody Employer obj){
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }


    @DeleteMapping(value = "{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping(value = "{id}")
    public ResponseEntity<Employer> update (@PathVariable Long id, @RequestBody Employer obj){
        obj = service.update(id, obj);
        return ResponseEntity.ok().body(obj);
    }


}
