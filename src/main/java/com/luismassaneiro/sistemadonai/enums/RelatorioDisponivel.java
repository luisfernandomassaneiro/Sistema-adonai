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
    CONSULTA_DETALHADA("consultaDetalhada", "Extrato de clientes", false),
    CONSULTA_EM_ABERTO("consultaEmAberto", "Clientes em aberto", false),
    RELATORIO_MENSAL("consulta", "Relatório Mensal", true);

    private String nomeRelatorio;
    private String descricaoRelatorio;
    private boolean isMensal;
    
    private RelatorioDisponivel(String nomeRelatorio, String descricaoRelatorio, boolean isMensal) {
        this.nomeRelatorio = nomeRelatorio;
        this.descricaoRelatorio = descricaoRelatorio;
        this.isMensal = isMensal;
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

    public boolean isIsMensal() {
        return isMensal;
    }

    public void setIsMensal(boolean isMensal) {
        this.isMensal = isMensal;
    }
    
}
