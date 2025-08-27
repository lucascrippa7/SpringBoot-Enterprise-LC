package br.com.LC.Spring_enterprise.repositories;

import br.com.LC.Spring_enterprise.models.Employer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployersRepositorie extends JpaRepository<Employer, Long> {
}
