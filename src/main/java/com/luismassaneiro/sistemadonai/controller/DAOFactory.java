package com.luismassaneiro.sistemadonai.controller;

/**
 *
 * @author luiz_f_massaneiro
 */
public class DAOFactory {
    private static CategoriaDAO categoriaDAO;
    private static ProdutoDAO produtoDAO;
    private static PedidoDAO pedidoDAO;
    private static PedidoItemDAO pedidoItemDAO;
    private static ClienteDAO clienteDAO;
    
    public static CategoriaDAO criaCategoriaDAO() {
        if(categoriaDAO == null) {
            categoriaDAO = new CategoriaDAO();
        }
        return categoriaDAO;
    }
    
    public static ClienteDAO criaClienteDAO() {
        if(clienteDAO == null)
            clienteDAO = new ClienteDAO();
        
        return clienteDAO;
    }
    
    public static MovimentoEstoqueDAO criaMovimentoEstoqueDAO() {
        MovimentoEstoqueDAO movimentoEstoqueDAO = new MovimentoEstoqueDAO();
        return movimentoEstoqueDAO;
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
    
    public static CodigoBarraDAO criaCodigoBarraDAO() {
        CodigoBarraDAO codigoBarraDAO = new CodigoBarraDAO();
        return codigoBarraDAO;
    }
    
    public static PedidoItemDAO criaPedidoItemDAO() {
        if(pedidoItemDAO == null) {
            pedidoItemDAO = new PedidoItemDAO();
        }
        return pedidoItemDAO;
    }
    
//    public static FornecedorDAO criaFornecedorDAO() {
//        FornecedorDAO fornecedorDAO = new FornecedorDAO();
//        fornecedorDAO.setEntityManager(ConectaBanco.getEntityManager());
//        return fornecedorDAO;
//    }
//    
    
    
}
