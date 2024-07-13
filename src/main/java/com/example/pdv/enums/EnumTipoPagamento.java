package com.example.pdv.enums;


public enum EnumTipoPagamento {
    
    CD("Cartão"),
    DN("Dinheiro");

    private final String valor;

    EnumTipoPagamento(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }

}
