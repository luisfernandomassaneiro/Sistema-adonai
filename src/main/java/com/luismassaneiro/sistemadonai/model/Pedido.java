package com.luismassaneiro.sistemadonai.model;

import com.luismassaneiro.sistemadonai.enums.TipoFormaPagamento;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.Transient;
import org.hibernate.annotations.Type;

/**
 *
 * @author luiz_f_massaneiro
 */
@Entity
@Table(name="TB_PEDIDO")
public class Pedido implements BusinessEntity{

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="PED_ID")
    private Long id;
    
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JoinColumn(name="PIT_PEDID", nullable=false)
    private List<PedidoItem> itens;
    
    @Column(name="PED_DATA", nullable=false)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date data = new Date();
    
    @Column(name="PED_VALORTOTAL", nullable=false)
    private BigDecimal valorTotal = BigDecimal.ZERO;
    
    @Column(name="PED_VALORPAGO", nullable=false)
    private BigDecimal valorPago = BigDecimal.ZERO;
    
    @Column(name="PED_VALORDESC")
    private BigDecimal valorDesconto;

    @Column(name="PED_VALORACR")
    private BigDecimal valorAcrescimo;
    
    @Column(name="PED_TROCO")
    private BigDecimal valorTroco;

    @Column(name="PED_OBSERVACAO")
    private String observacao;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "PED_FORMAPAG", nullable = false)
    private TipoFormaPagamento tipoFormaPagamento = TipoFormaPagamento.DINHEIRO;
    
    @Column(name="PED_VALORLUCRO")
    private BigDecimal valorLucro;
    
    @Type(type = "org.hibernate.type.NumericBooleanType") 
    @Column(name="PED_FINALIZADO")
    private boolean pedidoFinalizado = false;
    
    @Transient
    private Long quantidadeProdutos;
    
    @Override
    public Long getId() {
        return id;
    }

    public List<PedidoItem> getItens() {
        return itens;
    }

    public Date getData() {
        return data;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public BigDecimal getValorPago() {
        return valorPago;
    }

    public BigDecimal getValorDesconto() {
        return valorDesconto;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setItens(List<PedidoItem> itens) {
        this.itens = itens;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public void setValorPago(BigDecimal valorPago) {
        this.valorPago = valorPago;
    }

    public void setValorDesconto(BigDecimal valorDesconto) {
        this.valorDesconto = valorDesconto;
    }

    public TipoFormaPagamento getTipoFormaPagamento() {
        return tipoFormaPagamento;
    }

    public void setTipoFormaPagamento(TipoFormaPagamento tipoFormaPagamento) {
        this.tipoFormaPagamento = tipoFormaPagamento;
    }

    public BigDecimal getValorAcrescimo() {
        return valorAcrescimo;
    }

    public void setValorAcrescimo(BigDecimal valorAcrescimo) {
        this.valorAcrescimo = valorAcrescimo;
    }

    public BigDecimal getValorTroco() {
        return valorTroco;
    }

    public void setValorTroco(BigDecimal valorTroco) {
        this.valorTroco = valorTroco;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public BigDecimal getValorLucro() {
        return valorLucro;
    }

    public void setValorLucro(BigDecimal valorLucro) {
        this.valorLucro = valorLucro;
    }

    public boolean isPedidoFinalizado() {
        return pedidoFinalizado;
    }

    public void setPedidoFinalizado(boolean pedidoFinalizado) {
        this.pedidoFinalizado = pedidoFinalizado;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.id);
        hash = 97 * hash + Objects.hashCode(this.itens);
        hash = 97 * hash + Objects.hashCode(this.data);
        hash = 97 * hash + Objects.hashCode(this.valorTotal);
        hash = 97 * hash + Objects.hashCode(this.valorPago);
        hash = 97 * hash + Objects.hashCode(this.valorDesconto);
        hash = 97 * hash + Objects.hashCode(this.valorAcrescimo);
        hash = 97 * hash + Objects.hashCode(this.valorTroco);
        hash = 97 * hash + Objects.hashCode(this.observacao);
        hash = 97 * hash + Objects.hashCode(this.tipoFormaPagamento);
        hash = 97 * hash + Objects.hashCode(this.valorLucro);
        hash = 97 * hash + (this.pedidoFinalizado ? 1 : 0);
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
        final Pedido other = (Pedido) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.itens, other.itens)) {
            return false;
        }
        if (!Objects.equals(this.data, other.data)) {
            return false;
        }
        if (!Objects.equals(this.valorTotal, other.valorTotal)) {
            return false;
        }
        if (!Objects.equals(this.valorPago, other.valorPago)) {
            return false;
        }
        if (!Objects.equals(this.valorDesconto, other.valorDesconto)) {
            return false;
        }
        if (!Objects.equals(this.valorAcrescimo, other.valorAcrescimo)) {
            return false;
        }
        if (!Objects.equals(this.valorTroco, other.valorTroco)) {
            return false;
        }
        if (!Objects.equals(this.observacao, other.observacao)) {
            return false;
        }
        if (this.tipoFormaPagamento != other.tipoFormaPagamento) {
            return false;
        }
        if (!Objects.equals(this.valorLucro, other.valorLucro)) {
            return false;
        }
        if (this.pedidoFinalizado != other.pedidoFinalizado) {
            return false;
        }
        return true;
    }

    public Long getQuantidadeProdutos() {
        return quantidadeProdutos;
    }

    public void setQuantidadeProdutos(Long quantidadeProdutos) {
        this.quantidadeProdutos = quantidadeProdutos;
    }

    public Pedido(Date data, Long quantidadeProdutos, BigDecimal valorLucro) {
        this.valorLucro = valorLucro;
        this.quantidadeProdutos = quantidadeProdutos;
        this.data = data;
    }

    public Pedido() {
    }

}
