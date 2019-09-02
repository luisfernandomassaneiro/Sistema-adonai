/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.luismassaneiro.sistemadonai.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author matheus_peressoni
 */
@Entity
@Table(name="TB_PRODUTO")
public class Produto extends Base implements BusinessEntity, Serializable {
    @Id 
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="PRO_ID")
    private Long id;
    
    @Column(name="PRO_CODIGO")
    private String codigo;
    
    @Column(name="PRO_DESC", nullable=false, length=100)
    private String descricao;
    
    @Column(name="PRO_VALOR",nullable=false,length=10)
    private BigDecimal valor;
    
    @Column(name="PRO_CODIGOBARRAS")
    private String codigoBarras;
    
    @Column(name="PRO_VALORCOMPRA",length=10)
    private BigDecimal valorCompra;
    
    @Column(name="PRO_QTDEATUAl")
    private Integer qtdeAtual = 0;
    
    @Override
    public Long getId() {
        return id;
    }
    
    public Produto() {
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public BigDecimal getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(BigDecimal valorCompra) {
        this.valorCompra = valorCompra;
    }

    public Integer getQtdeAtual() {
        return qtdeAtual;
    }

    public void setQtdeAtual(Integer qtdeAtual) {
        this.qtdeAtual = qtdeAtual;
    }
}
    

