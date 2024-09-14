/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/MDIApplication.java to edit this template
 */
package sistemalogin.trabalhofinal.view;

import javax.swing.JLabel;
import sistemalogin.trabalhofinal.presenter.Sistema;

/**
 *
 * @author Ruan Ribeiro
 */
public class TelaPrincipal extends javax.swing.JFrame implements Observer{
    
    private Sistema sistema; 
    public TelaCadastroUsuario telaCadastroUsuario;
    private AlteraSenha alterarSenha;
    private AutorizaUsuario autorizaUsuario;
    private BuscaUsuario buscaUsuario;
    private EnviarMensagem enviarMensagem;
    private Mensagem mensagem;
    private TelaLogin telaLogin;
    private VisualizaMensagem visualizaMensagem;
    private TelaLog telaLog;
    private SelecaoUsuarioMensagem selecaoUsuarioMensagem;
    
    
    public TelaPrincipal(Sistema sistema) {
        initComponents();
        this.sistema = sistema;
        telaCadastroUsuario = new TelaCadastroUsuario(sistema);
        alterarSenha = new AlteraSenha(sistema);
        autorizaUsuario = new AutorizaUsuario(sistema);
        selecaoUsuarioMensagem = new SelecaoUsuarioMensagem();
        buscaUsuario = new BuscaUsuario(telaCadastroUsuario, sistema);
        enviarMensagem = new EnviarMensagem(selecaoUsuarioMensagem);
        mensagem = new Mensagem();
        telaLogin = new TelaLogin(telaCadastroUsuario, sistema);
        visualizaMensagem = new VisualizaMensagem(mensagem);
        telaLog = new TelaLog(sistema);
        
        addComponentsToMainPane();
        setVisible(true);
        this.jMenu1.setVisible(false);
        this.jMenu3.setVisible(false);
        this.jMenu4.setVisible(false);
    }
    
    
    @Override
    public void atualizar()
    {

    }
    
    public final void addComponentsToMainPane()
    {
        desktopPane.add(telaCadastroUsuario);
        desktopPane.add(alterarSenha);
        desktopPane.add(autorizaUsuario);
        desktopPane.add(buscaUsuario);
        desktopPane.add(enviarMensagem);
        desktopPane.add(mensagem);
        desktopPane.add(telaLogin);
        desktopPane.add(visualizaMensagem);
        desktopPane.add(telaLog);
        desktopPane.add(selecaoUsuarioMensagem);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        nomeUsuario = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        tipoUsuario = new javax.swing.JLabel();
        desktopPane = new javax.swing.JDesktopPane();
        menuBar = new javax.swing.JMenuBar();
        jMenu5 = new javax.swing.JMenu();
        abrirTelaLog = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        abreTelaSenha = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        abreBuscaUsuario = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        abreAutorizaUsuario = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        abreEnviarMensagem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SISTEMA");

        jButton1.setText("Notificações");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setText("Usuário:");

        jLabel1.setText("Tipo:");

        tipoUsuario.setToolTipText("");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nomeUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tipoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 208, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(10, 10, 10))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jLabel3)
                    .addComponent(nomeUsuario)
                    .addComponent(jLabel1)
                    .addComponent(tipoUsuario))
                .addGap(10, 10, 10))
        );

        javax.swing.GroupLayout desktopPaneLayout = new javax.swing.GroupLayout(desktopPane);
        desktopPane.setLayout(desktopPaneLayout);
        desktopPaneLayout.setHorizontalGroup(
            desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        desktopPaneLayout.setVerticalGroup(
            desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 388, Short.MAX_VALUE)
        );

        menuBar.setName("SISTEMA"); // NOI18N

        jMenu5.setText("LOG");

        abrirTelaLog.setText("LOG");
        abrirTelaLog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abrirTelaLogActionPerformed(evt);
            }
        });
        jMenu5.add(abrirTelaLog);

        menuBar.add(jMenu5);

        jMenu2.setMnemonic('f');
        jMenu2.setText("Trocar Senha");
        jMenu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu2ActionPerformed(evt);
            }
        });

        abreTelaSenha.setText("Trocar Senha");
        abreTelaSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abreTelaSenhaActionPerformed(evt);
            }
        });
        jMenu2.add(abreTelaSenha);

        menuBar.add(jMenu2);

        jMenu3.setText("Buscar Usuário");

        abreBuscaUsuario.setText("Buscar Usuário");
        abreBuscaUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abreBuscaUsuarioActionPerformed(evt);
            }
        });
        jMenu3.add(abreBuscaUsuario);

        menuBar.add(jMenu3);

        jMenu4.setText("Autorizar Usuário");

        abreAutorizaUsuario.setText("Autorizar Usuário");
        abreAutorizaUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abreAutorizaUsuarioActionPerformed(evt);
            }
        });
        jMenu4.add(abreAutorizaUsuario);

        menuBar.add(jMenu4);

        jMenu1.setText("Enviar Msg");

        abreEnviarMensagem.setText("Enviar Msg");
        abreEnviarMensagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abreEnviarMensagemActionPerformed(evt);
            }
        });
        jMenu1.add(abreEnviarMensagem);

        menuBar.add(jMenu1);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(desktopPane, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(desktopPane)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        visualizaMensagem.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jMenu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu2ActionPerformed
        alterarSenha.setVisible(true);
    }//GEN-LAST:event_jMenu2ActionPerformed

    private void abreTelaSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abreTelaSenhaActionPerformed
        alterarSenha.setVisible(true);
    }//GEN-LAST:event_abreTelaSenhaActionPerformed

    private void abreBuscaUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abreBuscaUsuarioActionPerformed
        buscaUsuario.setVisible(true);
    }//GEN-LAST:event_abreBuscaUsuarioActionPerformed

    private void abreAutorizaUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abreAutorizaUsuarioActionPerformed
        autorizaUsuario.setVisible(true);
    }//GEN-LAST:event_abreAutorizaUsuarioActionPerformed

    private void abreEnviarMensagemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abreEnviarMensagemActionPerformed
        sistema.abreTela(enviarMensagem);
        
        //enviarMensagem.setVisible(true);
    }//GEN-LAST:event_abreEnviarMensagemActionPerformed

    private void abrirTelaLogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abrirTelaLogActionPerformed

        telaLog.setVisible(true);
    }//GEN-LAST:event_abrirTelaLogActionPerformed

 
    public static void main(String args[]) {
        
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
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        
        /*java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });*/
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario.setText(nomeUsuario);
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario.setText(tipoUsuario);
    }
    
    public void abreOpcaoAdm(){
        sistema.abreMenu(jMenu1);
        sistema.abreMenu(jMenu4);
        sistema.abreMenu(jMenu3);
        System.out.println("Telas aparecendo");
    }
    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem abreAutorizaUsuario;
    private javax.swing.JMenuItem abreBuscaUsuario;
    private javax.swing.JMenuItem abreEnviarMensagem;
    private javax.swing.JMenuItem abreTelaSenha;
    private javax.swing.JMenuItem abrirTelaLog;
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JLabel nomeUsuario;
    private javax.swing.JLabel tipoUsuario;
    // End of variables declaration//GEN-END:variables


}
