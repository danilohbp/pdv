package com.example.pdv.model;

import java.io.Serializable;

import com.example.pdv.enums.TipoProduto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="estoque")
@Data
public class Estoque implements Serializable {
    
    @Id 
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private TipoProduto tipoProduto;

}
