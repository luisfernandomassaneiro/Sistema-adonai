package com.luismassaneiro.sistemadonai.controller;

import com.luismassaneiro.sistemadonai.model.CodigoBarra;
import com.luismassaneiro.sistemadonai.utils.TrataExcecao;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author matheus_peressoni
 */
public class CodigoBarraDAO extends GenericDAO<CodigoBarra> {
    
    public List<CodigoBarra> recuperaCodigoBarraDoProduto(Long produtoID) {
        try {
            
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("produtoID", produtoID);

            StringBuilder hql = new StringBuilder();
            hql.append("select c from CodigoBarra as c ");
            hql.append(" join c.produto p ");
            hql.append(" where ");
            hql.append(" p.id = :produtoID ");
            hql.append(" order by c.codigoBarras ");
            return list(hql.toString(), parameters);
        } catch (Exception e) {
            TrataExcecao.trataMensagemErro(e, GenericDAO.class);
        } 
        return null;
    }
        
}

