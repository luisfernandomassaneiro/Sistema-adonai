/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.luismassaneiro.sistemadonai.view.consultas;

import com.luismassaneiro.sistemadonai.controller.ClienteDAO;
import com.luismassaneiro.sistemadonai.controller.DAOFactory;
import com.luismassaneiro.sistemadonai.controller.PedidoItemDAO;
import com.luismassaneiro.sistemadonai.dto.ConsultaDetalhadaCabecalhoDTO;
import com.luismassaneiro.sistemadonai.dto.ConsultaDetalhadaDetalheDTO;
import com.luismassaneiro.sistemadonai.enums.RelatorioDisponivel;
import com.luismassaneiro.sistemadonai.enums.TipoSituacaoProduto;
import com.luismassaneiro.sistemadonai.exceptions.ValidateException;
import com.luismassaneiro.sistemadonai.model.Cliente;
import com.luismassaneiro.sistemadonai.model.PedidoItem;
import com.luismassaneiro.sistemadonai.relatorio.GeradorRelatorio;
import com.luismassaneiro.sistemadonai.utils.DataUtil;
import com.luismassaneiro.sistemadonai.utils.FormatUtils;
import com.luismassaneiro.sistemadonai.utils.TrataExcecao;
import com.luismassaneiro.sistemadonai.view.Selecionador;
import com.luismassaneiro.sistemadonai.view.cadastro.ClienteBrowser;
import com.luismassaneiro.sistemadonai.view.desktop.GerenciadorJanelas;
import com.luismassaneiro.sistemadonai.view.operacoes.PedidoForm;
import com.luismassaneiro.sistemadonai.view.tablemodel.ConsultaDetalhadaTableModel;
import com.luismassaneiro.sistemadonai.view.tablemodel.RelatorioMensalTableModel;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;

/**
 *
 * @author luis.massaneiro
 */
public class RelatorioMensal extends javax.swing.JInternalFrame implements Selecionador<Object> {

    private final ClienteDAO clienteDAO = DAOFactory.criaClienteDAO();
    private final PedidoItemDAO pedidoItemDAO = DAOFactory.criaPedidoItemDAO();
    private RelatorioMensalTableModel modelo;
    private List<ConsultaDetalhadaCabecalhoDTO> lista = new ArrayList<>();
    private Cliente clienteLookup;
    
