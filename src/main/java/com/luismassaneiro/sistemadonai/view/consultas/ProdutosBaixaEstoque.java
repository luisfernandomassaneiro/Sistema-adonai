/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.luismassaneiro.sistemadonai.view.consultas;

import com.luismassaneiro.sistemadonai.controller.DAOFactory;
import com.luismassaneiro.sistemadonai.controller.ProdutoDAO;
import com.luismassaneiro.sistemadonai.exceptions.ValidateException;
import com.luismassaneiro.sistemadonai.model.Produto;
import com.luismassaneiro.sistemadonai.view.desktop.GerenciadorJanelas;
import com.luismassaneiro.sistemadonai.view.exportador.ExportadorTabelas;
import com.luismassaneiro.sistemadonai.view.tablemodel.ProdutoSimpleTableModel;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;

/**
 *
 * @author luis.massaneiro
 */
public class ProdutosBaixaEstoque extends javax.swing.JInternalFrame {

    private final ProdutoDAO dao = DAOFactory.criaProdutoDAO();
    private ProdutoSimpleTableModel modelo;
    private List<Produto> listaProduto = new ArrayList<>();
    
    public ProdutosBaixaEstoque() {
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

        jLabel3 = new javax.swing.JLabel();
        botao_Atualizar = new javax.swing.JButton();
        botao_Exportar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        texto_Descricao = new javax.swing.JTextField();
        scrollPane = new javax.swing.JScrollPane();
        tabela_Produto = new javax.swing.JTable();
        combo_Categoria = new javax.swing.JComboBox();
        botao_Pesquisar = new javax.swing.JButton();
        texto_Codigo = new javax.swing.JTextField();
        flagAtivo = new javax.swing.JCheckBox();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Produtos em baixa no estoque");
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
                formInternalFrameOpened(evt);
            }
        });

        jLabel3.setText("Categoria");

        botao_Atualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/luismassaneiro/controleestoque/imagens/update-24.png"))); // NOI18N
        botao_Atualizar.setText("Atualizar estoque");
        botao_Atualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_AtualizarActionPerformed(evt);
            }
        });

        botao_Exportar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/luismassaneiro/controleestoque/imagens/export-24.png"))); // NOI18N
        botao_Exportar.setText("Expotar");
        botao_Exportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_ExportarActionPerformed(evt);
            }
        });

        jLabel1.setText("Descrição");

        jLabel2.setText("Código");

        texto_Descricao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                texto_DescricaoKeyReleased(evt);
            }
        });

        tabela_Produto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        scrollPane.setViewportView(tabela_Produto);

        combo_Categoria.setName(""); // NOI18N

        botao_Pesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/luismassaneiro/controleestoque/imagens/search26.png"))); // NOI18N
        botao_Pesquisar.setText("Pesquisar");
        botao_Pesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_PesquisarActionPerformed(evt);
            }
        });

        texto_Codigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                texto_CodigoKeyReleased(evt);
            }
        });

        flagAtivo.setSelected(true);
        flagAtivo.setText("Somente ativos");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(texto_Codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(texto_Descricao, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 252, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(botao_Exportar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(botao_Atualizar))
                            .addComponent(botao_Pesquisar, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(259, 259, 259))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(combo_Categoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(flagAtivo))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(scrollPane, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(botao_Pesquisar)
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(combo_Categoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(texto_Descricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(texto_Codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(flagAtivo))
                .addGap(18, 18, 18)
                .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botao_Atualizar)
                    .addComponent(botao_Exportar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botao_AtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_AtualizarActionPerformed
        Produto produtoSelecionado = getProdutoSelecionado();
        if(produtoSelecionado != null) {
        }
    }//GEN-LAST:event_botao_AtualizarActionPerformed

    private void botao_ExportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_ExportarActionPerformed
        if(CollectionUtils.isNotEmpty(listaProduto)) {
            List<String> linhasArquivo = new ArrayList<>();
            linhasArquivo.add("Código;Descrição;Qtd. Atual;Qtd. Mínima;Categoria");
            for(Produto umProduto: listaProduto) {
                String linha = String.format("%s;%s;%s;%s;%s",
                        umProduto.getCodigo(),
                        umProduto.getDescricao()
                );
                linhasArquivo.add(linha);
            }
            ExportadorTabelas exportador = (ExportadorTabelas) GerenciadorJanelas.getInstance().abrirJanela(new ExportadorTabelas());
            exportador.adicionaListaLinhasArquivo(linhasArquivo, "produtosBaixaEstoque");
            exportador.setVisible(true);
            //ExportadorPlanilha.exportaTabela(this, linhasArquivo);
        } else {
            JOptionPane.showMessageDialog(this, "Não há registros para serem exportados!", "Atenção!", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_botao_ExportarActionPerformed

    private void texto_DescricaoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_texto_DescricaoKeyReleased
        pesquisar();
    }//GEN-LAST:event_texto_DescricaoKeyReleased

    private void botao_PesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_PesquisarActionPerformed
        pesquisar();
    }//GEN-LAST:event_botao_PesquisarActionPerformed

    private void texto_CodigoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_texto_CodigoKeyReleased
        pesquisar();
    }//GEN-LAST:event_texto_CodigoKeyReleased

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        populaComboCategoria();
    }//GEN-LAST:event_formInternalFrameOpened

    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated
        pesquisar();
    }//GEN-LAST:event_formInternalFrameActivated


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botao_Atualizar;
    private javax.swing.JButton botao_Exportar;
    private javax.swing.JButton botao_Pesquisar;
    private javax.swing.JComboBox combo_Categoria;
    private javax.swing.JCheckBox flagAtivo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JScrollPane scrollPane;
    public javax.swing.JTable tabela_Produto;
    private javax.swing.JTextField texto_Codigo;
    private javax.swing.JTextField texto_Descricao;
    // End of variables declaration//GEN-END:variables

    private void pesquisar() {
        try {
            modelo = new ProdutoSimpleTableModel();
            boolean somenteAtivo = flagAtivo.isSelected();
            String codigo = null;
            if(StringUtils.isNotEmpty(texto_Codigo.getText()))
                    codigo = texto_Codigo.getText().concat("%");
            
            String descricao = null;
            if(StringUtils.isNotEmpty(texto_Descricao.getText()))
                    codigo = texto_Descricao.getText().concat("%");
            
            
            listaProduto = dao.recuperaProdutoEmFaltaEstoque(codigo, descricao, getCategoriaSelecionadaID(), somenteAtivo);
            modelo.reload(listaProduto);
            tabela_Produto.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            tabela_Produto.setModel(modelo);
            defineRenderers();
        } catch (ValidateException ex) {
            Logger.getLogger(ProdutosBaixaEstoque.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private Long getCategoriaSelecionadaID() {
        return null;
    }
    
    private void populaComboCategoria() {
        combo_Categoria.removeAllItems();
    }
    
    private void defineRenderers() {  
        DefaultTableCellRenderer rendererCentro = new DefaultTableCellRenderer();  
        rendererCentro.setHorizontalAlignment(SwingConstants.CENTER);  
        DefaultTableCellRenderer rendererDireita = new DefaultTableCellRenderer();  
        rendererDireita.setHorizontalAlignment(SwingConstants.RIGHT);  
        DefaultTableCellRenderer rendererEsquerda = new DefaultTableCellRenderer();  
        rendererEsquerda.setHorizontalAlignment(SwingConstants.LEFT);  

        JTableHeader header = tabela_Produto.getTableHeader();   
        header.setPreferredSize(new Dimension(0, 35));   
        TableColumnModel modeloDaColuna = tabela_Produto.getColumnModel();  

        //Código
        modeloDaColuna.getColumn(0).setCellRenderer(rendererEsquerda);  
        modeloDaColuna.getColumn(0).setMinWidth(50);  
        
        //Descrição
        modeloDaColuna.getColumn(1).setCellRenderer(rendererEsquerda);  
        modeloDaColuna.getColumn(1).setMinWidth(150);  
        
        //Quantidade atual
        modeloDaColuna.getColumn(2).setCellRenderer(rendererCentro);  
        modeloDaColuna.getColumn(2).setMinWidth(8);  
        
        //Quantidade mínima
        modeloDaColuna.getColumn(3).setCellRenderer(rendererCentro);  
        modeloDaColuna.getColumn(3).setMinWidth(8); 
        
        //Categoria
        modeloDaColuna.getColumn(4).setCellRenderer(rendererEsquerda);  
        modeloDaColuna.getColumn(4).setMinWidth(150);  
    }
    
    private Produto getProdutoSelecionado() {
        if (tabela_Produto.getSelectedRow() == -1)
            return null;
        
        modelo = (ProdutoSimpleTableModel) tabela_Produto.getModel();
        Produto produtoSelecionado = modelo.getProdutoAt(tabela_Produto.getSelectedRow());
        return produtoSelecionado;
    }
}
