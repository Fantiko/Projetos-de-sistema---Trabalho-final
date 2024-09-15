/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package sistemalogin.trabalhofinal.view;

import sistemalogin.trabalhofinal.presenter.Sistema;
import java.util.ArrayList;
import sistemalogin.trabalhofinal.mensagem.Msg;

/**
 *
 * @author Ruan Ribeiro
 */
public class EnviarMensagem extends javax.swing.JInternalFrame implements Observer{
    Sistema sistema;
    SelecaoUsuarioMensagem selecaoUsuario;
    private ArrayList<Integer> idListParaEnviar;
    TelaPrincipal telaPrincipal;
    
            
    public EnviarMensagem(Sistema sistema, TelaPrincipal telaprincipal) {
        initComponents();
        this.sistema = sistema;
        this.telaPrincipal = telaprincipal;
        this.idListParaEnviar = new ArrayList<>();
        this.sistema.addTela(this);
    }
    
    @Override
    public void atualizar(){}

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        btnEnviaMensagem = new javax.swing.JButton();
        btnDestinatario = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Enviar Msg");

        jLabel1.setText("Destinatário:");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        btnEnviaMensagem.setText("Enviar");
        btnEnviaMensagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviaMensagemActionPerformed(evt);
            }
        });

        btnDestinatario.setText("Destinatários");
        btnDestinatario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDestinatarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jScrollPane1)
                            .addContainerGap())
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnDestinatario)
                            .addGap(120, 120, 120)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnEnviaMensagem)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btnDestinatario))
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnEnviaMensagem)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEnviaMensagemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviaMensagemActionPerformed
        // TODO add your handling code here:
        for(int id : idListParaEnviar)
        {
            Msg novaMsg = new Msg(jTextArea1.getText(), id);
            sistema.cadastrarMSGUsuario(novaMsg);
        }
        
        idListParaEnviar.clear();
        setVisible(false);
    }//GEN-LAST:event_btnEnviaMensagemActionPerformed

    private void btnDestinatarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDestinatarioActionPerformed
        SelecaoUsuarioMensagem selecaoUsuario = new SelecaoUsuarioMensagem(sistema, this);
        selecaoUsuario = sistema.telaPrincipal.getSelecaoUsuario();
        selecaoUsuario.setVisible(true);
        
    }//GEN-LAST:event_btnDestinatarioActionPerformed

    public ArrayList<Integer> getIdListParaEnviar()
    {
        return this.idListParaEnviar;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDestinatario;
    private javax.swing.JButton btnEnviaMensagem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
