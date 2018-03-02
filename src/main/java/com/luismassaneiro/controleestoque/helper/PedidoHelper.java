/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.luismassaneiro.controleestoque.helper;

import com.luismassaneiro.controleestoque.controller.DAOFactory;
import com.luismassaneiro.controleestoque.controller.PedidoDAO;
import com.luismassaneiro.controleestoque.exceptions.ValidateException;
import com.luismassaneiro.controleestoque.model.Pedido;
import com.luismassaneiro.controleestoque.model.PedidoItem;
import com.luismassaneiro.controleestoque.utils.TrataExcecao;
import org.apache.commons.collections.CollectionUtils;

/**
 *
 * @author Aluno
 */
public class PedidoHelper {
 
    private static final PedidoDAO pedidoDAO = DAOFactory.criaPedidoDAO();
    
    public static void cancelaPedido(Pedido pedido) throws ValidateException {
        try {
            if(CollectionUtils.isNotEmpty(pedido.getItens())) {
                for (PedidoItem umItem : pedido.getItens()) {
                    ProdutoHelper.getInstance().atualizaQuantidadeAtual(umItem.getProduto(), umItem.getQuantidade(), true);
                }
            }
            pedidoDAO.excluir(pedido);
        } catch (Exception e) {
            String erro = TrataExcecao.trataMensagemErro(e, PedidoHelper.class);
            throw new ValidateException(erro);
        }
    }
}
