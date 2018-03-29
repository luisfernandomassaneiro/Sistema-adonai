/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.luismassaneiro.sistemadonai.view.consultas;

import com.luismassaneiro.sistemadonai.controller.ClienteDAO;
import com.luismassaneiro.sistemadonai.controller.DAOFactory;
import com.luismassaneiro.sistemadonai.controller.PedidoItemDAO;
import com.luismassaneiro.sistemadonai.dto.InadimplenciaDTO;
import com.luismassaneiro.sistemadonai.exceptions.ValidateException;
import com.luismassaneiro.sistemadonai.model.Cliente;
import com.luismassaneiro.sistemadonai.model.PedidoItem;
import com.luismassaneiro.sistemadonai.utils.DataUtil;
import com.luismassaneiro.sistemadonai.utils.FormatUtils;
import com.luismassaneiro.sistemadonai.view.Selecionador;
import com.luismassaneiro.sistemadonai.view.cadastro.ClienteBrowser;
import com.luismassaneiro.sistemadonai.view.desktop.GerenciadorJanelas;
import com.luismassaneiro.sistemadonai.view.exportador.ExportadorTabelas;
import com.luismassaneiro.sistemadonai.view.operacoes.PedidoForm;
import com.luismassaneiro.sistemadonai.view.tablemodel.ConsultaDetalhadaTableModel;
import com.luismassaneiro.sistemadonai.view.tablemodel.InadimplenciaTableModel;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
public class ConsultaDetalhada extends javax.swing.JInternalFrame implements Selecionador<Object> {

    private final ClienteDAO clienteDAO = DAOFactory.criaClienteDAO();
    private final PedidoItemDAO pedidoItemDAO = DAOFactory.criaPedidoItemDAO();
    private ConsultaDetalhadaTableModel modelo;
    private List<PedidoItem> listaDetalhada = new ArrayList<>();
    private Cliente clienteLookup;
    
