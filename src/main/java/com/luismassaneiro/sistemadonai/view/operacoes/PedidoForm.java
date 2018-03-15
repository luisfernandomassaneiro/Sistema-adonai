/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.luismassaneiro.sistemadonai.view.operacoes;

import com.luismassaneiro.sistemadonai.controller.ClienteDAO;
import com.luismassaneiro.sistemadonai.controller.DAOFactory;
import com.luismassaneiro.sistemadonai.controller.PedidoDAO;
import com.luismassaneiro.sistemadonai.controller.ProdutoDAO;
import com.luismassaneiro.sistemadonai.exceptions.ValidateException;
import com.luismassaneiro.sistemadonai.model.Cliente;
import com.luismassaneiro.sistemadonai.model.Pedido;
import com.luismassaneiro.sistemadonai.model.PedidoItem;
import com.luismassaneiro.sistemadonai.model.Produto;
import com.luismassaneiro.sistemadonai.utils.FormatUtils;
import com.luismassaneiro.sistemadonai.view.tablemodel.PedidoItemTableModel;
import com.luismassaneiro.sistemadonai.view.Selecionador;
import com.luismassaneiro.sistemadonai.view.cadastro.ClienteBrowser;
import com.luismassaneiro.sistemadonai.view.cadastro.ProdutoBrowser;
import com.luismassaneiro.sistemadonai.view.desktop.GerenciadorJanelas;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;

/**
 *
 * @author luis.massaneiro
 */
public class PedidoForm extends javax.swing.JInternalFrame implements Selecionador<Object> {

    private Pedido pedido = new Pedido();
    private BigDecimal totalPedido = BigDecimal.ZERO;
    private final PedidoDAO pedidoDAO;
    private final ClienteDAO clienteDAO;
    private final ProdutoDAO produtoDAO;
    private Produto produtoLookup;
    private Cliente clienteLookup;
    
