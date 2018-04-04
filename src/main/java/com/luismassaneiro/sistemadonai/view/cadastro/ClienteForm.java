/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.luismassaneiro.sistemadonai.view.cadastro;

import com.luismassaneiro.sistemadonai.controller.ClienteDAO;
import com.luismassaneiro.sistemadonai.controller.DAOFactory;
import static com.luismassaneiro.sistemadonai.enums.MensagemFixas.CAMPO_EXISTENTE;
import static com.luismassaneiro.sistemadonai.enums.MensagemFixas.CAMPO_OBRIGATORIO;
import com.luismassaneiro.sistemadonai.exceptions.ValidateException;
import com.luismassaneiro.sistemadonai.helper.ClienteHelper;
import com.luismassaneiro.sistemadonai.model.Cliente;
import com.luismassaneiro.sistemadonai.utils.FormatUtils;
import com.luismassaneiro.sistemadonai.utils.TrataExcecao;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author luis.massaneiro
 */
public class ClienteForm extends javax.swing.JInternalFrame {

    private Cliente model;
    private final ClienteDAO dao = DAOFactory.criaClienteDAO();
    
    public ClienteForm() {
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

        jScrollBar1 = new javax.swing.JScrollBar();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        checkBox_Ativo = new javax.swing.JCheckBox();
        jLabel5 = new javax.swing.JLabel();
        texto_telefoneCelular = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        texto_nome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        texto_telefoneResidencial = new javax.swing.JFormattedTextField();
        lbMessages = new javax.swing.JLabel();
        texto_Codigo = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        texto_documento = new javax.swing.JTextField();
        texto_rua = new javax.swing.JTextField();
        texto_numero = new javax.swing.JTextField();
        texto_bairro = new javax.swing.JTextField();
        texto_cidade = new javax.swing.JTextField();
        texto_cep = new javax.swing.JFormattedTextField();
        texto_estado = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        botao_Novo = new javax.swing.JButton();
        botao_Gravar = new javax.swing.JButton();
        texto_dataNascimento = new javax.swing.JFormattedTextField();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Cadastro de cliente");
        setToolTipText("");
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

        jLabel6.setText("Telefone celular");

        jLabel1.setText("Código");

        jLabel4.setText("Bairro");

        checkBox_Ativo.setSelected(true);
        checkBox_Ativo.setText("Ativo");
        checkBox_Ativo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBox_AtivoActionPerformed(evt);
            }
        });

        jLabel5.setText("Rua");

        try {
            texto_telefoneCelular.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)#####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel2.setText("Nome");

        jLabel7.setText("Data de nascimento");

        texto_nome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                texto_nomeActionPerformed(evt);
            }
        });

        jLabel3.setText("Telefone residencial/comercial");

        try {
            texto_telefoneResidencial.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        texto_telefoneResidencial.setToolTipText("");

        lbMessages.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbMessages.setForeground(new java.awt.Color(255, 0, 0));
        lbMessages.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbMessages.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lbMessages.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        jLabel8.setText("Número");

        jLabel9.setText("CEP");

        jLabel10.setText("Cidade");

        jLabel12.setText("Documento");

        texto_documento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                texto_documentoActionPerformed(evt);
            }
        });

        try {
            texto_cep.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel11.setText("Estado");

        botao_Novo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/luismassaneiro/controleestoque/imagens/new.png"))); // NOI18N
        botao_Novo.setText("Novo");
        botao_Novo.setMaximumSize(new java.awt.Dimension(93, 33));
        botao_Novo.setMinimumSize(new java.awt.Dimension(93, 33));
        botao_Novo.setPreferredSize(new java.awt.Dimension(93, 33));
        botao_Novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_NovoActionPerformed(evt);
            }
        });

        botao_Gravar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/luismassaneiro/controleestoque/imagens/save.png"))); // NOI18N
        botao_Gravar.setText("Gravar");
        botao_Gravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_GravarActionPerformed(evt);
            }
        });

        try {
            texto_dataNascimento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        texto_dataNascimento.setToolTipText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbMessages, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(botao_Gravar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botao_Novo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                                        .addGap(110, 110, 110))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(texto_Codigo, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(texto_dataNascimento, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(texto_telefoneResidencial, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGap(124, 124, 124))
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGap(48, 48, 48)))
                                        .addGap(14, 14, 14)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
                                        .addGap(301, 301, 301))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(texto_nome, javax.swing.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE)
                                        .addGap(2, 2, 2))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(texto_documento, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE))
                                        .addGap(203, 203, 203))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(texto_telefoneCelular, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE))
                                        .addGap(203, 203, 203))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGap(115, 115, 115))
                                            .addComponent(texto_bairro, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
                                                .addGap(85, 85, 85))
                                            .addComponent(texto_cidade)))
                                    .addComponent(texto_rua))
                                .addGap(22, 22, 22)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(148, 148, 148))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(3, 3, 3)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(texto_numero)
                                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(16, 16, 16)
                                                .addComponent(texto_cep))))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(texto_estado)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))))
                        .addComponent(checkBox_Ativo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lbMessages)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(texto_Codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(checkBox_Ativo)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(texto_nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(26, 26, 26))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(texto_documento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(texto_dataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(texto_telefoneResidencial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(texto_telefoneCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel9)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(texto_rua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(texto_numero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(texto_cep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(texto_bairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(texto_cidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(texto_estado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botao_Gravar)
                    .addComponent(botao_Novo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botao_GravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_GravarActionPerformed
        try {
            model.setCodigo(texto_Codigo.getText());
            model.setAtivo(checkBox_Ativo.isSelected());
            model.setNome(texto_nome.getText());
            model.setDataNascimento(FormatUtils.parseDate(texto_dataNascimento.getText()));
            model.setDocumento(texto_documento.getText());
            model.setTelefoneResidencial(texto_telefoneResidencial.getText());
            model.setTelefoneCelular(texto_telefoneCelular.getText());
            model.setRua(texto_rua.getText());
            model.setNumero(texto_numero.getText());
            model.setCep(texto_cep.getText());
            model.setCidade(texto_cidade.getText());
            model.setBairro(texto_bairro.getText());
            model.setEstado(texto_estado.getText());
            ClienteHelper.getInstance().validaCamposObrigatorios(model);
            ClienteHelper.getInstance().validaDuplicidade(model);
            lbMessages.setText("");
            pack();
            model = dao.atualizar(model);
            JOptionPane.showMessageDialog(this, "Registrado gravado com sucesso!");
            setModel(model);
        } catch (ValidateException ex) {
            Logger.getLogger(ClienteForm.class.getName()).log(Level.SEVERE, null, ex);
            if(ex.getMensagemFixa() != null) {
                switch(ex.getMensagemFixa()) {
                    case CAMPO_OBRIGATORIO:
                    if (ex.getFields() != null) {
                        StringBuilder builder = new StringBuilder("<html>");
                        builder.append("O(s) seguinte(s) campo(s) é(são) obrigatório(s): ");
                        for (String key : ex.getFields().keySet()) {
                            builder.append("<br>");
                            builder.append(ex.getFields().get(key));
                        }
                        builder.append("</html>");
                        lbMessages.setText(builder.toString());
                        pack();
                        break;
                    }
                    case CAMPO_EXISTENTE:
                    JOptionPane.showMessageDialog(null, ex.getMensagemExcecao(), "Erro!", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                String mensagem = TrataExcecao.trataMensagemErro(ex, ClienteForm.class);
                JOptionPane.showMessageDialog(null, mensagem, "Erro!", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            Logger.getLogger(ClienteForm.class.getName()).log(Level.SEVERE, null, ex);
            String mensagem = TrataExcecao.trataMensagemErro(ex, ClienteForm.class);
            JOptionPane.showMessageDialog(null, mensagem, "Erro!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_botao_GravarActionPerformed

    private void checkBox_AtivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBox_AtivoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkBox_AtivoActionPerformed

    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated
    }//GEN-LAST:event_formInternalFrameActivated

    private void botao_NovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_NovoActionPerformed
        limpar();
    }//GEN-LAST:event_botao_NovoActionPerformed

    private void texto_nomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_texto_nomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_texto_nomeActionPerformed

    private void texto_documentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_texto_documentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_texto_documentoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botao_Gravar;
    private javax.swing.JButton botao_Novo;
    private javax.swing.JCheckBox checkBox_Ativo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbMessages;
    private javax.swing.JTextField texto_Codigo;
    private javax.swing.JTextField texto_bairro;
    private javax.swing.JFormattedTextField texto_cep;
    private javax.swing.JTextField texto_cidade;
    private javax.swing.JFormattedTextField texto_dataNascimento;
    private javax.swing.JTextField texto_documento;
    private javax.swing.JTextField texto_estado;
    private javax.swing.JTextField texto_nome;
    private javax.swing.JTextField texto_numero;
    private javax.swing.JTextField texto_rua;
    private javax.swing.JFormattedTextField texto_telefoneCelular;
    private javax.swing.JFormattedTextField texto_telefoneResidencial;
    // End of variables declaration//GEN-END:variables

    private void limpar() {
        model = new Cliente();
        texto_Codigo.setText("");
        texto_nome.setText("");
        texto_dataNascimento.setText("");
        texto_documento.setText("");
        texto_telefoneResidencial.setText("");
        texto_telefoneCelular.setText("");
        texto_rua.setText("");
        texto_numero.setText("");
        texto_cep.setText("");
        texto_bairro.setText("");
        texto_cidade.setText("");
        texto_estado.setText("");
        checkBox_Ativo.setSelected(true);
        lbMessages.setText("");
        pack();
    }
    
    public void setModel(Cliente model) {
        this.model = model;
        if(model != null) {
            texto_Codigo.setText(model.getCodigo());
            texto_nome.setText(model.getNome());
            texto_telefoneResidencial.setText(model.getTelefoneResidencial());
            texto_telefoneCelular.setText(model.getTelefoneCelular());
            texto_dataNascimento.setText(FormatUtils.formatDate(model.getDataNascimento()));
            texto_documento.setText(model.getDocumento());
            texto_rua.setText(model.getRua());
            texto_numero.setText(model.getNumero());
            texto_cep.setText(model.getCep());
            texto_bairro.setText(model.getBairro());
            texto_cidade.setText(model.getCidade());
            texto_estado.setText(model.getEstado());
            checkBox_Ativo.setSelected(model.isAtivo());
        } else {
            this.model = new Cliente();
            limpar();
        }
    }
    
}
