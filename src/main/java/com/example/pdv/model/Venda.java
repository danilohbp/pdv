package com.example.pdv.model;

import java.io.Serializable;

import com.example.pdv.enums.EnumTipoPagamento;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Date;
import lombok.Data;

@Entity
@Table(name="venda")
@Data
public class Venda implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long codVenda;
    private Date dataVenda;
    private Double cobrado;
    private Double pago;
    private Double troco;
    private EnumTipoPagamento tipoPagamento;

}
