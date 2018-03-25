package com.luismassaneiro.sistemadonai.model;

import com.luismassaneiro.sistemadonai.enums.TipoSituacaoProduto;
import com.luismassaneiro.sistemadonai.utils.DataUtil;
import java.math.BigDecimal;
import java.util.Date;
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

    @Column(name="PIT_VALOR", nullable=false)
    private BigDecimal valor;
    
    @Column(name="PIT_DATA", nullable=false)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dataCompra = new Date();
    
    @Column(name="PIT_OBSERVACAO")
    private String observacao;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "PIT_SITUACAO", nullable = false)
    private TipoSituacaoProduto tipoSituacaoProduto = TipoSituacaoProduto.EM_ABERTO;
    
    @Column(name="PIT_DATAPAGAMENTO")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dataPagamento = null;
    
    @ManyToOne
    @JoinColumn(name="PIT_PEDID",insertable = false, updatable = false)
    private Pedido pedido;
    
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

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Date getDataCompra() {
        return DataUtil.zeraHora(dataCompra);
    }

    public void setDataCompra(Date dataCompra) {
        this.dataCompra = DataUtil.zeraHora(dataCompra);
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public TipoSituacaoProduto getTipoSituacaoProduto() {
        return tipoSituacaoProduto;
    }

    public void setTipoSituacaoProduto(TipoSituacaoProduto tipoSituacaoProduto) {
        this.tipoSituacaoProduto = tipoSituacaoProduto;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

}
