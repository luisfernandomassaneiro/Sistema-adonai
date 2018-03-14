package com.luismassaneiro.sistemadonai.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.Transient;

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
    
    @OneToOne
    @JoinColumn(name="PED_CLIID", nullable = false)
    private Cliente cliente;
    
    @Column(name="PED_DATA", nullable=false)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date data = new Date();
    
    @Column(name="PED_VALORTOTAL", nullable=false)
    private BigDecimal valorTotal = BigDecimal.ZERO;
    
    @Column(name="PED_VALORPAGO", nullable=false)
    private BigDecimal valorPago = BigDecimal.ZERO;
    
    @Column(name="PED_OBSERVACAO")
    private String observacao;
    
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

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Long getQuantidadeProdutos() {
        return quantidadeProdutos;
    }

    public void setQuantidadeProdutos(Long quantidadeProdutos) {
        this.quantidadeProdutos = quantidadeProdutos;
    }

    public Pedido(Date data, Long quantidadeProdutos, BigDecimal valorLucro) {
        this.quantidadeProdutos = quantidadeProdutos;
        this.data = data;
    }

    public Pedido() {
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

}
