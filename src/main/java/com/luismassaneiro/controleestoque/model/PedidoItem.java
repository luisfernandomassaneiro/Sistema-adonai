package com.luismassaneiro.controleestoque.model;

import java.math.BigDecimal;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author luiz_f_massaneiro
 */
@Entity
@Table(name = "TB_PEDIDO_ITEM")
public class PedidoItem implements BusinessEntity{
 
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="PIT_ID")
    private Long id;
    
    @ManyToOne(cascade= CascadeType.PERSIST, optional=false)
    @JoinColumn(name="PIT_PROID", nullable=false)
    private Produto produto;
    
    @Column(name="PIT_QNTDE", nullable=false)
    private Integer quantidade;

    @Column(name="PIT_VALORVENDA", nullable=false)
    private BigDecimal valorVenda;
    
    @Column(name="PIT_VALORCOMPRA", nullable=false)
    private BigDecimal valorCompra;
    
    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
    public String toString() {
        return super.toString();
    }

    public BigDecimal getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(BigDecimal valorVenda) {
        this.valorVenda = valorVenda;
    }
    public BigDecimal getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(BigDecimal valorCompra) {
        this.valorCompra = valorCompra;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + Objects.hashCode(this.id);
        hash = 19 * hash + Objects.hashCode(this.produto);
        hash = 19 * hash + Objects.hashCode(this.quantidade);
        hash = 19 * hash + Objects.hashCode(this.valorVenda);
        hash = 19 * hash + Objects.hashCode(this.valorCompra);
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
        final PedidoItem other = (PedidoItem) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.produto, other.produto)) {
            return false;
        }
        if (!Objects.equals(this.quantidade, other.quantidade)) {
            return false;
        }
        if (!Objects.equals(this.valorVenda, other.valorVenda)) {
            return false;
        }
        if (!Objects.equals(this.valorCompra, other.valorCompra)) {
            return false;
        }
        return true;
    }


}
