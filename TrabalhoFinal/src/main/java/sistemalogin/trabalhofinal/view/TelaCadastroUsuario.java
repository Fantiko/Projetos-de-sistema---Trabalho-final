/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package sistemalogin.trabalhofinal.view;
import com.pss.senha.validacao.ValidadorSenha;
import sistemalogin.trabalhofinal.model.Usuario;
import sistemalogin.trabalhofinal.presenter.Sistema;

import java.util.ArrayList;

/**
 *
 * @author Ruan Ribeiro
 */
public class TelaCadastroUsuario extends javax.swing.JInternalFrame implements Observer{
    Sistema sistema;
    
    public TelaCadastroUsuario(Sistema sistema) {
        initComponents();
        this.sistema = sistema;
        
        this.sistema.addTela(this);
        
    }
    @Override
    public void atualizar(){}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        nomeUsuario = new javax.swing.JTextField();
        senhaUsuario = new javax.swing.JTextField();
        salvarUsuario = new javax.swing.JButton();

        setIconifiable(true);
        setTitle("Cadastro de Usuário");

        jLabel2.setText("NOME:");

        jLabel3.setText("SENHA:");

        salvarUsuario.setText("Cadastrar");
        salvarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salvarUsuarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(salvarUsuario)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addGap(14, 14, 14)
                            .addComponent(senhaUsuario))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addGap(18, 18, 18)
                            .addComponent(nomeUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(28, 28, 28))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(nomeUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(senhaUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(salvarUsuario)
                .addGap(17, 17, 17))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void salvarUsuarioActionPerformed(java.awt.event.ActionEvent evt)
    {//GEN-FIRST:event_salvarUsuarioActionPerformed
        String novoNome = nomeUsuario.getText();
        String novaSenha = senhaUsuario.getText();
        boolean isPrimeiroUsuario = false;

        try
        {
            isPrimeiroUsuario = sistema.getUsuarioDAO().isEmpty();
        } catch (Exception e)
        {
            e.printStackTrace();
            return;
        }

        sistema.cadastrarUsuario(new Usuario(novoNome, novaSenha, isPrimeiroUsuario));


        nomeUsuario.setText("");
        senhaUsuario.setText("");
    }//GEN-LAST:event_salvarUsuarioActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField nomeUsuario;
    private javax.swing.JButton salvarUsuario;
    private javax.swing.JTextField senhaUsuario;
    // End of variables declaration//GEN-END:variables
}
