/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.luismassaneiro.sistemadonai.model;

import com.luismassaneiro.sistemadonai.enums.TipoMovimentacao;
import java.util.Date;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author Nando
 */
@Entity
@Table(name = "TB_MOVIMENTO_ESTOQUE")
public class MovimentoEstoque implements BusinessEntity{

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="MOV_ID")
    private Long id;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "MOV_TIPO", nullable = false)
    private TipoMovimentacao tipoMovimentacao;
    
    @Column(name="MOV_DATA", nullable=false)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dataMovimento = new Date();
    
    @ManyToOne(cascade= CascadeType.PERSIST, optional=false)
    @JoinColumn(name="MOV_PROID", nullable=false)
    private Produto produto;
    
    @Column(name="MOV_QNTDE", nullable=false)
    private Integer quantidade;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TipoMovimentacao getTipoMovimentacao() {
        return tipoMovimentacao;
    }

    public void setTipoMovimentacao(TipoMovimentacao tipoMovimentacao) {
        this.tipoMovimentacao = tipoMovimentacao;
    }

    public Date getDataMovimento() {
        return dataMovimento;
    }

    public void setDataMovimento(Date dataMovimento) {
        this.dataMovimento = dataMovimento;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.id);
        hash = 23 * hash + Objects.hashCode(this.tipoMovimentacao);
        hash = 23 * hash + Objects.hashCode(this.dataMovimento);
        hash = 23 * hash + Objects.hashCode(this.produto);
        hash = 23 * hash + Objects.hashCode(this.quantidade);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final MovimentoEstoque other = (MovimentoEstoque) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (this.tipoMovimentacao != other.tipoMovimentacao) {
            return false;
        }
        if (!Objects.equals(this.dataMovimento, other.dataMovimento)) {
            return false;
        }
        if (!Objects.equals(this.produto, other.produto)) {
            return false;
        }
        if (!Objects.equals(this.quantidade, other.quantidade)) {
            return false;
        }
        return true;
    }
    
    
}
