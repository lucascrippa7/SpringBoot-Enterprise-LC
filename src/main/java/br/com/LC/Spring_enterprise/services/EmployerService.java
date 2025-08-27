package br.com.LC.Spring_enterprise.services;

import br.com.LC.Spring_enterprise.exceptions.ResourceExceptionHandler;
import br.com.LC.Spring_enterprise.models.Employer;
import br.com.LC.Spring_enterprise.repositories.EmployersRepositorie;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class EmployerService {

    //Injetando o repository
    @Autowired
    private EmployersRepositorie repository;

    // Buscar todos os usuarios
    public List<Employer> findAll(){
        return  repository.findAll();
    }

    public Employer findById(Long id){
        Optional<Employer> obj = repository.findById(id);
        return obj.orElseThrow(()-> new ResourceExceptionHandler(id));
    }

}
