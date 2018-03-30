package com.luismassaneiro.sistemadonai.view.exportador;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import org.apache.commons.lang.StringUtils;

public class ExportadorTabelas extends javax.swing.JInternalFrame {

    private List<String> linhasArquivo = new ArrayList<>();
    private String descricaoArquivo;
    
    public ExportadorTabelas() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        texto_Caminho = new javax.swing.JTextField();
        botao_Selecionar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        radio_TXT = new javax.swing.JRadioButton();
        radio_CSV = new javax.swing.JRadioButton();
        botao_Confirmar = new javax.swing.JButton();
        botao_Cancelar = new javax.swing.JButton();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jLabel1.setText("Caminho");

        texto_Caminho.setEditable(false);

        botao_Selecionar.setText("Selecionar caminho...");
        botao_Selecionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_SelecionarActionPerformed(evt);
            }
        });

        jLabel2.setText("Tipo de saída");

        buttonGroup1.add(radio_TXT);
        radio_TXT.setText("TXT");

        buttonGroup1.add(radio_CSV);
        radio_CSV.setSelected(true);
        radio_CSV.setText("CSV");

        botao_Confirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/luismassaneiro/controleestoque/imagens/ok-24.png"))); // NOI18N
        botao_Confirmar.setText("Confirmar");
        botao_Confirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_ConfirmarActionPerformed(evt);
            }
        });

        botao_Cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/luismassaneiro/controleestoque/imagens/cancel-24.png"))); // NOI18N
        botao_Cancelar.setText("Cancelar");
        botao_Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_CancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(texto_Caminho, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(radio_CSV)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(radio_TXT)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botao_Selecionar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(botao_Confirmar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botao_Cancelar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(texto_Caminho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botao_Selecionar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radio_TXT)
                    .addComponent(radio_CSV))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(botao_Cancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botao_Confirmar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botao_SelecionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_SelecionarActionPerformed
        JFileChooser jfc = new javax.swing.JFileChooser();  
        jfc.setFileSelectionMode(javax.swing.JFileChooser.DIRECTORIES_ONLY);  
        jfc.setDialogTitle("Selecione o local do arquivo");
        jfc.setApproveButtonText("Selecionar");
        int res = jfc.showOpenDialog(this);
        if(res == JFileChooser.APPROVE_OPTION)
            texto_Caminho.setText(jfc.getSelectedFile().getAbsolutePath());
    }//GEN-LAST:event_botao_SelecionarActionPerformed

    private void botao_CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_CancelarActionPerformed
        hide();
    }//GEN-LAST:event_botao_CancelarActionPerformed

    private void botao_ConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_ConfirmarActionPerformed
        if(StringUtils.isNotEmpty(texto_Caminho.getText())) {
            StringBuilder caminhoAbsoluto = new StringBuilder();
            caminhoAbsoluto.append(texto_Caminho.getText());
            caminhoAbsoluto.append("/").append(descricaoArquivo);
            caminhoAbsoluto.append(".").append(radio_CSV.isSelected() ? "csv" : "txt");
            try {
                File arqProduto = new File(caminhoAbsoluto.toString());
                PrintWriter pw = new PrintWriter(arqProduto,  "UTF-8");
                for(String umaLinha: linhasArquivo) {
                    pw.println(umaLinha);
                }
                pw.close();
                JOptionPane.showMessageDialog(this, "Registros exportados com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                hide();
            } catch (FileNotFoundException | UnsupportedEncodingException ex) {
                Logger.getLogger(ExportadorTabelas.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "Erro ao exportar!\n Favor verificar se o caminho informado está correto", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Necessário informar o caminho!", "Caminho não informado", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_botao_ConfirmarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botao_Cancelar;
    private javax.swing.JButton botao_Confirmar;
    private javax.swing.JButton botao_Selecionar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JRadioButton radio_CSV;
    private javax.swing.JRadioButton radio_TXT;
    private javax.swing.JTextField texto_Caminho;
    // End of variables declaration//GEN-END:variables

    public void adicionaListaLinhasArquivo(List<String> linhas, String descricaoArquivo) {
        linhasArquivo.clear();
        linhasArquivo.addAll(linhas);
        this.descricaoArquivo = descricaoArquivo;
    }
}
