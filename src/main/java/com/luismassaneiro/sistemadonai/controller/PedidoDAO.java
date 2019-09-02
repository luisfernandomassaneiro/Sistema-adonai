package com.luismassaneiro.sistemadonai.controller;

import com.luismassaneiro.sistemadonai.exceptions.ValidateException;
import com.luismassaneiro.sistemadonai.model.Pedido;
import com.luismassaneiro.sistemadonai.utils.TrataExcecao;
import java.util.HashMap;
import java.util.Map;

public class PedidoDAO extends GenericDAO<Pedido>{

    public Pedido recuperaPedidoDoCliente(Long clienteID) throws ValidateException {
        try {
            Map<String, Object> parameters = new HashMap<>();
            StringBuilder hql = new StringBuilder();
            hql.append("select ped from Pedido as ped ");
            hql.append(" inner join fetch ped.itens pit ");
            hql.append(" inner join fetch pit.produto pro ");
            hql.append(" inner join fetch ped.cliente cli ");
            hql.append(" where cli.id = :clienteID ");
            parameters.put("clienteID", clienteID);
            hql.append(" and pit.tipoSituacaoProduto = 'EM_ABERTO' ");
            hql.append(" order by pit.dataCompra ");
            /*Pedido pedido = find(hql.toString(), parameters); 
            if(pedido != null && CollectionUtils.isNotEmpty(pedido.getItens())) {
                List<PedidoItem> itemPagoRemover = new ArrayList<>();
                for (PedidoItem umItem : pedido.getItens()) {
                    if(TipoSituacaoProduto.PAGO.equals(umItem.getTipoSituacaoProduto())) {
                        itemPagoRemover.add(umItem);
                    }
                }
                pedido.getItens().removeAll(itemPagoRemover);
            }*/
            return find(hql.toString(), parameters);
        } catch (Exception e) {
            String erro = TrataExcecao.trataMensagemErro(e, PedidoDAO.class);
            throw new ValidateException(erro);
        } 
    }
}
