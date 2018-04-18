/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.luismassaneiro.sistemadonai.view.consultas;

import com.luismassaneiro.sistemadonai.controller.ClienteDAO;
import com.luismassaneiro.sistemadonai.controller.DAOFactory;
import com.luismassaneiro.sistemadonai.dto.ConsultaEmAbertoCabecalhoDTO;
import com.luismassaneiro.sistemadonai.dto.ConsultaEmAbertoDTO;
import com.luismassaneiro.sistemadonai.dto.ConsultaEmAbertoDetalheDTO;
import com.luismassaneiro.sistemadonai.enums.RelatorioDisponivel;
import com.luismassaneiro.sistemadonai.exceptions.ValidateException;
import com.luismassaneiro.sistemadonai.relatorio.GeradorRelatorio;
import com.luismassaneiro.sistemadonai.utils.DataUtil;
import com.luismassaneiro.sistemadonai.utils.FormatUtils;
import com.luismassaneiro.sistemadonai.utils.TrataExcecao;
import com.luismassaneiro.sistemadonai.view.tablemodel.ConsultaEmAbertoTableModel;
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
public class ConsultaEmAberto extends javax.swing.JInternalFrame {

    private final ClienteDAO dao = DAOFactory.criaClienteDAO();
    private ConsultaEmAbertoTableModel modelo;
    private List<ConsultaEmAbertoDTO> listaEmAberto = new ArrayList<>();
    
    public ConsultaEmAberto() {
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
        tabela_emAberto = new javax.swing.JTable();
        botao_Pesquisar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        texto_codigo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        texto_nome = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        texto_DataInicial = new javax.swing.JFormattedTextField();
        texto_DataFinal = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        texto_total = new javax.swing.JTextField();
        botao_gerarPDF = new javax.swing.JButton();
        botao_exportar1 = new javax.swing.JButton();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Em aberto");
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

        tabela_emAberto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        scrollPane.setViewportView(tabela_emAberto);

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

        try {
            texto_DataInicial.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        texto_DataInicial.setToolTipText("");

        try {
            texto_DataFinal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        texto_DataFinal.setToolTipText("");

        jLabel5.setText("Total:");

        texto_total.setEditable(false);

        botao_gerarPDF.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/luismassaneiro/controleestoque/imagens/pdf-red-24.png"))); // NOI18N
        botao_gerarPDF.setText("Gerar PDF");
        botao_gerarPDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_gerarPDFActionPerformed(evt);
            }
        });

