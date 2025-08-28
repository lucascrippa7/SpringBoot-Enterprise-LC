package br.com.LC.Spring_enterprise.services;

import br.com.LC.Spring_enterprise.exceptions.ResourceExceptionHandler;
import br.com.LC.Spring_enterprise.models.Employer;
import br.com.LC.Spring_enterprise.repositories.EmployersRepositorie;
import br.com.LC.Spring_enterprise.services.exceptions.DatabaseException;
import br.com.LC.Spring_enterprise.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;

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
        return obj.orElseThrow(()-> new ResourceNotFoundException(id));
    }

    public Employer insert(Employer obj){ return repository.save(obj);}

    public void delete(Long id){
        try{
            if(repository.existsById(id)){
                repository.deleteById(id);
            }
            else{
                System.out.println("Id non-existent");
            }
        } catch (DataIntegrityViolationException e){
            throw new DatabaseException(e.getMessage());
        }
    }

    public Employer update(Long id, Employer obj){
        try{
           Employer employer = repository.getReferenceById(id);
           updateData(employer, obj);
           return repository.save(employer);
        } catch (DataIntegrityViolationException e){
            throw new DatabaseException(e.getMessage());
        }
    }

    private void updateData(Employer employer, Employer obj) {
       employer.setNome(obj.getNome());
       employer.setCargos(obj.getCargos());
       employer.setSalary(obj.getSalary());
       employer.setPhoneNumber(obj.getPhoneNumber());

    }
}
