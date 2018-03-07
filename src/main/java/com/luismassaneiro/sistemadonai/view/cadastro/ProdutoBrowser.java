/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.luismassaneiro.sistemadonai.view.cadastro;

import com.luismassaneiro.sistemadonai.controller.DAOFactory;
import com.luismassaneiro.sistemadonai.controller.ProdutoDAO;
import com.luismassaneiro.sistemadonai.exceptions.ValidateException;
import com.luismassaneiro.sistemadonai.model.Produto;
import com.luismassaneiro.sistemadonai.view.tablemodel.ProdutoTableModel;
import com.luismassaneiro.sistemadonai.view.Selecionador;
import com.luismassaneiro.sistemadonai.view.Selecionavel;
import com.luismassaneiro.sistemadonai.view.desktop.GerenciadorJanelas;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author luis.massaneiro
 */
public class ProdutoBrowser extends javax.swing.JInternalFrame implements Selecionavel<Produto> {

    private ProdutoForm form;
    private final ProdutoDAO dao = DAOFactory.criaProdutoDAO();
    private Selecionador<Produto> formSelecionador;
    
    public ProdutoBrowser() {
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

        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        texto_Codigo = new javax.swing.JTextField();
        scrollPane = new javax.swing.JScrollPane();
        tabela_Produto = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        botao_Novo = new javax.swing.JButton();
        botao_Pesquisar = new javax.swing.JButton();
        texto_Descricao = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        flagAtivo = new javax.swing.JCheckBox();
        botao_Retornar = new javax.swing.JButton();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Listagem de produtos");
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

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/luismassaneiro/controleestoque/imagens/edit.png"))); // NOI18N
        jButton2.setText("Alterar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel2.setText("Código");

        texto_Codigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                texto_CodigoKeyReleased(evt);
            }
        });

        tabela_Produto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        scrollPane.setViewportView(tabela_Produto);

        botao_Novo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/luismassaneiro/controleestoque/imagens/new.png"))); // NOI18N
        botao_Novo.setText("Novo");
        botao_Novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_NovoActionPerformed(evt);
            }
        });

        botao_Pesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/luismassaneiro/controleestoque/imagens/search26.png"))); // NOI18N
        botao_Pesquisar.setText("Pesquisar");
        botao_Pesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_PesquisarActionPerformed(evt);
            }
        });

        texto_Descricao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                texto_DescricaoKeyReleased(evt);
            }
        });

        jLabel1.setText("Descrição");

        flagAtivo.setSelected(true);
        flagAtivo.setText("Somente ativos");
        flagAtivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                flagAtivoActionPerformed(evt);
            }
        });

        botao_Retornar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/luismassaneiro/controleestoque/imagens/return-24.png"))); // NOI18N
        botao_Retornar.setText("Retornar");
        botao_Retornar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_RetornarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(texto_Codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(46, 46, 46)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(texto_Descricao, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(botao_Retornar)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(flagAtivo)
                            .addComponent(botao_Pesquisar)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botao_Novo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 636, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botao_Pesquisar)
                    .addComponent(botao_Retornar))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(flagAtivo, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(texto_Codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(texto_Descricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botao_Novo)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Produto model = getProdutoSelecionada();
        if(model != null)
            openForm(model);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void texto_CodigoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_texto_CodigoKeyReleased
        pesquisar();
    }//GEN-LAST:event_texto_CodigoKeyReleased

    private void botao_NovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_NovoActionPerformed
        openForm(null);
    }//GEN-LAST:event_botao_NovoActionPerformed

    private void botao_PesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_PesquisarActionPerformed
        pesquisar();
    }//GEN-LAST:event_botao_PesquisarActionPerformed

    private void texto_DescricaoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_texto_DescricaoKeyReleased
        pesquisar();
    }//GEN-LAST:event_texto_DescricaoKeyReleased

    private void flagAtivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_flagAtivoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_flagAtivoActionPerformed

    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated
        pesquisar();
        if(formSelecionador != null) {
            botao_Retornar.setVisible(true);
        } else {
            botao_Retornar.setVisible(false);
        }
    }//GEN-LAST:event_formInternalFrameActivated

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        tabela_Produto.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    Produto produto = getProdutoSelecionada();                    
                    openForm(produto);
                }
            }
        });
    }//GEN-LAST:event_formInternalFrameOpened

    private void botao_RetornarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_RetornarActionPerformed
        Produto produtoSelecionado = getProdutoSelecionada();
        if(produtoSelecionado == null) {
            JOptionPane.showMessageDialog(this, "Nenhum produto selecionado!", "Alerta", JOptionPane.WARNING_MESSAGE);
        } else {
            formSelecionador.setSelecionado(produtoSelecionado);
            hide();
        }
    }//GEN-LAST:event_botao_RetornarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botao_Novo;
    private javax.swing.JButton botao_Pesquisar;
    private javax.swing.JButton botao_Retornar;
    private javax.swing.JCheckBox flagAtivo;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JScrollPane scrollPane;
    public javax.swing.JTable tabela_Produto;
    private javax.swing.JTextField texto_Codigo;
    private javax.swing.JTextField texto_Descricao;
    // End of variables declaration//GEN-END:variables

    private void pesquisar() {
        try {
            String codigo = texto_Codigo.getText();
            String descricao = texto_Descricao.getText();
            ProdutoTableModel modelo = new ProdutoTableModel();
            List<Produto> listaProduto;
            listaProduto = dao.recuperaProdutoComFiltros(codigo, descricao.concat("%"), flagAtivo.isSelected());
            modelo.reload(listaProduto);
            tabela_Produto.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            tabela_Produto.setModel(modelo);
            defineRenderers();
        } catch (ValidateException ex) {
            Logger.getLogger(ProdutoBrowser.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
        }
    }
 
    private void openForm(Produto produto) {
        if (form == null)
            form = new ProdutoForm();
        form.setModel(produto);
        GerenciadorJanelas.getInstance().abrirJanela(form).setVisible(true);
    }
  
    private Produto getProdutoSelecionada() {
        if (tabela_Produto.getSelectedRow() == -1)
            return null;
        
        ProdutoTableModel modelo = (ProdutoTableModel) tabela_Produto.getModel();
        Produto produtoSelecionado = modelo.getProdutoAt(tabela_Produto.getSelectedRow());
        return produtoSelecionado;
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
        
        //Valor
        modeloDaColuna.getColumn(2).setCellRenderer(rendererCentro);  
        modeloDaColuna.getColumn(2).setMinWidth(25);  
        
    }

    @Override
    public void showWindow(Selecionador<Produto> formSelecionador) {
        this.formSelecionador = formSelecionador;
        if(formSelecionador != null) {
            botao_Retornar.setVisible(true);
        } else {
            botao_Retornar.setVisible(false);
        }
    }

    public Selecionador<Produto> getFormSelecionador() {
        return formSelecionador;
    }

    public void setFormSelecionador(Selecionador<Produto> formSelecionador) {
        this.formSelecionador = formSelecionador;
    }
}
