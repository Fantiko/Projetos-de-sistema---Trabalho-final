/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package sistemalogin.trabalhofinal.View;
import sistemalogin.trabalhofinal.Presenter.Sistema;
import sistemalogin.trabalhofinal.View.Observer;
import sistemalogin.trabalhofinal.View.TelaPrincipal;

/**
 *
 * @author Ruan Ribeiro
 */
public class telaLogin extends javax.swing.JInternalFrame implements Observer{
    Sistema sistema;
    TelaCadastroUsuario telaCadastroUsuario;
    
    public telaLogin(TelaCadastroUsuario novaTelaUsuario) {
        initComponents();
        this.sistema = sistema;
        setVisible(true);
        telaCadastroUsuario = new TelaCadastroUsuario();
        telaCadastroUsuario = novaTelaUsuario;
    }
    @Override
    public void atualizar(){}

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        nomeLogin = new javax.swing.JTextField();
        senhaLogin = new javax.swing.JTextField();
        acessoUsuario = new javax.swing.JButton();
        novoUsuario = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Login");

        jLabel3.setText("NOME:");

        jLabel4.setText("SENHA:");

        acessoUsuario.setText("Acessar");
        acessoUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acessoUsuarioActionPerformed(evt);
            }
        });

        novoUsuario.setText("Cadastrar-se");
        novoUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                novoUsuarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(novoUsuario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(acessoUsuario))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(senhaLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nomeLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(10, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nomeLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(senhaLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(acessoUsuario)
                    .addComponent(novoUsuario))
                .addContainerGap(10, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void acessoUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acessoUsuarioActionPerformed
        
    }//GEN-LAST:event_acessoUsuarioActionPerformed

    private void novoUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_novoUsuarioActionPerformed

        telaCadastroUsuario.setVisible(true);
    }//GEN-LAST:event_novoUsuarioActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton acessoUsuario;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField nomeLogin;
    private javax.swing.JButton novoUsuario;
    private javax.swing.JTextField senhaLogin;
    // End of variables declaration//GEN-END:variables
}
