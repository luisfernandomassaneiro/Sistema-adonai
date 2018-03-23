/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.luismassaneiro.sistemadonai.controller;

import com.luismassaneiro.sistemadonai.exceptions.ValidateException;
import com.luismassaneiro.sistemadonai.model.Pedido;
import com.luismassaneiro.sistemadonai.model.PedidoItem;
import com.luismassaneiro.sistemadonai.utils.TrataExcecao;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Redes
 */
public class PedidoDAO extends GenericDAO<Pedido>{

    public Pedido recuperaPedidoDoCliente(Long clienteID) throws ValidateException {
        try {
            Map<String, Object> parameters = new HashMap<>();
            StringBuilder hql = new StringBuilder();
            hql.append("select ped from Pedido as ped ");
            hql.append(" inner join ped.itens pit ");
            hql.append(" inner join pit.produto pro ");
            hql.append(" inner join ped.cliente cli ");
            hql.append(" where cli.id = :clienteID ");
            parameters.put("clienteID", clienteID);
            hql.append(" order by pit.dataCompra ");
            return find(hql.toString(), parameters);
        } catch (Exception e) {
            String erro = TrataExcecao.trataMensagemErro(e, PedidoDAO.class);
            throw new ValidateException(erro);
        } 
    }
    
    
public List<PedidoItem> recuperaPedidosParaPagamento(String codigo, String nome, Date dataInicial, Date dataFinal) throws ValidateException {
    try {
        Map<String, Object> parameters = new HashMap<>();
        StringBuilder hql = new StringBuilder();
        hql.append("select ped from Pedido as ped ");
        hql.append(" inner join ped.itens pit ");
        hql.append(" inner join pit.produto pro ");
        hql.append(" inner join ped.cliente cli ");
        hql.append(" where pit.tipoSituacaoProduto = 'EM_ABERTO' ");
        
        if(codigo != null ) {
            hql.append(" and cli.codigo = :codigo");
            parameters.put("codigo", codigo);
        }
        if(nome != null) {
            hql.append(" cli.nome like :nome ");
            parameters.put("nome", nome.concat("%"));
        }
        if(dataInicial != null) {
            hql.append(" pit.dataCompra >= :dataInicial ");
            parameters.put("dataInicial", dataInicial);
        }
        if(dataFinal != null) {
            hql.append(" pit.dataCompra <= :dataFinal ");
            parameters.put("dataInicial", dataFinal);
        }
        
        hql.append(" order by pit.dataCompra ");
        
        List<Pedido> listaPedido = list(hql.toString(), parameters); 
        return null;
    } catch (Exception e) {
        String erro = TrataExcecao.trataMensagemErro(e, PedidoDAO.class);
        throw new ValidateException(erro);
    } 
    }    
}
