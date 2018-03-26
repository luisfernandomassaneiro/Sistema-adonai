/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.luismassaneiro.sistemadonai.controller;

import com.luismassaneiro.sistemadonai.enums.TipoSituacaoProduto;
import com.luismassaneiro.sistemadonai.exceptions.ValidateException;
import com.luismassaneiro.sistemadonai.model.Pedido;
import com.luismassaneiro.sistemadonai.model.PedidoItem;
import com.luismassaneiro.sistemadonai.utils.TrataExcecao;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;

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
            Pedido pedido = find(hql.toString(), parameters); 
            if(pedido != null && CollectionUtils.isNotEmpty(pedido.getItens())) {
                List<PedidoItem> itemPagoRemover = new ArrayList<>();
                for (PedidoItem umItem : pedido.getItens()) {
                    if(TipoSituacaoProduto.PAGO.equals(umItem.getTipoSituacaoProduto())) {
                        itemPagoRemover.add(umItem);
                    }
                }
                pedido.getItens().removeAll(itemPagoRemover);
            }
            return pedido;
        } catch (Exception e) {
            String erro = TrataExcecao.trataMensagemErro(e, PedidoDAO.class);
            throw new ValidateException(erro);
        } 
    }
}
