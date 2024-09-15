/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package sistemalogin.trabalhofinal.view;

import org.example.Logger.CSVLogger;
import org.example.Logger.JSONLogger;
import sistemalogin.trabalhofinal.presenter.Sistema;

/**
 *
 * @author Ruan Ribeiro
 */
public class TelaLog extends javax.swing.JInternalFrame implements Observer{

    private Sistema sistema;
    public TelaLog(Sistema sistema)
    {
        this.sistema = sistema;
        initComponents();
        
        this.sistema.addTela(this);
    }

    @Override
    public void atualizar()
    {

    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        formatoLog = new javax.swing.JComboBox<>();
        btnSalvar = new javax.swing.JButton();

        setIconifiable(true);
        setTitle("LOG");

        jLabel1.setText("LOG");

        formatoLog.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "JSON", "CSV" }));

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnSalvar)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(formatoLog, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(formatoLog, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnSalvar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt)
    {//GEN-FIRST:event_btnSalvarActionPerformed
        String formatoLogSelecionado = (String) this.formatoLog.getSelectedItem();

        if(formatoLogSelecionado.equals("JSON"))
        {
            sistema.setLogger(new JSONLogger());
        } else if (formatoLogSelecionado.equals("CSV"))
        {
            sistema.setLogger(new CSVLogger());
        }
    }//GEN-LAST:event_btnSalvarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<String> formatoLog;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
