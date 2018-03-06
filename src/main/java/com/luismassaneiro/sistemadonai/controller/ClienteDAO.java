package com.luismassaneiro.sistemadonai.controller;

import com.luismassaneiro.sistemadonai.exceptions.ValidateException;
import com.luismassaneiro.sistemadonai.model.Cliente;
import com.luismassaneiro.sistemadonai.model.Produto;
import com.luismassaneiro.sistemadonai.utils.TrataExcecao;
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
    
    public Produto recuperaClientePeloCodigo (String codigo) throws ValidateException {
        try {
            Map<String, Object> parameters = new HashMap<>();
            StringBuilder hql = new StringBuilder();
            
            hql.append("select c from Cliente as c ");
            hql.append(" where ");
            hql.append(" c.codigo = :codigo ");
            parameters.put("codigo", codigo);
            return find(hql.toString(), parameters);
        } catch (Exception e) {
            String erro = TrataExcecao.trataMensagemErro(e, ClienteDAO.class);
            throw new ValidateException(erro);
        } 
    }
    
     public boolean codigoClienteDisponivel(String codigo) throws ValidateException {
        try {
            Map<String, Object> parameters = new HashMap<>();
            StringBuilder hql = new StringBuilder();
            hql.append("select count(c.id) from Cliente as c ");
            hql.append(" where ");
            hql.append(" c.codigo = :c ");
            parameters.put("codigo", codigo);
            Long count = find(hql.toString(), parameters);
            return count == 0;
        } catch (Exception e) {
            String erro = TrataExcecao.trataMensagemErro(e, ProdutoDAO.class);
            throw new ValidateException(erro);
        } 
    }
}