    public ConsultaDetalhada() {
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
        botao_limpar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        scrollPane = new javax.swing.JScrollPane();
        tabela_detalhada = new javax.swing.JTable();
        botao_Pesquisar = new javax.swing.JButton();
        texto_DataInicial = new com.toedter.calendar.JDateChooser();
        texto_DataFinal = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        botao_exportar = new javax.swing.JButton();
        texto_codigoCliente = new javax.swing.JTextField();
        texto_nomeCliente = new javax.swing.JTextField();
        botao_pesquisarCliente = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        combo_situacaoPagamento = new javax.swing.JComboBox<>();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Consulta detalhada");
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

        tabela_detalhada.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        scrollPane.setViewportView(tabela_detalhada);

        botao_Pesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/luismassaneiro/controleestoque/imagens/search26.png"))); // NOI18N
        botao_Pesquisar.setText("Pesquisar");
        botao_Pesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_PesquisarActionPerformed(evt);
            }
        });

        jLabel3.setText("Cliente");

        botao_exportar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/luismassaneiro/controleestoque/imagens/export-24.png"))); // NOI18N
        botao_exportar.setText("Exportar");
        botao_exportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_exportarActionPerformed(evt);
            }
        });

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

        jLabel4.setText("Situação de pagamento");

        combo_situacaoPagamento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Em aberto", "Pago" }));
        combo_situacaoPagamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_situacaoPagamentoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4)
                                .addGap(36, 36, 36))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(texto_codigoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(texto_nomeCliente)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(botao_pesquisarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(combo_situacaoPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(texto_DataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(texto_DataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 761, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(botao_exportar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(botao_limpar))
                            .addComponent(botao_Pesquisar, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(botao_Pesquisar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(texto_codigoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(texto_nomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(botao_pesquisarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(combo_situacaoPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(texto_DataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(texto_DataInicial, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(botao_limpar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botao_exportar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
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

    private void botao_exportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_exportarActionPerformed
        if(CollectionUtils.isNotEmpty(listaDetalhada)) {
            List<String> linhasArquivo = new ArrayList<>();
            linhasArquivo.add("Codigo;Descrição;Valor;Quantidade;Data de compra;Data de pagamento;Observação;Situação de pagamento");
            for(PedidoItem umDetalhe: listaDetalhada) {
                String linha = String.format("%s;%s;%s;%s;%s;%s;%s;%s;",
                    umDetalhe.getProduto().getCodigo(),
                    umDetalhe.getProduto().getDescricao(),
                    FormatUtils.formatBigDecimal(umDetalhe.getValor()),
                    umDetalhe.getQuantidade().toString(),
                    FormatUtils.formatDate(umDetalhe.getDataCompra()),
                    FormatUtils.formatDate(umDetalhe.getDataPagamento()),
                    umDetalhe.getObservacao(),
                    umDetalhe.getTipoSituacaoProduto().getLabel());
                linhasArquivo.add(linha);
            }
            ExportadorTabelas exportador = (ExportadorTabelas) GerenciadorJanelas.getInstance().abrirJanela(new ExportadorTabelas());
            exportador.adicionaListaLinhasArquivo(linhasArquivo, "Consulta Detalhada -" + clienteLookup.getNome()+ " - "+FormatUtils.formatDateError(new Date()));
            exportador.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Não há registros para serem exportados!", "Atenção!", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_botao_exportarActionPerformed

    private void texto_codigoClienteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_texto_codigoClienteFocusLost
        carregaLookupCliente();
    }//GEN-LAST:event_texto_codigoClienteFocusLost

    private void texto_codigoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_texto_codigoClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_texto_codigoClienteActionPerformed

    private void texto_codigoClienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_texto_codigoClienteKeyPressed
        if(evt.getKeyCode() == 9 || evt.getKeyCode() == 10) {
            carregaLookupCliente();
        }
    }//GEN-LAST:event_texto_codigoClienteKeyPressed

    private void texto_nomeClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_texto_nomeClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_texto_nomeClienteActionPerformed

    private void botao_pesquisarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_pesquisarClienteActionPerformed
        ClienteBrowser cliente = (ClienteBrowser) GerenciadorJanelas.getInstance().abrirJanela(new ClienteBrowser());
        cliente.showWindow(this);
        cliente.setVisible(true);
    }//GEN-LAST:event_botao_pesquisarClienteActionPerformed

    private void combo_situacaoPagamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_situacaoPagamentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combo_situacaoPagamentoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botao_Pesquisar;
    private javax.swing.JButton botao_exportar;
    private javax.swing.JButton botao_limpar;
    private javax.swing.JButton botao_pesquisarCliente;
    private javax.swing.JComboBox<String> combo_situacaoPagamento;
    private com.toedter.calendar.JCalendar jCalendar1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JScrollPane scrollPane;
    public javax.swing.JTable tabela_detalhada;
    private com.toedter.calendar.JDateChooser texto_DataFinal;
    private com.toedter.calendar.JDateChooser texto_DataInicial;
    private javax.swing.JTextField texto_codigoCliente;
    private javax.swing.JTextField texto_nomeCliente;
    // End of variables declaration//GEN-END:variables

    private void pesquisar() {
        if(clienteLookup != null && clienteLookup.getId() != null) {
            try {
                Date dataInicial = texto_DataInicial.getDate();
                Date dataFinal = texto_DataFinal.getDate();
                if(dataInicial != null && dataFinal != null && DataUtil.compareTo(dataInicial, dataFinal) >= 0) {
                    JOptionPane.showMessageDialog(this, "Data inicial maior que data final", "Erro!", JOptionPane.ERROR_MESSAGE);
                } else {
                    modelo = new ConsultaDetalhadaTableModel();
                    listaDetalhada = pedidoItemDAO.recuperaConsultaDetalhada(clienteLookup.getId(), DataUtil.zeraHora(dataInicial), DataUtil.zeraHora(dataFinal), (String) combo_situacaoPagamento.getSelectedItem());
                    modelo.reload(listaDetalhada);
                    tabela_detalhada.setModel(modelo);
                }
            } catch (ValidateException ex) {
                Logger.getLogger(ConsultaDetalhada.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, informe um cliente antes de pesquisar", "Erro!", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void limpar() {
        listaDetalhada = new ArrayList<>();
        reloadTable();
        texto_codigoCliente.setText("");
        texto_nomeCliente.setText("");
        texto_DataFinal.setDate(null);
        texto_DataInicial.setDate(null);
    }
    
    private void reloadTable() {
        ConsultaDetalhadaTableModel modelo = (ConsultaDetalhadaTableModel) tabela_detalhada.getModel();
        modelo.reload(listaDetalhada);
        tabela_detalhada.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tabela_detalhada.setModel(modelo);
        combo_situacaoPagamento.setSelectedIndex(0);
    }
    
    @Override
    public void setSelecionado(Object obj) {
        if(obj != null) {
            if(obj instanceof Cliente) {
                clienteLookup = (Cliente) obj;
                texto_codigoCliente.setText(clienteLookup.getCodigo());
                texto_nomeCliente.setText(clienteLookup.getNome());
            }
        }
    }
    
    private void carregaLookupCliente() {
        if(StringUtils.isNotEmpty(texto_codigoCliente.getText())) {
            try {
                clienteLookup = clienteDAO.recuperaClientePeloCodigo(texto_codigoCliente.getText());
                if(clienteLookup != null) {
                    texto_nomeCliente.setText(clienteLookup.getNome());
                } else {
                    JOptionPane.showMessageDialog(null, "Cliente não encontrado!", "Erro!", JOptionPane.ERROR_MESSAGE);
                }
            } catch (ValidateException ex) {
                Logger.getLogger(PedidoForm.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
