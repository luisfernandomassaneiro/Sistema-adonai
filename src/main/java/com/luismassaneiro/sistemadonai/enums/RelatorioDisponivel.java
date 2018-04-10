/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.luismassaneiro.sistemadonai.enums;

/**
 *
 * @author luis.massaneiro
 */
public enum RelatorioDisponivel {
    CONSULTA_DETALHADA("consultaDetalhada.jasper", "Extrato de clientes"),
    CONSULTA_EM_ABERTO("consultaEmAberto.jasper", "Consulta em aberto");

    private String nomeRelatorio;
    private String descricaoRelatorio;
    
    private RelatorioDisponivel(String nomeRelatorio, String descricaoRelatorio) {
        this.nomeRelatorio = nomeRelatorio;
        this.descricaoRelatorio = descricaoRelatorio;
    }

    public String getNomeRelatorio() {
        return nomeRelatorio;
    }

    public void setNomeRelatorio(String nomeRelatorio) {
        this.nomeRelatorio = nomeRelatorio;
    }

    public String getDescricaoRelatorio() {
        return descricaoRelatorio;
    }

    public void setDescricaoRelatorio(String descricaoRelatorio) {
        this.descricaoRelatorio = descricaoRelatorio;
    }
    
}