        botao_exportar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/luismassaneiro/controleestoque/imagens/print-24.png"))); // NOI18N
        botao_exportar1.setText("Imprimir");
        botao_exportar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_exportar1ActionPerformed(evt);
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
                    .addComponent(scrollPane, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(texto_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(texto_nome, javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
                            .addComponent(jLabel4))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(texto_DataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(texto_DataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(147, 147, 147))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(botao_Pesquisar, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(texto_total, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(botao_gerarPDF)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(botao_exportar1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(botao_limpar)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(botao_Pesquisar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
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
                    .addComponent(texto_DataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(texto_DataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(texto_total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botao_limpar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botao_exportar1)
                    .addComponent(botao_gerarPDF))
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

    private void botao_gerarPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_gerarPDFActionPerformed
        if(CollectionUtils.isNotEmpty(listaEmAberto)) {
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
            Logger.getLogger(ConsultaDetalhada.class.getName()).log(Level.SEVERE, null, ex);
            String mensagem = TrataExcecao.trataMensagemErro(ex, ConsultaDetalhada.class);
            JOptionPane.showMessageDialog(this, mensagem, "Erro ao gerar relatório!", JOptionPane.ERROR_MESSAGE);
        }
        } else {
            JOptionPane.showMessageDialog(this, "Não há registros para serem gerados!", "Atenção!", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_botao_gerarPDFActionPerformed

    private void botao_exportar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_exportar1ActionPerformed
        if(CollectionUtils.isNotEmpty(listaEmAberto)) {
            try {
                imprimirRelatorio();
            } catch (JRException ex) {
                Logger.getLogger(ConsultaDetalhada.class.getName()).log(Level.SEVERE, null, ex);
                String mensagem = TrataExcecao.trataMensagemErro(ex, ConsultaDetalhada.class);
                JOptionPane.showMessageDialog(this, mensagem, "Erro ao imprimir relatório!", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Não há registros para serem exportados!", "Atenção!", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_botao_exportar1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botao_Pesquisar;
    private javax.swing.JButton botao_exportar1;
    private javax.swing.JButton botao_gerarPDF;
    private javax.swing.JButton botao_limpar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JScrollPane scrollPane;
    public javax.swing.JTable tabela_emAberto;
    private javax.swing.JFormattedTextField texto_DataFinal;
    private javax.swing.JFormattedTextField texto_DataInicial;
    private javax.swing.JTextField texto_codigo;
    private javax.swing.JTextField texto_nome;
    private javax.swing.JTextField texto_total;
    // End of variables declaration//GEN-END:variables

    private void pesquisar() {
        try {
            Date dataInicial = FormatUtils.parseDate(texto_DataInicial.getText());
            Date dataFinal = FormatUtils.parseDate(texto_DataFinal.getText());
            if(dataInicial != null && dataFinal != null && DataUtil.compareTo(dataInicial, dataFinal) > 0) {
                JOptionPane.showMessageDialog(this, "Data inicial maior que data final", "Erro!", JOptionPane.ERROR_MESSAGE);
            } else {
                listaEmAberto = dao.recuperaClienteEmAberto(texto_codigo.getText(),texto_nome.getText(), DataUtil.zeraHora(dataInicial), DataUtil.zeraHora(dataFinal));
                if(CollectionUtils.isEmpty(listaEmAberto))
                        JOptionPane.showMessageDialog(this, "Não encontrou registros com os filtros informados.", "Erro!", JOptionPane.ERROR_MESSAGE);
                
                reloadTable();
                atualizaTotal();
            }
        } catch (ParseException | ValidateException ex) {
            Logger.getLogger(ConsultaEmAberto.class.getName()).log(Level.SEVERE, null, ex);
            String mensagem = TrataExcecao.trataMensagemErro(ex, ConsultaEmAberto.class);
            JOptionPane.showMessageDialog(this, mensagem, "Erro!", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void limpar() {
        listaEmAberto = new ArrayList<>();
        reloadTable();
        atualizaTotal();
        texto_codigo.setText("");
        texto_nome.setText("");
        texto_DataInicial.setText("");
        texto_DataFinal.setText("");
    }
    
    private void reloadTable() {
        modelo = new ConsultaEmAbertoTableModel();
        modelo.reload(listaEmAberto);
        tabela_emAberto.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tabela_emAberto.setModel(modelo);
    }
    
    private void atualizaTotal() {
        BigDecimal total = BigDecimal.ZERO;
        if(CollectionUtils.isNotEmpty(listaEmAberto)) {
            for (ConsultaEmAbertoDTO umItem : listaEmAberto) {
                total = total.add(umItem.getValorTotalDevido());
            }
        } 
        texto_total.setText(FormatUtils.formatBigDecimal(total));
    }
    
    private JasperPrint gerarRelatorio(String caminhoSalvar) throws JRException {
        return GeradorRelatorio.getInstance().gerarRelatorio(RelatorioDisponivel.CONSULTA_EM_ABERTO, criaListaParaRelatorio(), caminhoSalvar);
    }
    
    public List<ConsultaEmAbertoCabecalhoDTO> criaListaParaRelatorio() {
        List<ConsultaEmAbertoCabecalhoDTO> lista = new ArrayList<>();
        ConsultaEmAbertoCabecalhoDTO cabecalho = null;
        ConsultaEmAbertoDetalheDTO detalhe;
        Integer count = 1;
        for (ConsultaEmAbertoDTO umItem : listaEmAberto) {
            if(cabecalho == null) {
                cabecalho = new ConsultaEmAbertoCabecalhoDTO();
                cabecalho.setCodigoCliente(texto_codigo.getText());
                cabecalho.setNomeCliente(texto_nome.getText());
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
            }
            
            detalhe = new ConsultaEmAbertoDetalheDTO();
            detalhe.setCount(count++);
            detalhe.setCodigoCliente(umItem.getCodigoCliente());
            detalhe.setNomeCliente(umItem.getNomeCliente());
            detalhe.setValorTotalDevido(umItem.getValorTotalDevido());
            cabecalho.add(detalhe);
        }
        
        lista.add(cabecalho);
        return lista;
    }
    
    private void imprimirRelatorio() throws JRException {
        JasperPrint relatorio = GeradorRelatorio.getInstance().gerarRelatorio(RelatorioDisponivel.CONSULTA_EM_ABERTO, criaListaParaRelatorio(), null);
        GeradorRelatorio.getInstance().imprimirRelatorio(relatorio, iconable);
    }
}
