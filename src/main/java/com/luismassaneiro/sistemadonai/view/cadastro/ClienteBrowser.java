/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.luismassaneiro.sistemadonai.view.cadastro;

import com.luismassaneiro.sistemadonai.controller.ClienteDAO;
import com.luismassaneiro.sistemadonai.controller.DAOFactory;
import com.luismassaneiro.sistemadonai.model.Cliente;
import com.luismassaneiro.sistemadonai.utils.TrataExcecao;
import com.luismassaneiro.sistemadonai.view.Selecionador;
import com.luismassaneiro.sistemadonai.view.Selecionavel;
import com.luismassaneiro.sistemadonai.view.desktop.GerenciadorJanelas;
import com.luismassaneiro.sistemadonai.view.tablemodel.ClienteSimpleTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;

/**ow
 *
 * @author luis.massaneiro
 */
public class ClienteBrowser extends javax.swing.JInternalFrame implements Selecionavel<Object> {

    private ClienteForm form;
    private final ClienteDAO dao = DAOFactory.criaClienteDAO();
    private Selecionador<Object> formSelecionador;
    
    public ClienteBrowser() {
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

        scrollPane = new javax.swing.JScrollPane();
        tabela_cliente = new javax.swing.JTable();
        botao_Pesquisar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        flagAtivo = new javax.swing.JCheckBox();
        texto_nome = new javax.swing.JTextField();
        botao_Novo = new javax.swing.JButton();
        botao_Alterar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        texto_codigo = new javax.swing.JTextField();
        botao_Retornar = new javax.swing.JButton();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Consulta de categoria");
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

        tabela_cliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tabela_cliente.setColumnSelectionAllowed(true);
        scrollPane.setViewportView(tabela_cliente);

        botao_Pesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/luismassaneiro/controleestoque/imagens/search26.png"))); // NOI18N
        botao_Pesquisar.setText("Pesquisar");
        botao_Pesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_PesquisarActionPerformed(evt);
            }
        });

        jLabel1.setText("Nome");

        flagAtivo.setSelected(true);
        flagAtivo.setText("Somente ativos");
        flagAtivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                flagAtivoActionPerformed(evt);
            }
        });

        texto_nome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                texto_nomeKeyReleased(evt);
            }
        });

        botao_Novo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/luismassaneiro/controleestoque/imagens/new.png"))); // NOI18N
        botao_Novo.setText("Novo");
        botao_Novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_NovoActionPerformed(evt);
            }
        });

        botao_Alterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/luismassaneiro/controleestoque/imagens/edit.png"))); // NOI18N
        botao_Alterar.setText("Alterar");
        botao_Alterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_AlterarActionPerformed(evt);
            }
        });

        jLabel2.setText("Código");

        texto_codigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                texto_codigoKeyReleased(evt);
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
            .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 552, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(botao_Novo)
                                .addGap(18, 18, 18)
                                .addComponent(botao_Alterar))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(botao_Retornar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(botao_Pesquisar)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(texto_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38)
                                .addComponent(texto_nome, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(flagAtivo))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(141, 141, 141)
                                .addComponent(jLabel1)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botao_Pesquisar)
                    .addComponent(botao_Retornar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(texto_nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(texto_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(flagAtivo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botao_Novo)
                    .addComponent(botao_Alterar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void flagAtivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_flagAtivoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_flagAtivoActionPerformed

    private void texto_nomeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_texto_nomeKeyReleased
        pesquisar();
    }//GEN-LAST:event_texto_nomeKeyReleased

    private void botao_PesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_PesquisarActionPerformed
        pesquisar();
    }//GEN-LAST:event_botao_PesquisarActionPerformed

    private void botao_NovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_NovoActionPerformed
        openForm(null);
    }//GEN-LAST:event_botao_NovoActionPerformed

    private void botao_AlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_AlterarActionPerformed
        Cliente model = getClienteSelecionado();
        if(model != null)
            openForm(model);
    }//GEN-LAST:event_botao_AlterarActionPerformed

    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated
        pesquisar();
    }//GEN-LAST:event_formInternalFrameActivated

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        tabela_cliente.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    Cliente cliente = getClienteSelecionado();
                    openForm(cliente);
                }
            }
        });
    }//GEN-LAST:event_formInternalFrameOpened

    private void texto_codigoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_texto_codigoKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_texto_codigoKeyReleased

    private void botao_RetornarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_RetornarActionPerformed
        Cliente clienteSelecionado = getClienteSelecionado();
        if(clienteSelecionado == null) {
            JOptionPane.showMessageDialog(this, "Nenhum cliente selecionado!", "Alerta", JOptionPane.WARNING_MESSAGE);
        } else {
            formSelecionador.setSelecionado(clienteSelecionado);
            hide();
        }
    }//GEN-LAST:event_botao_RetornarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botao_Alterar;
    private javax.swing.JButton botao_Novo;
    private javax.swing.JButton botao_Pesquisar;
    private javax.swing.JButton botao_Retornar;
    private javax.swing.JCheckBox flagAtivo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JScrollPane scrollPane;
    public javax.swing.JTable tabela_cliente;
    private javax.swing.JTextField texto_codigo;
    private javax.swing.JTextField texto_nome;
    // End of variables declaration//GEN-END:variables

    private void pesquisar() {
        try {
            String nome = texto_nome.getText();
            ClienteSimpleTableModel modelo = new ClienteSimpleTableModel();
            boolean somenteAtivo = flagAtivo.isSelected();
            List<Cliente> listaCliente;
            listaCliente = dao.recuperaClientesComFiltros(texto_codigo.getText(), texto_nome.getText(), somenteAtivo);
            modelo.reload(listaCliente);
            tabela_cliente.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            tabela_cliente.setModel(modelo);
            
        } catch (Exception ex) {
            Logger.getLogger(ProdutoBrowser.class.getName()).log(Level.SEVERE, null, ex);
            String mensagem = TrataExcecao.trataMensagemErro(ex, ClienteBrowser.class);
            JOptionPane.showMessageDialog(this, mensagem, "Erro!", JOptionPane.ERROR_MESSAGE);
        }
    }
 
    private void openForm(Cliente cliente) {
        if (form == null)
            form = new ClienteForm();
        form.setModel(cliente);
        GerenciadorJanelas.getInstance().abrirJanela(form).setVisible(true);
    }
  
    private Cliente getClienteSelecionado() {
        if (tabela_cliente.getSelectedRow() == -1)
            return null;
        
        ClienteSimpleTableModel modelo = (ClienteSimpleTableModel) tabela_cliente.getModel();
        Cliente clienteSelecionado = modelo.getClienteAt(tabela_cliente.getSelectedRow());
        return clienteSelecionado;
    }

    @Override
    public void showWindow(Selecionador<Object> formSelecionador) {
        this.formSelecionador = formSelecionador;
        if(formSelecionador != null) {
            botao_Retornar.setVisible(true);
        } else {
            botao_Retornar.setVisible(false);
        }
    }

    public Selecionador<Object> getFormSelecionador() {
        return formSelecionador;
    }

    public void setFormSelecionador(Selecionador<Object> formSelecionador) {
        this.formSelecionador = formSelecionador;
    }
    
}