package br.com.LC.Spring_enterprise.models;

import java.util.Date;
import java.util.Objects;

public class Employer {

     private Long id;
     private String nome;
     private String cpf;
     private Date dateOfBirth;
     private Enum cargos;
     private String phoneNumber;
     private Date dateOfHire;
     private Date dismissalDate;
     private Double salary;

    public Employer() {
    }

    public Employer(String cpf, Long id, String nome, Date dateOfBirth, Enum cargos, String phoneNumber, Date dateOfHire, Double salary) {
        this.id = id;
        this.cpf = cpf;
        this.id = id;
        this.nome = nome;
        this.dateOfBirth = dateOfBirth;
        this.cargos = cargos;
        this.phoneNumber = phoneNumber;
        this.dateOfHire = dateOfHire;
        this.salary = salary;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public Enum getCargos() {
        return cargos;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Date getDateOfHire() {
        return dateOfHire;
    }

    public Date getDismissalDate() {
        return dismissalDate;
    }

    public Double getSalary() {
        return salary;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCargos(Enum cargos) {
        this.cargos = cargos;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Employer that)) return false;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Funcionarios{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", cargos=" + cargos +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", dateOfHire=" + dateOfHire +
                ", dismissalDate=" + dismissalDate +
                ", salary=" + salary +
                '}';
    }
}
