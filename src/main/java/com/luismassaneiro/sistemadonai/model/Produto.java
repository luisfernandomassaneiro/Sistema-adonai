/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.luismassaneiro.sistemadonai.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
    
    @Column(name="PRO_VALORCOMPRA",nullable=false,length=10)
    private BigDecimal valorCompra;
    
    @Column(name="PRO_VALORVENDA",nullable=false,length=10)
    private BigDecimal valorVenda;
    
    @ManyToOne(cascade={CascadeType.PERSIST})
    @JoinColumn(name="PRO_CATID", nullable=false)
    private Categoria categoria;
    
    @Embedded
    private Estoque estoque;

    @Override
    public Long getId() {
        return id;
    }
    
    public Produto() {
        estoque = new Estoque();
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

    public BigDecimal getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(BigDecimal valorCompra) {
        this.valorCompra = valorCompra;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Estoque getEstoque() {
        return estoque;
    }

    public void setEstoque(Estoque estoque) {
        this.estoque = estoque;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public BigDecimal getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(BigDecimal valorVenda) {
        this.valorVenda = valorVenda;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.id);
        hash = 29 * hash + Objects.hashCode(this.codigo);
        hash = 29 * hash + Objects.hashCode(this.descricao);
        hash = 29 * hash + Objects.hashCode(this.valorCompra);
        hash = 29 * hash + Objects.hashCode(this.valorVenda);
        hash = 29 * hash + Objects.hashCode(this.categoria);
        hash = 29 * hash + Objects.hashCode(this.estoque);
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
        final Produto other = (Produto) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        if (!Objects.equals(this.valorCompra, other.valorCompra)) {
            return false;
        }
        if (!Objects.equals(this.valorVenda, other.valorVenda)) {
            return false;
        }
        if (!Objects.equals(this.categoria, other.categoria)) {
            return false;
        }
        if (!Objects.equals(this.estoque, other.estoque)) {
            return false;
        }
        return true;
    }

    
    
}
    

