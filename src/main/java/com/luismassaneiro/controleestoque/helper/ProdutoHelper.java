/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.luismassaneiro.controleestoque.helper;

import com.luismassaneiro.controleestoque.controller.DAOFactory;
import com.luismassaneiro.controleestoque.controller.MovimentoEstoqueDAO;
import com.luismassaneiro.controleestoque.controller.ProdutoDAO;
import com.luismassaneiro.controleestoque.enums.MensagemFixas;
import com.luismassaneiro.controleestoque.enums.TipoMovimentacao;
import com.luismassaneiro.controleestoque.exceptions.ValidateException;
import com.luismassaneiro.controleestoque.model.MovimentoEstoque;
import com.luismassaneiro.controleestoque.model.Produto;
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

            if (produto.getCategoria() == null) 
                erros.put("categoria", "- Categoria.");
            
            if(produto.getValorCompra() == null) 
                erros.put("valorCompra", "- Valor de compra.");
            
            if(produto.getValorVenda() == null) 
                erros.put("valorVenda", "- Valor de venda.");
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
            if(produto.getEstoque() != null) {
                MovimentoEstoque movimentoEstoque = new MovimentoEstoque();
                movimentoEstoque.setProduto(produto);
                movimentoEstoque.setQuantidade(quantidade);
                Integer qtdeAtual = produto.getEstoque().getQtdeAtual() != null ? produto.getEstoque().getQtdeAtual() : 0;
                //Caso for cancelamento de pedido, devolvo o produto para o estoque
                if(isEntrada) {
                    movimentoEstoque.setTipoMovimentacao(TipoMovimentacao.ENTRADA);
                    qtdeAtual += quantidade;
                } else {
                    movimentoEstoque.setTipoMovimentacao(TipoMovimentacao.SAIDA);
                    qtdeAtual -= quantidade;
                }
                produto.getEstoque().setQtdeAtual(qtdeAtual);
                produtoDAO.atualizar(produto);
                MovimentoEstoqueDAO movimentoDAO = DAOFactory.criaMovimentoEstoqueDAO();
                movimentoDAO.atualizar(movimentoEstoque);
            }
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
