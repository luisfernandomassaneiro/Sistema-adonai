/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.luismassaneiro.sistemadonai.helper;

import com.luismassaneiro.sistemadonai.controller.DAOFactory;
import com.luismassaneiro.sistemadonai.controller.PedidoDAO;
import com.luismassaneiro.sistemadonai.exceptions.ValidateException;
import com.luismassaneiro.sistemadonai.model.Pedido;
import com.luismassaneiro.sistemadonai.model.PedidoItem;
import com.luismassaneiro.sistemadonai.utils.TrataExcecao;
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
                }
            }
            pedidoDAO.excluir(pedido);
        } catch (Exception e) {
            String erro = TrataExcecao.trataMensagemErro(e, PedidoHelper.class);
            throw new ValidateException(erro);
        }
    }
}
