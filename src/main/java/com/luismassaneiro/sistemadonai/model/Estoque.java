/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.luismassaneiro.sistemadonai.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author luiz_f_massaneiro
 */
@Embeddable
public class Estoque {
 
    @Column(name="PRO_QTDMIN")
    private Integer qtdeMinima;
    
    @Column(name="PRO_QTDEATUAl")
    private Integer qtdeAtual = 0;
    
    public Estoque() {
    }

    public Estoque(Integer qtdeMinima) {
        this.qtdeMinima = qtdeMinima;
    }

    public Integer getQtdeMinima() {
        return qtdeMinima;
    }

    public void setQtdeMinima(Integer qtdeMinima) {
        this.qtdeMinima = qtdeMinima;
    }

    public Integer getQtdeAtual() {
        return qtdeAtual;
    }

    public void setQtdeAtual(Integer qtdeAtual) {
        this.qtdeAtual = qtdeAtual;
    }

}
