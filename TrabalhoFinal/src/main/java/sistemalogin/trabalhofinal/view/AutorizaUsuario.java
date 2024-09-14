/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package sistemalogin.trabalhofinal.view;

import sistemalogin.trabalhofinal.presenter.Sistema;

/**
 *
 * @author Ruan Ribeiro
 */
public class AutorizaUsuario extends javax.swing.JInternalFrame implements Observer{
    Sistema sistema;
    
    public AutorizaUsuario(Sistema sistema) {
        initComponents();
        this.sistema = sistema;
        
    }

    @Override
    public void atualizar(){}
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        autorizaUsuario = new javax.swing.JButton();
        rejeitaUsuario = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaAutoriza = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setTitle("Autorizar Usuários");

        autorizaUsuario.setText("Rejeitar");
        autorizaUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                autorizaUsuarioActionPerformed(evt);
            }
        });

        rejeitaUsuario.setText("Autorizar");
        rejeitaUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rejeitaUsuarioActionPerformed(evt);
            }
        });

        tabelaAutoriza.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Usuários"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabelaAutoriza);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(rejeitaUsuario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(autorizaUsuario))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rejeitaUsuario)
                    .addComponent(autorizaUsuario))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rejeitaUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rejeitaUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rejeitaUsuarioActionPerformed

    private void autorizaUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_autorizaUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_autorizaUsuarioActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton autorizaUsuario;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton rejeitaUsuario;
    private javax.swing.JTable tabelaAutoriza;
    // End of variables declaration//GEN-END:variables
}
