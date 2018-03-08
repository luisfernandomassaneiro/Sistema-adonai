/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.luismassaneiro.sistemadonai.view.operacoes;

import com.luismassaneiro.sistemadonai.controller.DAOFactory;
import com.luismassaneiro.sistemadonai.controller.PedidoDAO;
import com.luismassaneiro.sistemadonai.controller.PedidoItemDAO;
import com.luismassaneiro.sistemadonai.controller.ProdutoDAO;
import com.luismassaneiro.sistemadonai.enums.MensagemFixas;
import com.luismassaneiro.sistemadonai.enums.TipoFormaPagamento;
import com.luismassaneiro.sistemadonai.exceptions.ValidateException;
import com.luismassaneiro.sistemadonai.helper.PedidoHelper;
import com.luismassaneiro.sistemadonai.helper.ProdutoHelper;
import com.luismassaneiro.sistemadonai.model.Pedido;
import com.luismassaneiro.sistemadonai.model.PedidoItem;
import com.luismassaneiro.sistemadonai.model.Produto;
import com.luismassaneiro.sistemadonai.utils.FormatUtils;
import com.luismassaneiro.sistemadonai.view.tablemodel.PedidoItemTableModel;
import com.luismassaneiro.sistemadonai.view.Selecionador;
import com.luismassaneiro.sistemadonai.view.cadastro.ProdutoBrowser;
import com.luismassaneiro.sistemadonai.view.desktop.GerenciadorJanelas;
import java.awt.HeadlessException;
import java.math.BigDecimal;
import java.text.ParseException;
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
public class PedidoForm extends javax.swing.JInternalFrame implements Selecionador<Produto> {

    private Pedido pedido = new Pedido();
    private BigDecimal totalCompra = BigDecimal.ZERO;
    private BigDecimal totalRecebido = BigDecimal.ZERO;
    private static PedidoDAO pedidoDAO = DAOFactory.criaPedidoDAO();
    private static PedidoItemDAO pedidoItemDAO = DAOFactory.criaPedidoItemDAO();   
    
