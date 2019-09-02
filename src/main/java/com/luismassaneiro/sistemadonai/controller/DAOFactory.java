package com.luismassaneiro.sistemadonai.controller;

/**
 *
 * @author luiz_f_massaneiro
 */
public class DAOFactory {
    private static ProdutoDAO produtoDAO;
    private static PedidoDAO pedidoDAO;
    private static PedidoItemDAO pedidoItemDAO;
    private static ClienteDAO clienteDAO;
    private static MovimentoEstoqueDAO movimentoEstoqueDAO;
    
    public static ClienteDAO criaClienteDAO() {
        if(clienteDAO == null)
            clienteDAO = new ClienteDAO();
        
        return clienteDAO;
    }
    
    public static ProdutoDAO criaProdutoDAO() {
        if(produtoDAO == null) {
            produtoDAO = new ProdutoDAO();
        }
        return produtoDAO;
    }
    
    public static PedidoDAO criaPedidoDAO() {
        if(pedidoDAO == null) {
            pedidoDAO = new PedidoDAO();
        }
        return pedidoDAO;
    }
    
    public static PedidoItemDAO criaPedidoItemDAO() {
        if(pedidoItemDAO == null) {
            pedidoItemDAO = new PedidoItemDAO();
        }
        return pedidoItemDAO;
    }

    public static MovimentoEstoqueDAO criaMovimentoEstoqueDAO() {
        if(movimentoEstoqueDAO == null) {
            movimentoEstoqueDAO = new MovimentoEstoqueDAO();
        }
        return movimentoEstoqueDAO;
    }
    
}
