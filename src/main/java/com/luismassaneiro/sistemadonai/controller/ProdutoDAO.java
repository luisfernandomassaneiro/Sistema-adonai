package com.luismassaneiro.sistemadonai.controller;

import com.luismassaneiro.sistemadonai.exceptions.ValidateException;
import com.luismassaneiro.sistemadonai.model.Produto;
import com.luismassaneiro.sistemadonai.utils.TrataExcecao;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang.StringUtils;

public class ProdutoDAO extends GenericDAO<Produto> {

    private List<Produto> listaProduto;
    
    public List<Produto> recuperaProdutoComFiltros(String codigo, String descricao, boolean somenteAtivo) throws ValidateException {
        try {
            Map<String, Object> parameters = new HashMap<>();
            StringBuilder hql = new StringBuilder();
            
            hql.append("select p from Produto as p ");
            if(StringUtils.isNotEmpty(codigo) || StringUtils.isNotEmpty(descricao) || somenteAtivo) {
                hql.append(" where ");
                if(StringUtils.isNotEmpty(codigo)) {
                    hql.append(" p.codigo like :codigo ");
                    parameters.put("codigo", codigo);
                    hql.append(StringUtils.isNotEmpty(descricao) || somenteAtivo ? " and " : "");
                }
                if(StringUtils.isNotEmpty(descricao)) {
                    hql.append(" p.descricao like :descricao ");
                    parameters.put("descricao", descricao);
                    hql.append(somenteAtivo ? " and " : "");
                }
                if(somenteAtivo) {
                    hql.append(" p.ativo = 1 ");
                }
            }
            hql.append(" order by p.descricao ");
            return list(hql.toString(), parameters);
        } catch (Exception e) {
            String erro = TrataExcecao.trataMensagemErro(e, ProdutoDAO.class);
            throw new ValidateException(erro);
        } 
    }
    
    public Produto recuperaProdutoPeloCodigo (String codigo) throws ValidateException {
        try {
            Map<String, Object> parameters = new HashMap<>();
            StringBuilder hql = new StringBuilder();
            
            hql.append("select p from Produto as p ");
            hql.append(" where p.ativo = 1 ");
            hql.append(" and p.codigo = :codigo ");
            parameters.put("codigo", codigo);
            return find(hql.toString(), parameters);
        } catch (Exception e) {
            String erro = TrataExcecao.trataMensagemErro(e, ProdutoDAO.class);
            throw new ValidateException(erro);
        } 
    }
    
    public boolean codigoProdutoDisponivel(String codigo, Long produtoID) throws ValidateException {
        try {
            Map<String, Object> parameters = new HashMap<>();
            StringBuilder hql = new StringBuilder();
            hql.append("select count(p.id) from Produto as p ");
            hql.append(" where ");
            hql.append(" p.codigo = :codigo ");
            parameters.put("codigo", codigo);
            if(produtoID != null) {
                hql.append(" and p.id not in (:produtoID) ");
                parameters.put("produtoID", produtoID);
            }

            Long count = find(hql.toString(), parameters);
            return count == 0;
        } catch (Exception e) {
            String erro = TrataExcecao.trataMensagemErro(e, ProdutoDAO.class);
            throw new ValidateException(erro);
        } 
    }
    
    public boolean descricaoProdutoDisponivel(String descricao, Long produtoID) throws ValidateException {
        try {
            Map<String, Object> parameters = new HashMap<>();
            StringBuilder hql = new StringBuilder();
            hql.append("select count(p.id) from Produto as p ");
            hql.append(" where ");
            hql.append(" p.descricao = :descricao ");
            parameters.put("descricao", descricao);
            if(produtoID != null) {
                hql.append(" and p.id not in (:produtoID) ");
                parameters.put("produtoID", produtoID);
            }

            Long count = find(hql.toString(), parameters);
            return count == 0;
        } catch (Exception e) {
            String erro = TrataExcecao.trataMensagemErro(e, ProdutoDAO.class);
            throw new ValidateException(erro);
        } 
    }
    
    /**
     * Recupera a quantidade atualizada do produto.
     * Quantidade atual - quantidade reservada
     * @param produtoID
     * @return 
     */
    public Integer recuperaQuantidadeAtualizada(Long produtoID) throws ValidateException {
        try {
            Map<String, Object> parameters = new HashMap<>();
            StringBuilder hql = new StringBuilder();
            hql.append("select p.qtdeAtual from Produto as p ");
            hql.append(" where ");
            hql.append(" p.id = :produtoID ");

            parameters.put("produtoID", produtoID);
            Integer qntde = find(hql.toString(), parameters);
            return qntde;
        } catch (Exception e) {
            String erro = TrataExcecao.trataMensagemErro(e, ProdutoDAO.class);
            throw new ValidateException(erro);
        } 
    }
    
    public boolean codigoBarrasProdutoDisponivel(String codigoBarras, Long produtoID, Long codigoBarraID) throws ValidateException {
        try {
            Map<String, Object> parameters = new HashMap<>();
            StringBuilder hql = new StringBuilder();
            hql.append("select count(c.id) from CodigoBarra as c ");
            hql.append("join c.produto p");
            hql.append(" where ");
            hql.append(" c.codigoBarras = :codigoBarras ");
            hql.append(" and p.id = :produtoID ");
            if(codigoBarraID != null) {
                hql.append(" and c.id not in (:codigoBarraID) ");
                parameters.put("codigoBarraID", codigoBarraID);
            }

            parameters.put("codigoBarras", codigoBarras);
            parameters.put("produtoID", produtoID);
            Long count = find(hql.toString(), parameters);
            return count == 0;
        } catch (Exception e) {
            String erro = TrataExcecao.trataMensagemErro(e, ProdutoDAO.class);
            throw new ValidateException(erro);
        } 
    }

}