    public PedidoForm() {
        initComponents();
        carregaComboFormaPagamento();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        texto_CodigoBarras = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela_PedidoItem = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        texto_Quantidade = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        texto_TotalCompra = new javax.swing.JFormattedTextField();
        texto_TotalRecebido = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        texto_Troco = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        texto_Desconto = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        combo_FormaPagamento = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        botao_FinalizaPedido = new javax.swing.JButton();
        area_Observacao = new javax.swing.JScrollPane();
        textArea_Observacao = new javax.swing.JTextArea();
        jLabel9 = new javax.swing.JLabel();
        texto_Acrescimo = new javax.swing.JFormattedTextField();
        botao_CancelarPedido = new javax.swing.JButton();
        botao_ExcluirItem = new javax.swing.JButton();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Pedido");

        jLabel1.setText("Código de barras");

        texto_CodigoBarras.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        texto_CodigoBarras.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                texto_CodigoBarrasKeyReleased(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/luismassaneiro/controleestoque/imagens/search.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        tabela_PedidoItem.setModel(new PedidoItemTableModel());
        jScrollPane1.setViewportView(tabela_PedidoItem);

        jLabel2.setText("Quantidade");

        texto_Quantidade.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        texto_Quantidade.setText("1");
        texto_Quantidade.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        texto_Quantidade.setVerifyInputWhenFocusTarget(false);
        texto_Quantidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                texto_QuantidadeActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel3.setText("Total da compra:");

        texto_TotalCompra.setEditable(false);
        texto_TotalCompra.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00"))));
        texto_TotalCompra.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        texto_TotalRecebido.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00"))));
        texto_TotalRecebido.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        texto_TotalRecebido.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                texto_TotalRecebidoFocusLost(evt);
            }
        });
        texto_TotalRecebido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                texto_TotalRecebidoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                texto_TotalRecebidoKeyReleased(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel4.setText("Total recebido:");

        texto_Troco.setEditable(false);
        texto_Troco.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00"))));
        texto_Troco.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel5.setText("Troco:");

        texto_Desconto.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00"))));
        texto_Desconto.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        texto_Desconto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                texto_DescontoActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel6.setText("Desconto:");

        jLabel7.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel7.setText("Forma de pagamento:");

        combo_FormaPagamento.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        combo_FormaPagamento.setToolTipText("");

        jLabel8.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel8.setText("Observação:");

        botao_FinalizaPedido.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        botao_FinalizaPedido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/luismassaneiro/controleestoque/imagens/seta.png"))); // NOI18N
        botao_FinalizaPedido.setText("Finalizar");
        botao_FinalizaPedido.setMaximumSize(new java.awt.Dimension(141, 41));
        botao_FinalizaPedido.setMinimumSize(new java.awt.Dimension(141, 41));
        botao_FinalizaPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_FinalizaPedidoActionPerformed(evt);
            }
        });

        textArea_Observacao.setColumns(20);
        textArea_Observacao.setRows(5);
        area_Observacao.setViewportView(textArea_Observacao);

        jLabel9.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel9.setText("Acréscimo:");

        texto_Acrescimo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00"))));
        texto_Acrescimo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        texto_Acrescimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                texto_AcrescimoActionPerformed(evt);
            }
        });

        botao_CancelarPedido.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        botao_CancelarPedido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/luismassaneiro/controleestoque/imagens/cancel-24.png"))); // NOI18N
        botao_CancelarPedido.setText("Cancelar");
        botao_CancelarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_CancelarPedidoActionPerformed(evt);
            }
        });

        botao_ExcluirItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/luismassaneiro/controleestoque/imagens/delete-32.png"))); // NOI18N
        botao_ExcluirItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_ExcluirItemActionPerformed(evt);
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
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(220, 220, 220))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(texto_CodigoBarras)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(texto_Quantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(120, 120, 120))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(285, 285, 285))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(texto_Acrescimo))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(texto_Desconto, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(texto_TotalCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(texto_TotalRecebido, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(texto_Troco, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(combo_FormaPagamento, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(area_Observacao, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(302, 302, 302)
                        .addComponent(botao_FinalizaPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                        .addComponent(botao_CancelarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(211, 211, 211))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botao_ExcluirItem, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(texto_Quantidade)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(texto_CodigoBarras))
                .addGap(12, 12, 12)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botao_ExcluirItem, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(texto_TotalCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(texto_TotalRecebido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(texto_Troco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(texto_Desconto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(texto_Acrescimo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(combo_FormaPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(area_Observacao, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(botao_CancelarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botao_FinalizaPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void texto_CodigoBarrasKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_texto_CodigoBarrasKeyReleased
        if(evt.getKeyCode() == 9 || evt.getKeyCode() == 10) {
            try {
                String codigoBarras = texto_CodigoBarras.getText();
                ProdutoDAO produtoDAO = DAOFactory.criaProdutoDAO();
                Produto produto;
                produto = produtoDAO.recuperaProdutoPeloCodigoBarras(codigoBarras);
                if(produto == null) {
                    JOptionPane.showMessageDialog(this, "Produto não encontrado!", "Erro!", JOptionPane.ERROR_MESSAGE);
                    texto_CodigoBarras.setText(null);
                } else {
                    adicionaProduto(produto);
                }
            } catch (ValidateException ex) {
                Logger.getLogger(PedidoForm.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_texto_CodigoBarrasKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ProdutoBrowser produto = (ProdutoBrowser) GerenciadorJanelas.getInstance().abrirJanela(new ProdutoBrowser());
        produto.showWindow(this);
        produto.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void texto_QuantidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_texto_QuantidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_texto_QuantidadeActionPerformed

    private void texto_TotalRecebidoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_texto_TotalRecebidoKeyReleased
//        if(evt.getKeyCode() == 9 || evt.getKeyCode() == 10) {
//            if(StringUtils.isNotEmpty(texto_TotalRecebido.getText())) {
//                totalRecebido = new BigDecimal(texto_TotalRecebido.getText().replaceAll(",", "."));
//                if(totalRecebido.doubleValue() < 0) {
//                    JOptionPane.showMessageDialog(this, "Não é possível informar um valor negativo!", "Erro!", JOptionPane.ERROR_MESSAGE);
//                } else {
//                    troco = totalRecebido.subtract(totalCompra);
//                    if(troco.doubleValue() < 0) {
//                        int resp = JOptionPane.showConfirmDialog(this, "O total recebido foi menor que o valor total da compra.\nDeseja utilizar o valor restando como desconto?");
//                        if(resp == JOptionPane.YES_OPTION) {
//                            troco = troco.multiply(new BigDecimal(-1));
//                            texto_Desconto.setText(Produto.convertValorToString(troco));
//                        }
//                    } else {
//                        texto_Troco.setText(Produto.convertValorToString(troco));
//                    }
//
//                }
//            }
//        }
    }//GEN-LAST:event_texto_TotalRecebidoKeyReleased

    private void texto_DescontoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_texto_DescontoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_texto_DescontoActionPerformed

    private void botao_FinalizaPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_FinalizaPedidoActionPerformed
        if(CollectionUtils.isNotEmpty(pedido.getItens())) {
            try {
                TipoFormaPagamento formaPagamentoSelecionada = (TipoFormaPagamento) combo_FormaPagamento.getSelectedItem();
                if(TipoFormaPagamento.CARTAO.equals(formaPagamentoSelecionada) && StringUtils.isEmpty(texto_TotalRecebido.getText())) {
                    JOptionPane.showMessageDialog(this, "O valor recebido não foi informado e a forma de pagamento foi por cartão. \nO valor recebido receberá o total da compra. ", "Informação", JOptionPane.INFORMATION_MESSAGE);
                    texto_TotalRecebido.setText(texto_TotalCompra.getText());
                }
                pedido.setTipoFormaPagamento(formaPagamentoSelecionada);
                pedido.setObservacao(textArea_Observacao.getText());
                pedido.setValorAcrescimo(FormatUtils.parseBigDecimal(texto_Acrescimo.getText()));
                pedido.setValorDesconto(FormatUtils.parseBigDecimal(texto_Desconto.getText()));
                pedido.setValorPago(FormatUtils.parseBigDecimal(texto_TotalRecebido.getText()));
                pedido.setValorTroco(FormatUtils.parseBigDecimal(texto_Troco.getText()));
                pedido.setValorTotal(FormatUtils.parseBigDecimal(texto_TotalCompra.getText()));
                BigDecimal valorLucro = recuperaValorLucro();
                pedido.setValorLucro(valorLucro);
                pedido.setPedidoFinalizado(true);
                pedido = pedidoDAO.atualizar(pedido);
                JOptionPane.showMessageDialog(this, "Pedido finalizado com sucesso!", "Finalização", JOptionPane.INFORMATION_MESSAGE);
                limpar();
            } catch(HeadlessException | ParseException | ValidateException e) {
                Logger.getLogger(PedidoForm.class.getName()).log(Level.SEVERE, null, e);
                JOptionPane.showMessageDialog(this, e.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Não foi adicionado nenhum produto!", "Erro!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_botao_FinalizaPedidoActionPerformed

    private void texto_AcrescimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_texto_AcrescimoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_texto_AcrescimoActionPerformed

    private void botao_CancelarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_CancelarPedidoActionPerformed
        int resp = JOptionPane.showConfirmDialog(this, "Deseja realmente efetuar o cancelamento?");
        if(resp == JOptionPane.YES_OPTION) {
            cancelaPedido();
        }
    }//GEN-LAST:event_botao_CancelarPedidoActionPerformed

    private void botao_ExcluirItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_ExcluirItemActionPerformed
        PedidoItem pedidoItemExcluir = getPedidoItemSelecionado();
        if(pedidoItemExcluir == null) {
            JOptionPane.showMessageDialog(this, "Nenhum item foi selecionado", "Erro!", JOptionPane.ERROR_MESSAGE);
        } else {
            try {
               // ProdutoHelper.getInstance().atualizaQuantidadeAtual(pedidoItemExcluir.getProduto(), pedidoItemExcluir.getQuantidade(), true);
                totalCompra = totalCompra.subtract(pedidoItemExcluir.getValorVenda());
                texto_TotalCompra.setText(FormatUtils.formatBigDecimal(totalCompra));
                pedido.getItens().remove(pedidoItemExcluir);
                //DAOFactory.criaPedidoItemDAO().excluir(pedidoItemExcluir);
                if(CollectionUtils.isEmpty(pedido.getItens())) {
                    PedidoHelper.cancelaPedido(pedido);
                } else {
                   pedido = pedidoDAO.atualizar(pedido); 
                }
                reloadTable();
            } catch (ValidateException ex) {
                Logger.getLogger(PedidoForm.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
            }
        }

    }//GEN-LAST:event_botao_ExcluirItemActionPerformed

    private void texto_TotalRecebidoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_texto_TotalRecebidoFocusLost
        onFocusTotalRecebido();
    }//GEN-LAST:event_texto_TotalRecebidoFocusLost

    private void texto_TotalRecebidoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_texto_TotalRecebidoKeyPressed
        if(evt.getKeyCode() == 10) {
            onFocusTotalRecebido();
        }
    }//GEN-LAST:event_texto_TotalRecebidoKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane area_Observacao;
    private javax.swing.JButton botao_CancelarPedido;
    private javax.swing.JButton botao_ExcluirItem;
    private javax.swing.JButton botao_FinalizaPedido;
    private javax.swing.JComboBox combo_FormaPagamento;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabela_PedidoItem;
    private javax.swing.JTextArea textArea_Observacao;
    private javax.swing.JFormattedTextField texto_Acrescimo;
    private javax.swing.JTextField texto_CodigoBarras;
    private javax.swing.JFormattedTextField texto_Desconto;
    private javax.swing.JFormattedTextField texto_Quantidade;
    private javax.swing.JFormattedTextField texto_TotalCompra;
    private javax.swing.JFormattedTextField texto_TotalRecebido;
    private javax.swing.JFormattedTextField texto_Troco;
    // End of variables declaration//GEN-END:variables

    private void carregaComboFormaPagamento() {
        if(combo_FormaPagamento.getItemCount() == 0) {
            for(TipoFormaPagamento umaFormaPagamento: TipoFormaPagamento.values()) {
                combo_FormaPagamento.addItem(umaFormaPagamento);
                combo_FormaPagamento.setSelectedItem(TipoFormaPagamento.DINHEIRO);
            }
        }
        
    }

    public void adicionaProduto(Produto produto){
        if(StringUtils.isNotEmpty(texto_Quantidade.getText())) {
            Integer quantidade = Integer.valueOf(texto_Quantidade.getText());
            if(quantidade > 0) {
                try {
//                    ProdutoHelper.getInstance().verificaQuantidadeEmEstoque(produto, quantidade);
                  //  ProdutoHelper.getInstance().atualizaQuantidadeAtual(produto, quantidade, false);
                    PedidoItem novoItem = new PedidoItem();
                    novoItem.setProduto(produto);
                    novoItem.setQuantidade(quantidade);
                    BigDecimal valorVenda = produto.getValor().multiply(new BigDecimal(quantidade));
                    BigDecimal valorCompra = produto.getValor().multiply(new BigDecimal(quantidade));
                    novoItem.setValorVenda(valorVenda);
                    novoItem.setValorCompra(valorCompra);
                    if(CollectionUtils.isEmpty(pedido.getItens()))
                        pedido.setItens(new ArrayList<PedidoItem>());
                    
                    pedido.getItens().add(novoItem);
                    pedido = pedidoDAO.atualizar(pedido);
                    reloadTable();
                    atualizaTotalCompra();
                    texto_CodigoBarras.setText("");
                } catch (ValidateException ex) {
                    Logger.getLogger(PedidoForm.class.getName()).log(Level.SEVERE, null, ex);
                    if(StringUtils.isNotEmpty(ex.getMessage()) && MensagemFixas.QUANTIDADE_INDISPONIVEL.toString().equals(ex.getMessage()) &&
                                                StringUtils.isNotEmpty(ex.getMensagemExcecao())) {
                            JOptionPane.showMessageDialog(this, ex.getMensagemExcecao(), "Erro!", JOptionPane.ERROR_MESSAGE);
                            texto_CodigoBarras.setText(null);
                    } else {
                        JOptionPane.showMessageDialog(this, ex.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
                            texto_CodigoBarras.setText(null);
                    }
                }
            } else {
                JOptionPane.showMessageDialog(this, "Quantidade informada deve ser maior que zero!", "Erro!", JOptionPane.ERROR_MESSAGE);
                texto_Quantidade.setText("");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Favor inserir uma quantidade!", "Erro!", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void cancelaPedido() {
        
        try {
            PedidoHelper.cancelaPedido(pedido);
            limpar();
            JOptionPane.showMessageDialog(this, "Cancelamento realizado com sucesso!", "Cancelamento", JOptionPane.INFORMATION_MESSAGE);
        } catch (ValidateException ex) {
            Logger.getLogger(PedidoForm.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Erro ao cancelar!", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void limpar() {
        String bigDecimalZero = FormatUtils.formatBigDecimal(BigDecimal.ZERO);
        texto_CodigoBarras.setText("");
        texto_Quantidade.setText("1");
        texto_Acrescimo.setText("");
        texto_Desconto.setText("");
        texto_TotalCompra.setText(bigDecimalZero);
        texto_TotalRecebido.setText("");
        texto_Troco.setText(bigDecimalZero);
        textArea_Observacao.setText("");
        pedido = new Pedido();
        totalCompra = BigDecimal.ZERO;
        totalRecebido = BigDecimal.ZERO;
        reloadTable();
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
    public void setSelecionado(Produto produto) {
        adicionaProduto(produto);
    }

    private BigDecimal recuperaValorLucro() {
        if(CollectionUtils.isNotEmpty(pedido.getItens())) {
            BigDecimal valorLucro = BigDecimal.ZERO;
            for (PedidoItem umProduto : pedido.getItens()) {
                valorLucro = valorLucro.add(umProduto.getValorVenda().subtract(umProduto.getValorCompra()));
            }
            valorLucro = valorLucro.subtract(pedido.getValorDesconto());
            return valorLucro;
        } else {
            return BigDecimal.ZERO;
        }
    }
    
    public void carregaPedido(Pedido pedidoCarregar){
        limpar();
        if(pedidoCarregar == null) {
            pedido = new Pedido();
        } else {
            try {
                pedido = pedidoDAO.buscar(pedidoCarregar.getId());
                reloadTable();
                atualizaTotalCompra();
            } catch (ValidateException ex) {
                Logger.getLogger(PedidoForm.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Erro ao buscar o pedido!", JOptionPane.ERROR_MESSAGE);
            }
            
        }
        
    }

    private void atualizaTotalCompra() {
        if(CollectionUtils.isNotEmpty(pedido.getItens())) {
            totalCompra = BigDecimal.ZERO;
            for (PedidoItem umItem : pedido.getItens()) {
                totalCompra = totalCompra.add(umItem.getValorVenda());
            }
            texto_TotalCompra.setText(FormatUtils.formatBigDecimal(totalCompra));
        }
    }

    private void onFocusTotalRecebido() {
        if(StringUtils.isNotEmpty(texto_TotalRecebido.getText())) {
           try {
                BigDecimal troco = BigDecimal.ZERO;
                BigDecimal desconto = BigDecimal.ZERO;
                totalRecebido = FormatUtils.parseBigDecimal(texto_TotalRecebido.getText()); //new BigDecimal(texto_TotalRecebido.getText().replaceAll(",", "."));
                if(totalRecebido.doubleValue() < 0) {
                    JOptionPane.showMessageDialog(this, "Não é possível informar um valor negativo!", "Erro!", JOptionPane.ERROR_MESSAGE);
                } else {
                    texto_Troco.setText(FormatUtils.formatBigDecimal(troco));
                    texto_Desconto.setText(FormatUtils.formatBigDecimal(desconto));
                    troco = totalRecebido.subtract(totalCompra);
                    if(troco.doubleValue() < 0) {
                        int resp = JOptionPane.showConfirmDialog(this, "O total recebido foi menor que o valor total da compra.\nDeseja utilizar o valor restando como desconto?");
                        if(resp == JOptionPane.YES_OPTION) {
                            desconto = troco.multiply(new BigDecimal(-1));
                            texto_Desconto.setText(FormatUtils.formatBigDecimal(desconto));
                        }
                    } else {
                        texto_Troco.setText(FormatUtils.formatBigDecimal(troco));
                    }
                }
           } catch (ParseException ex) {
               Logger.getLogger(PedidoForm.class.getName()).log(Level.SEVERE, null, ex);
               JOptionPane.showMessageDialog(this, ex.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
           }
        }
    }

}
