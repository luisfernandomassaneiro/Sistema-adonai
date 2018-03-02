package com.luismassaneiro.controleestoque.controller;

import com.luismassaneiro.controleestoque.model.Categoria;
import com.luismassaneiro.controleestoque.utils.TrataExcecao;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang.StringUtils;

/**
 *
 * @author matheus_peressoni
 */
public class CategoriaDAO extends GenericDAO<Categoria> {
    public List<Categoria> listarCategoria(Long categoriaID) {
        try {
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("categoriaID", categoriaID);

            StringBuilder hql = new StringBuilder();
            hql.append("select distinct c from Categoria as c ");
            hql.append(" where ");
            hql.append(" c.ativo = 1 or c.id = :categoriaID ");
            hql.append(" order by c.descricao ");
            return list(hql.toString(), parameters);
        } catch (Exception e) {
            TrataExcecao.trataMensagemErro(e, GenericDAO.class);
            return null;
        }
    }
    
    public List<Categoria> listarCategoriasAtivas() {
        try {
            return list("select distinct c from Categoria as c where c.ativo = 1 order by c.descricao");
        } catch (Exception e) {
            TrataExcecao.trataMensagemErro(e, GenericDAO.class);
            return null;
        }
    }
    
    public List<Categoria> recuperaCategoriaComFiltros(String descricao, boolean somenteAtivo) {
        try {
            Map<String, Object> parameters = new HashMap<>();
            StringBuilder hql = new StringBuilder();
            
            hql.append("select c from Categoria as c ");
            if(StringUtils.isNotEmpty(descricao) || somenteAtivo) {
                hql.append(" where ");
                if(StringUtils.isNotEmpty(descricao)) {
                    hql.append(" c.descricao like :descricao ");
                    parameters.put("descricao", descricao);
                    hql.append(somenteAtivo ? " and " : "");
                }
                if(somenteAtivo) {
                    hql.append(" c.ativo = 1 ");
                }
            }

            hql.append("order by c.descricao");
            return list(hql.toString(), parameters);
        } catch (Exception e) {
            TrataExcecao.trataMensagemErro(e, GenericDAO.class);
            return null;
        } 
    }
}

