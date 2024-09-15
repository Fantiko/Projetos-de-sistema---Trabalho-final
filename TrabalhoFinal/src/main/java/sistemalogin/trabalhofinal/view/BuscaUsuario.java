/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package sistemalogin.trabalhofinal.view;

import sistemalogin.trabalhofinal.presenter.Sistema;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;
import sistemalogin.trabalhofinal.model.Usuario;

/**
 *
 * @author Ruan Ribeiro
 */
public class BuscaUsuario extends javax.swing.JInternalFrame implements Observer{
    Sistema sistema;
    TelaCadastroUsuario telaCadastroUsuario;
    
    public BuscaUsuario(TelaCadastroUsuario novaTelaUsuario, Sistema sistema) {
        initComponents();
        this.sistema = sistema;
        telaCadastroUsuario = novaTelaUsuario;
        
        this.sistema.addTela(this);
    }

    @Override
    public void atualizar(){
    
        ArrayList<Usuario> usuariosAprovados = sistema.pegarUsuarios();

        if(usuariosAprovados == null)
        {
            return;
        }

        DefaultTableModel tabelaBuscaModel = (DefaultTableModel) tabelaBusca.getModel();
        tabelaBuscaModel.setRowCount(0);

        for(Usuario u : usuariosAprovados)
        {
                tabelaBuscaModel.addRow(new Object[]{ u.getId(), u.getNome(), u.getDataCadastro(), u.getNotificacoesRecebidas(), u.getNotificacoesLidas()});    
        }
    
    
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaBusca = new javax.swing.JTable();
        btnExcluir = new javax.swing.JButton();
        btnNovo = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Buscar por Usuários");

        tabelaBusca.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Data de Cadastro", "Notificações Enviadas", "Notificações Lidas"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabelaBusca);

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnNovo.setText("Novo");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 519, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnNovo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnExcluir)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExcluir)
                    .addComponent(btnNovo))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    //EXCLUIR USUARIO
    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed

        int linhaSelectionada = tabelaBusca.getSelectedRow();
        int id = (int) tabelaBusca.getValueAt(linhaSelectionada, 0);

        sistema.deletaUsuario(id);
    }//GEN-LAST:event_btnExcluirActionPerformed

    //CADASTRAR NOVO USUARIO
    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        telaCadastroUsuario.setVisible(true);
    }//GEN-LAST:event_btnNovoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnNovo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaBusca;
    // End of variables declaration//GEN-END:variables
}
