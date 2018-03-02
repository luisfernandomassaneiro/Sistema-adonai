/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.luismassaneiro.controleestoque.model;

import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author matheus_peressoni
 */
@Entity
@Table(name="TB_CATEGORIA")
public class Categoria extends Base implements BusinessEntity{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="CAT_ID")
    private Long id;
    @Column(name="CAT_DESCRICAO",nullable=false)
    private String descricao;    

    @OneToMany(mappedBy= "categoria")
    private List<Produto> produtos;
    public Categoria() {
    }

    public Categoria(Long id) {
        this.id = id;
    }

    public Categoria(String descricao) {
        this.descricao = descricao;
    }

    public Categoria(Long id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }
    
    @Override
    public Long getId() {
        return id;
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

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 67 * hash + (this.descricao != null ? this.descricao.hashCode() : 0);
        hash = 67 * hash + (this.produtos != null ? this.produtos.hashCode() : 0);
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
        final Categoria other = (Categoria) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return descricao;
    }

    public Categoria(String descricao, List<Produto> produtos) {
        this.descricao = descricao;
        this.produtos = produtos;
    }

}
