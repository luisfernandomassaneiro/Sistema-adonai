package com.luismassaneiro.sistemadonai.controller;

import com.luismassaneiro.sistemadonai.dto.InadimplenciaDTO;
import com.luismassaneiro.sistemadonai.exceptions.ValidateException;
import com.luismassaneiro.sistemadonai.model.Cliente;
import com.luismassaneiro.sistemadonai.utils.TrataExcecao;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang.StringUtils;

/**
 *
 * @author matheus_peressoni
 */
public class ClienteDAO extends GenericDAO<Cliente> {
    public List<Cliente> recuperaClientesComFiltros(String codigo, String nome, boolean somenteAtivo) throws ValidateException {
        try {
            Map<String, Object> parameters = new HashMap<>();
            StringBuilder hql = new StringBuilder();
            
            hql.append("select c from Cliente as c ");
            if(StringUtils.isNotEmpty(codigo) || StringUtils.isNotEmpty(nome) || somenteAtivo) {
                hql.append(" where ");
                if(StringUtils.isNotEmpty(codigo)) {
                    hql.append(" c.codigo like :codigo ");
                    parameters.put("codigo", codigo.concat("%"));
                    hql.append(StringUtils.isNotEmpty(nome) || somenteAtivo ? " and " : "");
                }
                if(StringUtils.isNotEmpty(nome)) {
                    hql.append(" c.nome like :nome ");
                    parameters.put("nome", nome);
                    hql.append(somenteAtivo ? " and " : "");
                }
                if(somenteAtivo) {
                    hql.append(" c.ativo = 1 ");
                }
            }
            hql.append(" order by c.nome ");
            return list(hql.toString(), parameters);
        } catch (Exception e) {
            String erro = TrataExcecao.trataMensagemErro(e, ClienteDAO.class);
            throw new ValidateException(erro);
        } 
    }
    
    public Cliente recuperaClientePeloCodigo (String codigo) throws ValidateException {
        try {
            Map<String, Object> parameters = new HashMap<>();
            StringBuilder hql = new StringBuilder();
            
            hql.append("select c from Cliente as c ");
            hql.append(" where c.ativo = 1 ");
            hql.append(" and c.codigo = :codigo ");
            parameters.put("codigo", codigo);
            return find(hql.toString(), parameters);
        } catch (Exception e) {
            String erro = TrataExcecao.trataMensagemErro(e, ClienteDAO.class);
            throw new ValidateException(erro);
        } 
    }
    
     public boolean codigoClienteDisponivel(String codigo, Long clienteID) throws ValidateException {
        try {
            Map<String, Object> parameters = new HashMap<>();
            StringBuilder hql = new StringBuilder();
            hql.append("select count(c.id) from Cliente as c ");
            hql.append(" where ");
            hql.append(" c.codigo = :codigo ");
            parameters.put("codigo", codigo);
            if(clienteID != null) {
                hql.append(" and c.id <> :clienteID ");
                parameters.put("clienteID", clienteID);
            }
            Long count = find(hql.toString(), parameters);
            return count == 0;
        } catch (Exception e) {
            String erro = TrataExcecao.trataMensagemErro(e, ProdutoDAO.class);
            throw new ValidateException(erro);
        } 
    }
     
     public List<InadimplenciaDTO> recuperaInadimplentes(String codigo, String nome, Date dataInicial, Date dataFinal) throws ValidateException {
        try {
            Map<String, Integer> mapParametros = new HashMap<>();
            StringBuilder hql = new StringBuilder();
            hql.append("SELECT ");
            hql.append("CLI_CODIGO AS CODIGO, ");
            hql.append("CLI_NOME AS NOME, ");
            hql.append("SUM(PIT_VALOR) AS VALOR_DEVIDO ");
            hql.append("FROM 	TB_PEDIDO ");
            hql.append("INNER JOIN TB_PEDIDO_ITEM ON PIT_PEDID = PED_ID ");
            hql.append("INNER JOIN TB_CLIENTE ON CLI_ID = PED_CLIID ");
            hql.append("WHERE ");
            hql.append("PIT_SITUACAO= 'EM_ABERTO' ");
            int countParametros = 1;
            if(dataInicial != null) {
                hql.append(" AND CAST(PED_DATA AS DATE) >= ? ");
                mapParametros.put("dataInicial", countParametros++);
            }
            if(dataFinal != null) {
                hql.append(" AND CAST(PED_DATA AS DATE) <= ? ");
                mapParametros.put("dataFinal", countParametros++);
            }
            if(StringUtils.isNotBlank(codigo)) {
                hql.append(" AND CLI_CODIGO = ? ");
                mapParametros.put("codigo", countParametros++);
            }
            if(StringUtils.isNotBlank(nome)) {
                hql.append(" AND CLI_NOME LIKE '").append(nome).append("%' ");
            }
            
            hql.append("GROUP BY CLI_CODIGO, CLI_NOME ");
            hql.append("ORDER BY CLI_NOME ");	
            
            Connection conn = null;
            PreparedStatement ps = null;
            List<InadimplenciaDTO> lInadimplentes = new ArrayList<>();
            try {
                conn = getConnection();
                ps = conn.prepareStatement(hql.toString());
                if(dataInicial != null) {
                    ps.setDate(mapParametros.get("dataInicial"), new java.sql.Date(dataInicial.getTime()));
                }
                if(dataFinal != null) {
                    ps.setDate(mapParametros.get("dataFinal"), new java.sql.Date(dataFinal.getTime()));
                }
                if(StringUtils.isNotBlank(codigo)) {
                    ps.setString(mapParametros.get("codigo"), codigo);
                }
                
                ResultSet rs = ps.executeQuery();
                InadimplenciaDTO umInadimplente;
                while (rs.next()) {
                    String codigoCliente = rs.getString(1);
                    String nomeCliente = rs.getString(2);
                    Double valorDevido = rs.getDouble(3);
                    umInadimplente = new InadimplenciaDTO();
                    umInadimplente.setCodigoCliente(codigoCliente);
                    umInadimplente.setNomeCliente(nomeCliente);
                    umInadimplente.setValorTotalDevido(new BigDecimal(valorDevido));
                    lInadimplentes.add(umInadimplente);
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
            return lInadimplentes;
        } catch (Exception e) {
            String erro = TrataExcecao.trataMensagemErro(e, PedidoDAO.class);
            throw new ValidateException(erro);
        } 
    }
}

