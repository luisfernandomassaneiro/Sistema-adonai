package com.luismassaneiro.sistemadonai.dto;

import java.util.ArrayList;
import java.util.List;

public class ConsultaDetalhadaCabecalhoDTO {
    private String cliente;
    private String periodo;
    private String situacao;
    private List<ConsultaDetalhadaDetalheDTO> detalhe;
    
    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public List<ConsultaDetalhadaDetalheDTO> getDetalhe() {
        return detalhe;
    }

    public void setDetalhe(List<ConsultaDetalhadaDetalheDTO> detalhe) {
        this.detalhe = detalhe;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }
    
    public void add(ConsultaDetalhadaDetalheDTO umDetalhe) {
        if(detalhe == null)
            detalhe = new ArrayList<>();
        
        detalhe.add(umDetalhe);
    }

}
