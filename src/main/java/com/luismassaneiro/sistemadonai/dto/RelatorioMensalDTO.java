/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.luismassaneiro.sistemadonai.dto;

import java.util.List;

/**
 *
 * @author luis.massaneiro
 */
public class RelatorioMensalDTO {
    List<ConsultaDetalhadaCabecalhoDTO> mestre;

    public List<ConsultaDetalhadaCabecalhoDTO> getMestre() {
        return mestre;
    }

    public void setMestre(List<ConsultaDetalhadaCabecalhoDTO> mestre) {
        this.mestre = mestre;
    }
    
}
