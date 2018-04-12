package com.luismassaneiro.sistemadonai.dto;

import java.util.ArrayList;
import java.util.List;

public class ConsultaEmAbertoCabecalhoDTO {
    private String codigoCliente;
    private String nomeCliente;
    private String periodo;
    private List<ConsultaEmAbertoDetalheDTO> detalhe;
    
    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public List<ConsultaEmAbertoDetalheDTO> getDetalhe() {
        return detalhe;
    }

    public void setDetalhe(List<ConsultaEmAbertoDetalheDTO> detalhe) {
        this.detalhe = detalhe;
    }

    public void add(ConsultaEmAbertoDetalheDTO umDetalhe) {
        if(detalhe == null)
            detalhe = new ArrayList<>();
        
        detalhe.add(umDetalhe);
    }

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

}
