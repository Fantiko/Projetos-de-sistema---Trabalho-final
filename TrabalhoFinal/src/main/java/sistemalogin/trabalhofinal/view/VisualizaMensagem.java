/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package sistemalogin.trabalhofinal.view;

import sistemalogin.trabalhofinal.mensagem.Msg;
import sistemalogin.trabalhofinal.model.Usuario;
import sistemalogin.trabalhofinal.presenter.Sistema;

import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

/**
 *
 * @author Ruan Ribeiro
 */
public class VisualizaMensagem extends javax.swing.JInternalFrame implements Observer{
    Sistema sistema;
    Mensagem mensagem;
    
    public VisualizaMensagem(Mensagem novaMensagem, Sistema sistema) {
        initComponents();
        this.sistema = sistema;
        mensagem = new Mensagem(sistema);
        mensagem = novaMensagem;
        
        this.sistema.addTela(this);
    }

    @Override
    public void atualizar(){
        ArrayList<Msg> listaMensagens = sistema.ListarMSGUsuario();

        if (listaMensagens == null){
            return;
        }

        DefaultTableModel tabelaMSGModel = (DefaultTableModel) tabelaMensagem.getModel();
        tabelaMSGModel.setRowCount(0);

        for(Msg msg : listaMensagens)
        {
            tabelaMSGModel.addRow(new Object[]{ msg.getId(), msg.isLida()});
        }

    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaMensagem = new javax.swing.JTable();
        lerMensagem = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Mensagens Recebidas");

        tabelaMensagem.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabelaMensagem);

        lerMensagem.setText("Ler");
        lerMensagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lerMensagemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(7, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lerMensagem)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lerMensagem)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lerMensagemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lerMensagemActionPerformed
        int linhaSelectionada = tabelaMensagem.getSelectedRow();
        int id = (int) tabelaMensagem.getValueAt(linhaSelectionada, 0);

        Msg msg = sistema.consultarMSG(id);
        mensagem.escreveMSG(msg.getMensagem());

        mensagem.setVisible(true);
    }//GEN-LAST:event_lerMensagemActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton lerMensagem;
    private javax.swing.JTable tabelaMensagem;
    // End of variables declaration//GEN-END:variables
}