    public RelatorioMensal() {
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

        botao_limpar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        scrollPane = new javax.swing.JScrollPane();
        tabela_detalhada = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        botao_exportar = new javax.swing.JButton();
        texto_codigoCliente = new javax.swing.JTextField();
        texto_nomeCliente = new javax.swing.JTextField();
        botao_pesquisarCliente = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        combo_situacaoPagamento = new javax.swing.JComboBox<>();
        texto_DataInicial = new javax.swing.JFormattedTextField();
        texto_DataFinal = new javax.swing.JFormattedTextField();
        botao_gerarPDF = new javax.swing.JButton();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Relatório mensal");
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

        jLabel3.setText("Cliente");

        botao_exportar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/luismassaneiro/controleestoque/imagens/print-24.png"))); // NOI18N
        botao_exportar.setText("Imprimir");
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

        try {
            texto_DataInicial.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        texto_DataInicial.setToolTipText("");
        texto_DataInicial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                texto_DataInicialKeyPressed(evt);
            }
        });

        try {
            texto_DataFinal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        texto_DataFinal.setToolTipText("");

        botao_gerarPDF.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/luismassaneiro/controleestoque/imagens/pdf-red-24.png"))); // NOI18N
        botao_gerarPDF.setText("Gerar PDF");
        botao_gerarPDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_gerarPDFActionPerformed(evt);
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
                                .addComponent(jLabel4))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(texto_codigoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(texto_nomeCliente)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(botao_pesquisarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(combo_situacaoPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(texto_DataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(texto_DataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30))
                    .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 761, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(botao_gerarPDF)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botao_exportar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botao_limpar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(texto_codigoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(texto_nomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(botao_pesquisarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(combo_situacaoPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(texto_DataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(texto_DataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(22, 22, 22)
                .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
                .addGap(72, 72, 72)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(botao_limpar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botao_exportar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botao_gerarPDF, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botao_limparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_limparActionPerformed
        limpar();
    }//GEN-LAST:event_botao_limparActionPerformed

    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated
    }//GEN-LAST:event_formInternalFrameActivated

    private void botao_exportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_exportarActionPerformed
        if(CollectionUtils.isNotEmpty(lista)) {
            try {
                imprimirRelatorio();
            } catch (JRException ex) {
                Logger.getLogger(RelatorioMensal.class.getName()).log(Level.SEVERE, null, ex);
                String mensagem = TrataExcecao.trataMensagemErro(ex, RelatorioMensal.class);
                JOptionPane.showMessageDialog(this, mensagem, "Erro ao imprimir relatório!", JOptionPane.ERROR_MESSAGE);
            }
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

    private void botao_gerarPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_gerarPDFActionPerformed
        if(CollectionUtils.isNotEmpty(lista)) {
            try {
            JFileChooser jfc = new javax.swing.JFileChooser();  
            jfc.setFileSelectionMode(javax.swing.JFileChooser.DIRECTORIES_ONLY);  
            jfc.setDialogTitle("Selecione o local do arquivo");
            jfc.setApproveButtonText("Selecionar");
            int res = jfc.showOpenDialog(this);
            String caminhoSalvar = null;
            if(res == JFileChooser.APPROVE_OPTION)
                caminhoSalvar = jfc.getSelectedFile().getAbsolutePath();
            
            if(StringUtils.isNotBlank(caminhoSalvar)) {
                if(gerarRelatorio(caminhoSalvar) != null) {
                    JOptionPane.showMessageDialog(this, "Relatório gerado com sucesso!");
                }
            } else {
               JOptionPane.showMessageDialog(this, "É necessário selecionar o local do arquivo!", "Atenção!", JOptionPane.WARNING_MESSAGE); 
            }
        } catch (JRException ex) {
            Logger.getLogger(RelatorioMensal.class.getName()).log(Level.SEVERE, null, ex);
            String mensagem = TrataExcecao.trataMensagemErro(ex, RelatorioMensal.class);
            JOptionPane.showMessageDialog(this, mensagem, "Erro ao gerar relatório!", JOptionPane.ERROR_MESSAGE);
        }
        } else {
            JOptionPane.showMessageDialog(this, "Não há registros para serem gerados!", "Atenção!", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_botao_gerarPDFActionPerformed

    private void texto_DataInicialKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_texto_DataInicialKeyPressed
        if(evt.getKeyCode() == 10) {
           pesquisar(); 
        }
    }//GEN-LAST:event_texto_DataInicialKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botao_exportar;
    private javax.swing.JButton botao_gerarPDF;
    private javax.swing.JButton botao_limpar;
    private javax.swing.JButton botao_pesquisarCliente;
    private javax.swing.JComboBox<String> combo_situacaoPagamento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JScrollPane scrollPane;
    public javax.swing.JTable tabela_detalhada;
    private javax.swing.JFormattedTextField texto_DataFinal;
    private javax.swing.JFormattedTextField texto_DataInicial;
    private javax.swing.JTextField texto_codigoCliente;
    private javax.swing.JTextField texto_nomeCliente;
    // End of variables declaration//GEN-END:variables

    private void pesquisar() {
        if(clienteLookup != null && clienteLookup.getId() != null) {
            try {
                Date dataInicial = FormatUtils.parseDate(texto_DataInicial.getText());
                Date dataFinal = FormatUtils.parseDate(texto_DataFinal.getText());
                if(dataInicial != null && dataFinal != null && DataUtil.compareTo(dataInicial, dataFinal) > 0) {
                    JOptionPane.showMessageDialog(this, "Data inicial maior que data final", "Erro!", JOptionPane.ERROR_MESSAGE);
                } else {
                    List<PedidoItem> listaItens = pedidoItemDAO.recuperaConsultaDetalhada(clienteLookup.getId(), DataUtil.zeraHora(dataInicial), DataUtil.zeraHora(dataFinal), (String) combo_situacaoPagamento.getSelectedItem());
                    if(CollectionUtils.isEmpty(listaItens))
                        JOptionPane.showMessageDialog(this, "Não encontrou registros com os filtros informados.", "Erro!", JOptionPane.ERROR_MESSAGE);
                        
                    //reloadTable();
                }
            } catch (ParseException | ValidateException ex) {
                Logger.getLogger(RelatorioMensal.class.getName()).log(Level.SEVERE, null, ex);
                String mensagem = TrataExcecao.trataMensagemErro(ex, RelatorioMensal.class);
                JOptionPane.showMessageDialog(this, mensagem, "Erro!", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, informe um cliente antes de pesquisar", "Erro!", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void limpar() {
        lista = new ArrayList<>();
        clienteLookup = null;
        reloadTable();
        texto_codigoCliente.setText("");
        texto_nomeCliente.setText("");
        texto_DataFinal.setText("");
        texto_DataInicial.setText("");
        combo_situacaoPagamento.setSelectedIndex(1);
    }
    
    private void reloadTable() {
        modelo = new RelatorioMensalTableModel();
        modelo.reload(lista);
        tabela_detalhada.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tabela_detalhada.setModel(modelo);
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
                String mensagem = TrataExcecao.trataMensagemErro(ex, RelatorioMensal.class);
                JOptionPane.showMessageDialog(this, mensagem, "Erro!", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    private JasperPrint gerarRelatorio(String caminhoSalvar) throws JRException {
        return GeradorRelatorio.getInstance().gerarRelatorio(RelatorioDisponivel.CONSULTA_DETALHADA, criaListaParaRelatorio(), caminhoSalvar);
    }
    
    public List<ConsultaDetalhadaCabecalhoDTO> criaListaParaRelatorio() {
        List<ConsultaDetalhadaCabecalhoDTO> lista = new ArrayList<>();
        ConsultaDetalhadaCabecalhoDTO cabecalho = null;
        ConsultaDetalhadaDetalheDTO detalhe;
        Integer count = 1;
        for (PedidoItem pedidoItem : lista) {
            if(cabecalho == null) {
                cabecalho = new ConsultaDetalhadaCabecalhoDTO();
                cabecalho.setCliente(clienteLookup.getNome());
                String dataInicial = texto_DataInicial.getText().replace("/", "").trim();
                String dataFinal = texto_DataFinal.getText().replace("/", "").trim();
                StringBuilder periodo = new StringBuilder();
                if(StringUtils.isNotBlank(dataInicial)) {
                    periodo.append(texto_DataInicial.getText());
                }
                if(StringUtils.isNotBlank(dataFinal)) {
                    if(StringUtils.isNotBlank(dataInicial)) {
                        periodo.append(" até ");
                    }
                    periodo.append(texto_DataFinal.getText());
                }
                cabecalho.setPeriodo(periodo.toString());
                cabecalho.setSituacao((String) combo_situacaoPagamento.getSelectedItem());
            }
            
            detalhe = new ConsultaDetalhadaDetalheDTO();
            detalhe.setDataCompra(pedidoItem.getDataCompra());
            detalhe.setDataPagamento(pedidoItem.getDataPagamento());
            detalhe.setProduto(pedidoItem.getProduto().getDescricao());
            detalhe.setQuantidade(pedidoItem.getQuantidade());
            detalhe.setValorTotal(pedidoItem.getValorTotal());
            detalhe.setValorUnitario(pedidoItem.getValor());
            detalhe.setCount(count++);
            cabecalho.add(detalhe);
        }
        
        lista.add(cabecalho);
        return lista;
    }
    
    private void imprimirRelatorio() throws JRException {
        JasperPrint relatorio = GeradorRelatorio.getInstance().gerarRelatorio(RelatorioDisponivel.CONSULTA_DETALHADA, criaListaParaRelatorio(), null);
        GeradorRelatorio.getInstance().imprimirRelatorio(relatorio, iconable);
    }
}
