/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.luismassaneiro.sistemadonai.view.operacoes;

import com.luismassaneiro.sistemadonai.controller.DAOFactory;
import com.luismassaneiro.sistemadonai.controller.PedidoItemDAO;
import com.luismassaneiro.sistemadonai.enums.TipoSituacaoProduto;
import com.luismassaneiro.sistemadonai.exceptions.ValidateException;
import com.luismassaneiro.sistemadonai.model.PedidoItem;
import com.luismassaneiro.sistemadonai.utils.DataUtil;
import com.luismassaneiro.sistemadonai.utils.FormatUtils;
import com.luismassaneiro.sistemadonai.utils.TrataExcecao;
import com.luismassaneiro.sistemadonai.view.tablemodel.PagamentoTableModel;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import org.apache.commons.collections.CollectionUtils;

/**
 *
 * @author luis.massaneiro
 */
public class Pagamento extends javax.swing.JInternalFrame {

    private final PedidoItemDAO dao = DAOFactory.criaPedidoItemDAO();
    private PagamentoTableModel modelo;
    private List<PedidoItem> listaPedido = new ArrayList<>();
    
    public Pagamento() {
        initComponents();
        limpar();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCalendar1 = new com.toedter.calendar.JCalendar();
        botao_limpar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        scrollPane = new javax.swing.JScrollPane();
        tabela_pagamento = new javax.swing.JTable();
        botao_Pesquisar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        texto_codigo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        texto_nome = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        botao_realizarPagamento = new javax.swing.JButton();
        texto_DataFinal = new javax.swing.JFormattedTextField();
        texto_DataInicial = new javax.swing.JFormattedTextField();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Pagamentos");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameActivated(evt);
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        botao_limpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/luismassaneiro/controleestoque/imagens/eraser-32.png"))); // NOI18N
        botao_limpar.setText("Limpar");
        botao_limpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_limparActionPerformed(evt);
            }
        });

        jLabel1.setText("Data final");

        jLabel2.setText("Data inicial");

        tabela_pagamento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        scrollPane.setViewportView(tabela_pagamento);

        botao_Pesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/luismassaneiro/controleestoque/imagens/search26.png"))); // NOI18N
        botao_Pesquisar.setText("Pesquisar");
        botao_Pesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_PesquisarActionPerformed(evt);
            }
        });

        jLabel3.setText("Codigo");

        texto_codigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                texto_codigoKeyPressed(evt);
            }
        });

        jLabel4.setText("Nome");

        texto_nome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                texto_nomeKeyPressed(evt);
            }
        });

        botao_realizarPagamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/luismassaneiro/controleestoque/imagens/money-24.png"))); // NOI18N
        botao_realizarPagamento.setText("Realizar pagamento");
        botao_realizarPagamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_realizarPagamentoActionPerformed(evt);
            }
        });

        try {
            texto_DataFinal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        texto_DataFinal.setToolTipText("");

        try {
            texto_DataInicial.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        texto_DataInicial.setToolTipText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 696, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(texto_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(texto_nome, javax.swing.GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(texto_DataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(texto_DataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(51, 51, 51))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(botao_realizarPagamento)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(botao_limpar))
                            .addComponent(botao_Pesquisar))))
                .addContainerGap())
            .addComponent(jSeparator1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(botao_Pesquisar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(jLabel3))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(texto_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(texto_nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(texto_DataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(texto_DataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(botao_limpar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botao_realizarPagamento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botao_limparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_limparActionPerformed
        limpar();
    }//GEN-LAST:event_botao_limparActionPerformed

    private void botao_PesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_PesquisarActionPerformed
        pesquisar();
    }//GEN-LAST:event_botao_PesquisarActionPerformed

    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated
    }//GEN-LAST:event_formInternalFrameActivated

    private void botao_realizarPagamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_realizarPagamentoActionPerformed
        if(CollectionUtils.isNotEmpty(listaPedido)) {
            int resp = JOptionPane.showConfirmDialog(this, "Deseja realizar o pagamento dos itens?");
            if(resp == JOptionPane.YES_OPTION) {
                for (PedidoItem pedidoItem : listaPedido) {
                    pedidoItem.setTipoSituacaoProduto(TipoSituacaoProduto.PAGO);
                    pedidoItem.setDataPagamento(new Date());
                    try {
                        dao.atualizar(pedidoItem);
                    } catch (ValidateException ex) {
                        Logger.getLogger(Pagamento.class.getName()).log(Level.SEVERE, null, ex);
                        String mensagem = TrataExcecao.trataMensagemErro(ex, Pagamento.class);
                        JOptionPane.showMessageDialog(this, mensagem, "Erro!", JOptionPane.ERROR_MESSAGE);
                    }
                }
                JOptionPane.showMessageDialog(this, "Pagamento realizado com sucesso!");
                limpar();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Para realizar o pagamento, é necessário que tenha itens na lista.", "Erro!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_botao_realizarPagamentoActionPerformed

    private void texto_codigoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_texto_codigoKeyPressed
        if(evt.getKeyCode() == 10) {
            pesquisar();
        }
    }//GEN-LAST:event_texto_codigoKeyPressed

    private void texto_nomeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_texto_nomeKeyPressed
        if(evt.getKeyCode() == 10) {
            pesquisar();
        }
    }//GEN-LAST:event_texto_nomeKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botao_Pesquisar;
    private javax.swing.JButton botao_limpar;
    private javax.swing.JButton botao_realizarPagamento;
    private com.toedter.calendar.JCalendar jCalendar1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JScrollPane scrollPane;
    public javax.swing.JTable tabela_pagamento;
    private javax.swing.JFormattedTextField texto_DataFinal;
    private javax.swing.JFormattedTextField texto_DataInicial;
    private javax.swing.JTextField texto_codigo;
    private javax.swing.JTextField texto_nome;
    // End of variables declaration//GEN-END:variables

    private void pesquisar() {
        try {
            Date dataInicial = FormatUtils.parseDate(texto_DataInicial.getText());
            Date dataFinal = FormatUtils.parseDate(texto_DataFinal.getText());
            if(dataInicial != null && dataFinal != null && DataUtil.compareTo(dataInicial, dataFinal) > 0) {
                JOptionPane.showMessageDialog(this, "Data inicial maior que data final", "Erro!", JOptionPane.ERROR_MESSAGE);
            } else {
                listaPedido = dao.recuperaPedidosParaPagamento(texto_codigo.getText(),texto_nome.getText(), DataUtil.zeraHora(dataInicial), DataUtil.zeraHora(dataFinal));
                reloadTable();
            }
        } catch (ParseException | ValidateException ex) {
            Logger.getLogger(Pagamento.class.getName()).log(Level.SEVERE, null, ex);
            String mensagem = TrataExcecao.trataMensagemErro(ex, Pagamento.class);
            JOptionPane.showMessageDialog(this, mensagem, "Erro!", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void limpar() {
        listaPedido = new ArrayList<>();
        reloadTable();
        texto_codigo.setText("");
        texto_nome.setText("");
        texto_DataInicial.setText("");
        texto_DataFinal.setText("");
    }
    
    private void reloadTable() {
        modelo = new PagamentoTableModel();
        modelo.reload(listaPedido);
        tabela_pagamento.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tabela_pagamento.setModel(modelo);
    }
}
