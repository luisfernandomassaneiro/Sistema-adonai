/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.luismassaneiro.sistemadonai.controller;

import com.luismassaneiro.sistemadonai.exceptions.ValidateException;
import com.luismassaneiro.sistemadonai.model.Pedido;
import com.luismassaneiro.sistemadonai.utils.TrataExcecao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Redes
 */
public class PedidoDAO extends GenericDAO<Pedido>{

    public List<Pedido> recuperaPedidoNaoFinalizados() throws ValidateException {
        try {
            StringBuilder hql = new StringBuilder();
            hql.append("select distinct ped from Pedido as ped ");
            hql.append("join ped.itens pit ");
            hql.append("join pit.produto pro ");
            hql.append(" where ped.pedidoFinalizado = 0 ");
            hql.append(" order by ped.data ");
            return list(hql.toString());
        } catch (Exception e) {
            String erro = TrataExcecao.trataMensagemErro(e, PedidoDAO.class);
            throw new ValidateException(erro);
        } 
    }
    
    public List<Pedido> recuperaVendas(Date dataInicial, Date dataFinal) throws ValidateException {
        try {
            StringBuilder hql = new StringBuilder();
            hql.append("SELECT ");
            hql.append("CAST(PED_DATA AS DATE) AS DATA, ");
            hql.append("SUM(PIT_QNTDE) AS QTDE, ");
            hql.append("SUM(DISTINCT PED_VALORLUCRO) AS LUCRO ");
            hql.append("FROM 	TB_PEDIDO ");
            hql.append("INNER JOIN TB_PEDIDO_ITEM ON PIT_PEDID = PED_ID ");
            hql.append("INNER JOIN TB_PRODUTO ON PRO_ID = PIT_PROID ");
            hql.append("WHERE ");
            hql.append("PED_FINALIZADO=1 ");
            if(dataInicial != null && dataFinal != null) {
                hql.append(" AND CAST(PED_DATA AS DATE) >= ? ");
                hql.append(" AND CAST(PED_DATA AS DATE) <= ? ");
            }
            
            hql.append("GROUP BY CAST(PED_DATA AS DATE) ");
            hql.append("ORDER BY DATA ");	
            
            Connection conn = null;
            PreparedStatement ps = null;
            List<Pedido> lPedidos = new ArrayList<>();
            try {
                conn = getConnection();
                ps = conn.prepareStatement(hql.toString());
                if(dataInicial != null && dataFinal != null) {
                    ps.setDate(1, new java.sql.Date(dataInicial.getTime()));
                    ps.setDate(2, new java.sql.Date(dataFinal.getTime()));
                }
                ResultSet rs = ps.executeQuery();
                Pedido umPedido = null;
                while (rs.next()) {
                    Date data = rs.getDate(1);
                    Long qtde = rs.getLong(2);
                    Double valorLucro = rs.getDouble(3);
                    umPedido = new Pedido();
                    umPedido.setData(data);
                    umPedido.setQuantidadeProdutos(qtde);
//                    umPedido.setValorLucro(new BigDecimal(valorLucro));
                    lPedidos.add(umPedido);
                }
                
            } catch(SQLException e) {
                String erro = TrataExcecao.trataMensagemErro(e, PedidoDAO.class);
                throw new ValidateException(erro);
            } finally {
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            }
            return lPedidos;
        } catch (Exception e) {
            String erro = TrataExcecao.trataMensagemErro(e, PedidoDAO.class);
            throw new ValidateException(erro);
        }
    }
    
    public Pedido recuperaPedidoDoCliente(Long clienteID) throws ValidateException {
        try {
            Map<String, Object> parameters = new HashMap<>();
            StringBuilder hql = new StringBuilder();
            hql.append("select ped, pit, pro, cli from Pedido as ped ");
            hql.append(" inner join ped.itens pit ");
            hql.append(" inner join pit.produto pro ");
            hql.append(" inner join ped.cliente cli ");
            hql.append(" where cli.id = :clienteID ");
            parameters.put("clienteID", clienteID);
            hql.append(" order by ped.data ");
            Pedido p = find(hql.toString(), parameters);
            return null;
        } catch (Exception e) {
            String erro = TrataExcecao.trataMensagemErro(e, PedidoDAO.class);
            throw new ValidateException(erro);
        } 

    }  
}
