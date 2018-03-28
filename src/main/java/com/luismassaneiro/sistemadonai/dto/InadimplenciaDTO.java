package com.luismassaneiro.sistemadonai.dto;

import java.math.BigDecimal;

public class InadimplenciaDTO {
    private String codigoCliente;
    private String nomeCliente;
    private BigDecimal valorTotalDevido;

    public String getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(String codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public BigDecimal getValorTotalDevido() {
        return valorTotalDevido;
    }

    public void setValorTotalDevido(BigDecimal valorTotalDevido) {
        this.valorTotalDevido = valorTotalDevido;
    }
    
    
}
