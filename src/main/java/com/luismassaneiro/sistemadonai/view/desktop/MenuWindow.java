/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.luismassaneiro.sistemadonai.view.desktop;

import com.luismassaneiro.sistemadonai.controller.DAOFactory;
import com.luismassaneiro.sistemadonai.view.cadastro.ClienteBrowser;
import com.luismassaneiro.sistemadonai.view.cadastro.ProdutoBrowser;
import com.luismassaneiro.sistemadonai.view.consultas.ProdutosBaixaEstoque;
import com.luismassaneiro.sistemadonai.view.help.About;
import com.luismassaneiro.sistemadonai.view.operacoes.Pagamento;
import com.luismassaneiro.sistemadonai.view.operacoes.PedidoForm;

/**
 *
 * @author Aluno
 */
public class MenuWindow extends javax.swing.JFrame {

    /**
     * Creates new form MenuWindow
     */
    public MenuWindow() {
        initComponents();
        try {
            DAOFactory.criaClienteDAO().getConnection();
        } catch (Exception ex){      
        }
        this.setExtendedState(MAXIMIZED_BOTH);
        GerenciadorJanelas.init(desktopPane);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktopPane = new javax.swing.JDesktopPane();
        menuBar = new javax.swing.JMenuBar();
        cadastroMenu = new javax.swing.JMenu();
        clienteMenuItem = new javax.swing.JMenuItem();
        produtoMenuItem = new javax.swing.JMenuItem();
        exitMenuItem = new javax.swing.JMenuItem();
        editMenu = new javax.swing.JMenu();
        produtoFaltaMenuItem = new javax.swing.JMenuItem();
        vendasMenuItem = new javax.swing.JMenuItem();
        operacaoMenu = new javax.swing.JMenu();
        operacoesPagamento = new javax.swing.JMenuItem();
        operacoesPedido = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        aboutMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Controle de estoque");

        desktopPane.setAutoscrolls(true);

        cadastroMenu.setMnemonic('c');
        cadastroMenu.setText("Cadastro");

        clienteMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, java.awt.event.InputEvent.CTRL_MASK));
        clienteMenuItem.setMnemonic('c');
        clienteMenuItem.setText("Cliente");
        clienteMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clienteMenuItemActionPerformed(evt);
            }
        });
        cadastroMenu.add(clienteMenuItem);

        produtoMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, java.awt.event.InputEvent.CTRL_MASK));
        produtoMenuItem.setMnemonic('c');
        produtoMenuItem.setText("Produto");
        produtoMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                produtoMenuItemActionPerformed(evt);
            }
        });
        cadastroMenu.add(produtoMenuItem);

        exitMenuItem.setMnemonic('s');
        exitMenuItem.setText("Sair");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        cadastroMenu.add(exitMenuItem);

        menuBar.add(cadastroMenu);

        editMenu.setMnemonic('c');
        editMenu.setText("Consultas");

        produtoFaltaMenuItem.setMnemonic('t');
        produtoFaltaMenuItem.setText("Produtos em falta");
        produtoFaltaMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                produtoFaltaMenuItemActionPerformed(evt);
            }
        });
        editMenu.add(produtoFaltaMenuItem);

        vendasMenuItem.setMnemonic('y');
        vendasMenuItem.setText("Vendas");
        vendasMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vendasMenuItemActionPerformed(evt);
            }
        });
        editMenu.add(vendasMenuItem);

        menuBar.add(editMenu);

        operacaoMenu.setMnemonic('o');
        operacaoMenu.setText("Operações");

        operacoesPagamento.setMnemonic('t');
        operacoesPagamento.setText("Pagamentos");
        operacoesPagamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                operacoesPagamentoActionPerformed(evt);
            }
        });
        operacaoMenu.add(operacoesPagamento);

        operacoesPedido.setMnemonic('y');
        operacoesPedido.setText("Pedido");
        operacoesPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                operacoesPedidoActionPerformed(evt);
            }
        });
        operacaoMenu.add(operacoesPedido);

        menuBar.add(operacaoMenu);

        helpMenu.setMnemonic('h');
        helpMenu.setText("Help");

        aboutMenuItem.setMnemonic('a');
        aboutMenuItem.setText("About");
        aboutMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutMenuItemActionPerformed(evt);
            }
        });
        helpMenu.add(aboutMenuItem);

        menuBar.add(helpMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void clienteMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clienteMenuItemActionPerformed
        GerenciadorJanelas.getInstance().abrirJanela(new ClienteBrowser()).setVisible(true);
    }//GEN-LAST:event_clienteMenuItemActionPerformed

    private void produtoMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_produtoMenuItemActionPerformed
        ProdutoBrowser produto = (ProdutoBrowser) GerenciadorJanelas.getInstance().abrirJanela(new ProdutoBrowser());
        produto.showWindow(null);
        produto.setVisible(true);
    }//GEN-LAST:event_produtoMenuItemActionPerformed

    private void vendasMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vendasMenuItemActionPerformed
//        GerenciadorJanelas.getInstance().abrirJanela(new Vendas()).setVisible(true);
    }//GEN-LAST:event_vendasMenuItemActionPerformed

    private void operacoesPagamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_operacoesPagamentoActionPerformed
        GerenciadorJanelas.getInstance().abrirJanela(new Pagamento()).setVisible(true);
    }//GEN-LAST:event_operacoesPagamentoActionPerformed

    private void operacoesPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_operacoesPedidoActionPerformed
        //GerenciadorJanelas.getInstance().abrirJanela(new PedidoForm()).setVisible(true);
        GerenciadorJanelas.getInstance().abrirJanela(new PedidoForm()).setVisible(true);
    }//GEN-LAST:event_operacoesPedidoActionPerformed

    private void produtoFaltaMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_produtoFaltaMenuItemActionPerformed
        GerenciadorJanelas.getInstance().abrirJanela(new ProdutosBaixaEstoque()).setVisible(true);
    }//GEN-LAST:event_produtoFaltaMenuItemActionPerformed

    private void aboutMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutMenuItemActionPerformed
        GerenciadorJanelas.getInstance().abrirJanela(new About()).setVisible(true);
    }//GEN-LAST:event_aboutMenuItemActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aboutMenuItem;
    private javax.swing.JMenu cadastroMenu;
    private javax.swing.JMenuItem clienteMenuItem;
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenu editMenu;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu operacaoMenu;
    private javax.swing.JMenuItem operacoesPagamento;
    private javax.swing.JMenuItem operacoesPedido;
    private javax.swing.JMenuItem produtoFaltaMenuItem;
    private javax.swing.JMenuItem produtoMenuItem;
    private javax.swing.JMenuItem vendasMenuItem;
    // End of variables declaration//GEN-END:variables

}