    public PedidoForm() {
        this.clienteDAO = DAOFactory.criaClienteDAO();
        this.pedidoDAO = DAOFactory.criaPedidoDAO();
        this.produtoDAO = DAOFactory.criaProdutoDAO();
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabela_PedidoItem = new javax.swing.JTable();
        botao_ExcluirItem = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        texto_codigoCliente = new javax.swing.JTextField();
        texto_nomeCliente = new javax.swing.JTextField();
        botao_pesquisarCliente = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        texto_codigoProduto = new javax.swing.JTextField();
        texto_descricaoProduto = new javax.swing.JTextField();
        botao_pesquisarProduto = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        texto_quantidade = new javax.swing.JFormattedTextField();
        jLabel13 = new javax.swing.JLabel();
        texto_observacao = new javax.swing.JTextField();
        botao_adicionarProduto = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        texto_total = new javax.swing.JTextField();
        botao_novoPedido = new javax.swing.JButton();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Pedido");

        tabela_PedidoItem.setModel(new PedidoItemTableModel());
        jScrollPane1.setViewportView(tabela_PedidoItem);

        botao_ExcluirItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/luismassaneiro/controleestoque/imagens/delete16.png"))); // NOI18N
        botao_ExcluirItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_ExcluirItemActionPerformed(evt);
            }
        });

        jLabel12.setText("Cliente");

        texto_codigoCliente.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                texto_codigoClienteFocusLost(evt);
            }
        });
        texto_codigoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                texto_codigoClienteActionPerformed(evt);
            }
        });
        texto_codigoCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                texto_codigoClienteKeyPressed(evt);
            }
        });

        texto_nomeCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                texto_nomeClienteActionPerformed(evt);
            }
        });

        botao_pesquisarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/luismassaneiro/controleestoque/imagens/search16.png"))); // NOI18N
        botao_pesquisarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_pesquisarClienteActionPerformed(evt);
            }
        });

        jLabel1.setText("Produto");

        texto_codigoProduto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                texto_codigoProdutoFocusLost(evt);
            }
        });
        texto_codigoProduto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                texto_codigoProdutoKeyPressed(evt);
            }
        });

        botao_pesquisarProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/luismassaneiro/controleestoque/imagens/search16.png"))); // NOI18N
        botao_pesquisarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_pesquisarProdutoActionPerformed(evt);
            }
        });

        jLabel10.setText("Quantidade");

        texto_quantidade.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getIntegerInstance())));
        texto_quantidade.setText("1");

        jLabel13.setText("Observação");

        botao_adicionarProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/luismassaneiro/controleestoque/imagens/plus-green16.png"))); // NOI18N
        botao_adicionarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_adicionarProdutoActionPerformed(evt);
            }
        });

        jLabel2.setText("Total do pedido");

        botao_novoPedido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/luismassaneiro/controleestoque/imagens/new.png"))); // NOI18N
        botao_novoPedido.setText("Novo pedido");
        botao_novoPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_novoPedidoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(texto_total))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(botao_ExcluirItem, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel12)
                                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                                            .addComponent(texto_codigoProduto))
                                        .addComponent(texto_codigoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(texto_nomeCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                                        .addComponent(texto_descricaoProduto))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(botao_pesquisarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(botao_pesquisarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(texto_quantidade))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel13)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(texto_observacao, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(botao_adicionarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addGap(0, 12, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botao_novoPedido)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(texto_codigoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(texto_nomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(botao_pesquisarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel10)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(texto_codigoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(texto_descricaoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(botao_pesquisarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(texto_quantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(texto_observacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(botao_adicionarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botao_ExcluirItem, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(texto_total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botao_novoPedido)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botao_ExcluirItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_ExcluirItemActionPerformed
        PedidoItem pedidoItemExcluir = getPedidoItemSelecionado();
        if(pedidoItemExcluir == null) {
            JOptionPane.showMessageDialog(this, "Nenhum item foi selecionado", "Erro!", JOptionPane.ERROR_MESSAGE);
        } else {
            try {
                pedido.getItens().remove(pedidoItemExcluir);
                pedido = pedidoDAO.atualizar(pedido); 
                reloadTable();
                atualizaTotalCompra();
            } catch (ValidateException ex) {
                Logger.getLogger(PedidoForm.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
            }
        }

    }//GEN-LAST:event_botao_ExcluirItemActionPerformed

    private void texto_codigoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_texto_codigoClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_texto_codigoClienteActionPerformed

    private void texto_nomeClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_texto_nomeClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_texto_nomeClienteActionPerformed

    private void botao_pesquisarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_pesquisarClienteActionPerformed
        ClienteBrowser cliente = (ClienteBrowser) GerenciadorJanelas.getInstance().abrirJanela(new ClienteBrowser());
        cliente.showWindow(this);
        cliente.setVisible(true);
    }//GEN-LAST:event_botao_pesquisarClienteActionPerformed

    private void botao_pesquisarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_pesquisarProdutoActionPerformed
        ProdutoBrowser produto = (ProdutoBrowser) GerenciadorJanelas.getInstance().abrirJanela(new ProdutoBrowser());
        produto.showWindow(this);
        produto.setVisible(true);
    }//GEN-LAST:event_botao_pesquisarProdutoActionPerformed

    private void botao_adicionarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_adicionarProdutoActionPerformed
        adicionaProduto(produtoLookup);
    }//GEN-LAST:event_botao_adicionarProdutoActionPerformed

    private void texto_codigoProdutoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_texto_codigoProdutoKeyPressed
        if(evt.getKeyCode() == 9 || evt.getKeyCode() == 10) {
            carregaLookupProduto();
        }
    }//GEN-LAST:event_texto_codigoProdutoKeyPressed

    private void texto_codigoClienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_texto_codigoClienteKeyPressed
        if(evt.getKeyCode() == 9 || evt.getKeyCode() == 10) {
            carregaLookupCliente();
        }
    }//GEN-LAST:event_texto_codigoClienteKeyPressed

    private void botao_novoPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_novoPedidoActionPerformed
        limpar();
    }//GEN-LAST:event_botao_novoPedidoActionPerformed

    private void texto_codigoClienteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_texto_codigoClienteFocusLost
        carregaLookupCliente();
    }//GEN-LAST:event_texto_codigoClienteFocusLost

    private void texto_codigoProdutoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_texto_codigoProdutoFocusLost
        carregaLookupProduto();
    }//GEN-LAST:event_texto_codigoProdutoFocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botao_ExcluirItem;
    private javax.swing.JButton botao_adicionarProduto;
    private javax.swing.JButton botao_novoPedido;
    private javax.swing.JButton botao_pesquisarCliente;
    private javax.swing.JButton botao_pesquisarProduto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabela_PedidoItem;
    private javax.swing.JTextField texto_codigoCliente;
    private javax.swing.JTextField texto_codigoProduto;
    private javax.swing.JTextField texto_descricaoProduto;
    private javax.swing.JTextField texto_nomeCliente;
    private javax.swing.JTextField texto_observacao;
    private javax.swing.JFormattedTextField texto_quantidade;
    private javax.swing.JTextField texto_total;
    // End of variables declaration//GEN-END:variables

    public void adicionaProduto(Produto produto){
        if(StringUtils.isNotEmpty(texto_quantidade.getText()) && produto != null) {
            Integer quantidade = Integer.valueOf(texto_quantidade.getText());
            if(quantidade > 0) {
                try {
                    PedidoItem novoItem = new PedidoItem();
                    novoItem.setProduto(produto);
                    novoItem.setQuantidade(quantidade);
                    novoItem.setObservacao(texto_observacao.getText());
                    novoItem.setValor(produto.getValor());
                    if(CollectionUtils.isEmpty(pedido.getItens()))
                        pedido.setItens(new ArrayList<PedidoItem>());
                    
                    pedido.getItens().add(novoItem);
                    pedido.setCliente(clienteLookup);
                    pedido = pedidoDAO.atualizar(pedido);
                    reloadTable();
                    atualizaTotalCompra();
                    texto_codigoProduto.setText("");
                    texto_descricaoProduto.setText("");
                    texto_quantidade.setText("1");
                    texto_observacao.setText("");
                } catch (ValidateException ex) {
                    Logger.getLogger(PedidoForm.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(this, ex.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Quantidade informada deve ser maior que zero!", "Erro!", JOptionPane.ERROR_MESSAGE);
                texto_quantidade.setText("1");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Para adicionar um produto, é necessário selecionar o produto e informar a quantidade.", "Erro!", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void limpar() {
        texto_codigoProduto.setText("");
        texto_descricaoProduto.setText("");
        texto_codigoCliente.setText("");
        texto_nomeCliente.setText("");
        texto_quantidade.setText("1");
        texto_observacao.setText("");
        pedido = new Pedido();
        totalPedido = BigDecimal.ZERO;
        reloadTable();
        atualizaTotalCompra();
    }
    
    private void reloadTable() {
        PedidoItemTableModel modelo = (PedidoItemTableModel) tabela_PedidoItem.getModel();
        modelo.reload(pedido.getItens());
        tabela_PedidoItem.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        tabela_PedidoItem.setModel(modelo);
    }

    private PedidoItem getPedidoItemSelecionado() {
        if (tabela_PedidoItem.getSelectedRow() == -1)
            return null;
        
        PedidoItemTableModel modelo = (PedidoItemTableModel) tabela_PedidoItem.getModel();
        PedidoItem pedidoItemSelecionado = modelo.getPedidoItemAt(tabela_PedidoItem.getSelectedRow());
        return pedidoItemSelecionado;
    }

    @Override
    public void setSelecionado(Object obj) {
        if(obj != null) {
            if(obj instanceof Produto) {
                produtoLookup = (Produto) obj;
                texto_codigoProduto.setText(produtoLookup.getCodigo());
                texto_descricaoProduto.setText(produtoLookup.getDescricao());
            } else if(obj instanceof Cliente) {
                clienteLookup = (Cliente) obj;
                texto_codigoCliente.setText(clienteLookup.getCodigo());
                texto_nomeCliente.setText(clienteLookup.getNome());
                carregaPedido();
            }
        }
       
    }

    public void carregaPedido(){
        if(clienteLookup != null && clienteLookup.getId() != null) {
            try {
                pedido = pedidoDAO.recuperaPedidoDoCliente(clienteLookup.getId());
                if(pedido == null) {
                    pedido = new Pedido();
                } else {
                    pedido = pedidoDAO.buscar(pedido.getId());
                    reloadTable();
                    atualizaTotalCompra();
                }
            } catch (ValidateException ex) {
                Logger.getLogger(PedidoForm.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Erro ao buscar o pedido!", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void atualizaTotalCompra() {
        totalPedido = BigDecimal.ZERO;
        if(CollectionUtils.isNotEmpty(pedido.getItens())) {
            for (PedidoItem umItem : pedido.getItens()) {
                totalPedido = totalPedido.add(umItem.getValor());
            }
        } 
        texto_total.setText(FormatUtils.formatBigDecimal(totalPedido));
    }

    private void carregaLookupCliente() {
        if(StringUtils.isNotEmpty(texto_codigoCliente.getText())) {
            try {
                clienteLookup = clienteDAO.recuperaClientePeloCodigo(texto_codigoCliente.getText());
                if(clienteLookup != null) {
                    texto_nomeCliente.setText(clienteLookup.getNome());
                    carregaPedido();
                } else {
                    JOptionPane.showMessageDialog(null, "Cliente não encontrado!", "Erro!", JOptionPane.ERROR_MESSAGE);
                }
            } catch (ValidateException ex) {
                Logger.getLogger(PedidoForm.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Informe um código de cliente!", "Alerta!", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    private void carregaLookupProduto() {
        if(StringUtils.isNotEmpty(texto_codigoProduto.getText())) {
            try {
                produtoLookup = produtoDAO.recuperaProdutoPeloCodigo(texto_codigoProduto.getText());
                if(produtoLookup != null) {
                    texto_descricaoProduto.setText(produtoLookup.getDescricao());
                } else {
                    JOptionPane.showMessageDialog(null, "Produto não encontrado!", "Erro!", JOptionPane.ERROR_MESSAGE);
                }
            } catch (ValidateException ex) {
                Logger.getLogger(PedidoForm.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Informe um código de produto!", "Alerta!", JOptionPane.WARNING_MESSAGE);
        }
    }
}
