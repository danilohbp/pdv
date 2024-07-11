package com.example.pdv.model;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="usuario")
@Data
public class Usuario implements Serializable {
    
    @Id 
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private Date dataNascimento;
    private String cpf;

}
