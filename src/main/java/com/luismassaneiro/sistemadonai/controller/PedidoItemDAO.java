package com.luismassaneiro.sistemadonai.controller;

import com.luismassaneiro.sistemadonai.exceptions.ValidateException;
import com.luismassaneiro.sistemadonai.model.PedidoItem;
import com.luismassaneiro.sistemadonai.utils.DataUtil;
import com.luismassaneiro.sistemadonai.utils.TrataExcecao;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang.StringUtils;

public class PedidoItemDAO extends GenericDAO<PedidoItem>{

    public List<PedidoItem> recuperaPedidosParaPagamento(String codigo, String nome, Date dataInicial, Date dataFinal) throws ValidateException {
        try {
            Map<String, Object> parameters = new HashMap<>();
            StringBuilder hql = new StringBuilder();
            hql.append("select pit from PedidoItem as pit ");
            hql.append(" inner join pit.pedido ped ");
            hql.append(" inner join pit.produto pro ");
            hql.append(" inner join ped.cliente cli ");
            hql.append(" where pit.tipoSituacaoProduto = 'EM_ABERTO' ");

            if(StringUtils.isNotBlank(codigo)) {
                hql.append(" and cli.codigo = :codigo");
                parameters.put("codigo", codigo);
            }
            if(StringUtils.isNotBlank(nome)) {
                hql.append(" and cli.nome like :nome ");
                parameters.put("nome", nome.concat("%"));
            }
            if(dataInicial != null) {
                hql.append(" and pit.dataCompra >= :dataInicial ");
                parameters.put("dataInicial", DataUtil.zeraHora(dataInicial));
            }
            if(dataFinal != null) {
                hql.append(" and pit.dataCompra <= :dataFinal ");
                parameters.put("dataFinal", DataUtil.zeraHora(dataFinal));
            }

            hql.append(" order by pit.dataCompra ");
            List<PedidoItem> itens = list(hql.toString(), parameters);
            return itens;
        } catch (Exception e) {
            String erro = TrataExcecao.trataMensagemErro(e, PedidoDAO.class);
            throw new ValidateException(erro);
        } 
    }

    public List<PedidoItem> recuperaConsultaDetalhada(Long clienteID, Date dataInicial, Date dataFinal, String situacaoPagamento) throws ValidateException {
        try {
            Map<String, Object> parameters = new HashMap<>();
            StringBuilder hql = new StringBuilder();
            hql.append("select pit from PedidoItem as pit ");
            hql.append(" inner join pit.pedido ped ");
            hql.append(" inner join pit.produto pro ");
            hql.append(" inner join ped.cliente cli ");
            hql.append(" where cli.id = :clienteID ");
            parameters.put("clienteID", clienteID);
            
            if(StringUtils.isNotBlank(situacaoPagamento)) {
                if(situacaoPagamento.contains("Em aberto"))
                    hql.append(" and pit.tipoSituacaoProduto = 'EM_ABERTO'");
                
                if(situacaoPagamento.contains("Pago"))
                    hql.append(" and pit.tipoSituacaoProduto = 'PAGO'");
                
            }
            
            if(dataInicial != null) {
                hql.append(" and pit.dataCompra >= :dataInicial ");
                parameters.put("dataInicial", DataUtil.zeraHora(dataInicial));
            }
            if(dataFinal != null) {
                hql.append(" and pit.dataCompra <= :dataFinal ");
                parameters.put("dataFinal", DataUtil.zeraHora(dataFinal));
            }

            hql.append(" order by pit.dataCompra ");
            List<PedidoItem> itens = list(hql.toString(), parameters);
            return itens;
        } catch (Exception e) {
            String erro = TrataExcecao.trataMensagemErro(e, PedidoDAO.class);
            throw new ValidateException(erro);
        } 
    }    
}
