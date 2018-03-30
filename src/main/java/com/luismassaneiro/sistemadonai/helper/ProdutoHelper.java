package com.luismassaneiro.sistemadonai.helper;

import com.luismassaneiro.sistemadonai.controller.DAOFactory;
import com.luismassaneiro.sistemadonai.controller.ProdutoDAO;
import com.luismassaneiro.sistemadonai.enums.MensagemFixas;
import com.luismassaneiro.sistemadonai.exceptions.ValidateException;
import com.luismassaneiro.sistemadonai.model.Produto;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang.StringUtils;

public class ProdutoHelper {
    private static ProdutoHelper instance;
    private final ProdutoDAO produtoDAO = DAOFactory.criaProdutoDAO();
    
    public static ProdutoHelper getInstance() {
        if(instance == null) {
            instance = new ProdutoHelper();
        }
        return instance;
    }
    
    public void validaCamposObrigatorios(Produto produto) throws ValidateException{
        Map<String, String> erros = new HashMap<>();
        
        if (produto == null) {
            erros.put("produto", "Formulário não pode estar vazio!");
        } else {
            if (StringUtils.isEmpty(produto.getCodigo())) 
                erros.put("código", "- Código.");

            if (StringUtils.isEmpty(produto.getDescricao())) 
                erros.put("descrição", "- Descrição.");

            if(produto.getValor() == null) 
                erros.put("valor", "- Valor.");
            
        }
        
        if (!erros.isEmpty())
            throw new ValidateException(erros, MensagemFixas.CAMPO_OBRIGATORIO);
        
    }
    
    public void validaDuplicidade(Produto produto) throws ValidateException {
        if(!produtoDAO.codigoProdutoDisponivel(produto.getCodigo(), produto.getId())) {
            throw new ValidateException("Código de produto informado já existe!", MensagemFixas.CAMPO_EXISTENTE);
        }
        
        if(!produtoDAO.descricaoProdutoDisponivel(produto.getDescricao(), produto.getId())) {
            throw new ValidateException("Descrição do produto informado já existe!", MensagemFixas.CAMPO_EXISTENTE);
        }
    }
    
}
