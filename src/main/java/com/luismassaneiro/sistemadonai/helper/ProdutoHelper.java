/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.luismassaneiro.sistemadonai.helper;

import com.luismassaneiro.sistemadonai.controller.DAOFactory;
import com.luismassaneiro.sistemadonai.controller.MovimentoEstoqueDAO;
import com.luismassaneiro.sistemadonai.controller.ProdutoDAO;
import com.luismassaneiro.sistemadonai.enums.MensagemFixas;
import com.luismassaneiro.sistemadonai.enums.TipoMovimentacao;
import com.luismassaneiro.sistemadonai.exceptions.ValidateException;
import com.luismassaneiro.sistemadonai.model.MovimentoEstoque;
import com.luismassaneiro.sistemadonai.model.Produto;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang.StringUtils;

/**
 *
 * @author Nando
 */
public class ProdutoHelper {
    private static ProdutoHelper instance;
    private static final ProdutoDAO produtoDAO = DAOFactory.criaProdutoDAO();
    
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
    
    public void verificaQuantidadeEmEstoque(Produto produto, Integer quantidadeRetirar) throws ValidateException {
        if(produto != null && produto.getId() != null) {
            //Recupera a quantidade atual do banco, para ter certeza 
            Integer quantidadeAtualizada = produtoDAO.recuperaQuantidadeAtualizada(produto.getId());
            if(quantidadeAtualizada != null && quantidadeRetirar > quantidadeAtualizada) {
                StringBuilder mensagemExcecao = new StringBuilder();
                mensagemExcecao.append("Quantidade informada não disponível em estoque!");
                mensagemExcecao.append("\nQuantidade disponível até o momento: ");
                mensagemExcecao.append(quantidadeAtualizada.toString());
                throw new ValidateException(mensagemExcecao.toString(), MensagemFixas.QUANTIDADE_INDISPONIVEL);
            }
        }
    }
    
    public void atualizaQuantidadeAtual(Produto produto, Integer quantidade, boolean isEntrada) throws ValidateException {
        if(produto != null && produto.getId() != null) {
        }
    }
    
    public void validaDuplicidadeCodigoBarras(String codigoBarra, Long produtoID, Long codigoBarraID) throws ValidateException {
        if(!produtoDAO.codigoBarrasProdutoDisponivel(codigoBarra, produtoID, codigoBarraID)) 
            throw new ValidateException("Código de barras informado já existe!", MensagemFixas.CAMPO_EXISTENTE);
        
        Produto produto = produtoDAO.recuperaProdutoPeloCodigoBarras(codigoBarra);
        if(produto != null) {
            StringBuilder mensagem = new StringBuilder();
            mensagem.append("Código de barras informado já utilizado pelo produto: ");
            mensagem.append(produto.getCodigo()).append(" - ").append(produto.getDescricao());
            throw new ValidateException(mensagem.toString(), MensagemFixas.CAMPO_EXISTENTE);
        }
    }
}
