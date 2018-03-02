/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.luismassaneiro.controleestoque.view.consultas;

import com.luismassaneiro.controleestoque.controller.DAOFactory;
import com.luismassaneiro.controleestoque.controller.PedidoDAO;
import com.luismassaneiro.controleestoque.exceptions.ValidateException;
import com.luismassaneiro.controleestoque.model.Pedido;
import com.luismassaneiro.controleestoque.utils.DataUtil;
import com.luismassaneiro.controleestoque.utils.FormatUtils;
import com.luismassaneiro.controleestoque.view.desktop.GerenciadorJanelas;
import com.luismassaneiro.controleestoque.view.exportador.ExportadorTabelas;
import com.luismassaneiro.controleestoque.view.tablemodel.VendaTableModel;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.apache.commons.collections.CollectionUtils;

/**
 *
 * @author luis.massaneiro
 */
public class Vendas extends javax.swing.JInternalFrame {

    private final PedidoDAO dao = DAOFactory.criaPedidoDAO();
    private VendaTableModel modelo;
    private List<Pedido> listaPedido = new ArrayList<>();
    
    public Vendas() {
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

        jCalendar1 = new com.toedter.calendar.JCalendar();
        botao_Exportar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        scrollPane = new javax.swing.JScrollPane();
        tabela_Produto = new javax.swing.JTable();
        botao_Pesquisar = new javax.swing.JButton();
        texto_DataInicial = new com.toedter.calendar.JDateChooser();
        texto_DataFinal = new com.toedter.calendar.JDateChooser();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Consultas de vendas");
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

        botao_Exportar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/luismassaneiro/controleestoque/imagens/export-24.png"))); // NOI18N
        botao_Exportar.setText("Expotar");
        botao_Exportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_ExportarActionPerformed(evt);
            }
        });

        jLabel1.setText("Data final");

        jLabel2.setText("Data inicial");

        tabela_Produto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        scrollPane.setViewportView(tabela_Produto);

        botao_Pesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/luismassaneiro/controleestoque/imagens/search26.png"))); // NOI18N
        botao_Pesquisar.setText("Pesquisar");
        botao_Pesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_PesquisarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(scrollPane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 696, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(botao_Exportar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(botao_Pesquisar))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(texto_DataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(49, 49, 49)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(texto_DataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(botao_Pesquisar)
                        .addGap(72, 72, 72))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(texto_DataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(texto_DataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)))
                .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(botao_Exportar)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botao_ExportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_ExportarActionPerformed
        if(CollectionUtils.isNotEmpty(listaPedido)) {
            List<String> linhasArquivo = new ArrayList<>();
            linhasArquivo.add("Data;Qtd. produtos;Valor lucro");
            for(Pedido umPedido: listaPedido) {
                String linha = String.format("%s;%s;%s;",
                    FormatUtils.formatDate(umPedido.getData()),
                    umPedido.getQuantidadeProdutos(),
                    FormatUtils.formatBigDecimal(umPedido.getValorLucro()));
                linhasArquivo.add(linha);
            }
            ExportadorTabelas exportador = (ExportadorTabelas) GerenciadorJanelas.getInstance().abrirJanela(new ExportadorTabelas());
            exportador.adicionaListaLinhasArquivo(linhasArquivo, "vendas");
            exportador.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Não há registros para serem exportados!", "Atenção!", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_botao_ExportarActionPerformed

    private void botao_PesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_PesquisarActionPerformed
        pesquisar(texto_DataInicial.getDate(),texto_DataFinal.getDate());
    }//GEN-LAST:event_botao_PesquisarActionPerformed

    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated
        pesquisar(null, null);
    }//GEN-LAST:event_formInternalFrameActivated


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botao_Exportar;
    private javax.swing.JButton botao_Pesquisar;
    private com.toedter.calendar.JCalendar jCalendar1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JScrollPane scrollPane;
    public javax.swing.JTable tabela_Produto;
    private com.toedter.calendar.JDateChooser texto_DataFinal;
    private com.toedter.calendar.JDateChooser texto_DataInicial;
    // End of variables declaration//GEN-END:variables

    private void pesquisar(Date dataInicial, Date dataFinal) {
        try {
            if((dataInicial == null && dataFinal != null) || (dataInicial != null && dataFinal == null)) {
                JOptionPane.showMessageDialog(this, "Caso uma das datas seja informada, é obrigatório informar a outra", "Alerta!", JOptionPane.WARNING_MESSAGE);
            }else if(dataInicial != null && dataFinal != null && DataUtil.compareTo(dataInicial, dataFinal) >= 0) {
                JOptionPane.showMessageDialog(this, "Data inicial maior que data final", "Erro!", JOptionPane.ERROR_MESSAGE);
            } else {
                modelo = new VendaTableModel();
                listaPedido = dao.recuperaVendas(DataUtil.zeraHora(dataInicial), DataUtil.zeraHora(dataFinal));
                modelo.reload(listaPedido);
                tabela_Produto.setModel(modelo);
            }
        } catch (ValidateException ex) {
            Logger.getLogger(Vendas.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
        }
    }
    
}
