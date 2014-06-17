
package sistemaintercambio;

import Clases.Participante;
import DAO.ParticipanteDAO;
import Factory.DAOFactory;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author jhoel_000
 */
public class FrmSuspenderParticipante extends javax.swing.JFrame {

    String encryptedPassword, userId;
    ArrayList<Participante> participantes;
    
    public FrmSuspenderParticipante(String pUserId, String pEncryptedPassword) {
        initComponents();
        setLocationRelativeTo(null);
        
        encryptedPassword = pEncryptedPassword;
        userId = pUserId;
        
        txtApelliM.setEditable(false);
        txtApelliP.setEditable(false);
        txtNombre.setEditable(false);
        
        ArrayList<Participante> participantes = new ArrayList<>();
        cargarCMBIds();
    }

    private void cargarCMBIds(){
        DAOFactory sqlserverFactory = DAOFactory.getDAOFactory(DAOFactory.SQLSERVER);
        ParticipanteDAO participanteDAO = sqlserverFactory.getParticipanteDAO();
        
        DefaultComboBoxModel modeloCombo = new DefaultComboBoxModel();
        
        participantes = participanteDAO.listarParticipantes();
        
        for (Participante participante : participantes)
        {
            modeloCombo.addElement(participante.getCedula());
        }
        cmbCedula.setModel(modeloCombo);
        cargarTBParticipantes();
    }
    
    private void cargarTBParticipantes(){
        try{
            int id = (int)cmbCedula.getSelectedItem();
            for(Participante participante : participantes)
            {
                if(participante.getCedula() == id)
                {
                    txtNombre.setText(participante.getNombre());
                    txtApelliM.setText(participante.getApellidoM());
                    txtApelliP.setText(participante.getApellidoP());
                    break;
                }
            }
        }
        catch(Exception e){
            txtNombre.setText("");
            txtApelliM.setText("");
            txtApelliP.setText("");
        }
        
    }
    
    private void suspenderParticipante(){
        
        DAOFactory sqlserverFactory = DAOFactory.getDAOFactory(DAOFactory.SQLSERVER);
        ParticipanteDAO participanteDAO = sqlserverFactory.getParticipanteDAO();
        
        String id = Integer.toString((int)cmbCedula.getSelectedItem());
        boolean succesful = participanteDAO.suspenderParticipante(id);
        
        if(succesful)
        {
            JOptionPane.showMessageDialog(this, "Participante suspendido correctamente");
            cargarCMBIds();
        }
        else
            JOptionPane.showMessageDialog(this, "Hubo un error al suspender el participante");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblInicio = new javax.swing.JLabel();
        lblInicio1 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        lblInicio2 = new javax.swing.JLabel();
        txtApelliP = new javax.swing.JTextField();
        lblInicio3 = new javax.swing.JLabel();
        txtApelliM = new javax.swing.JTextField();
        lblInicio4 = new javax.swing.JLabel();
        cmbCedula = new javax.swing.JComboBox();
        btnSuspender = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblInicio.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblInicio.setText("Suspender Participante");

        lblInicio1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblInicio1.setText("Nombre:");

        lblInicio2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblInicio2.setText("Primer Apellido:");

        lblInicio3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblInicio3.setText("Segundo Apellido:");

        lblInicio4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblInicio4.setText("Cédula:");

        cmbCedula.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbCedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCedulaActionPerformed(evt);
            }
        });

        btnSuspender.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnSuspender.setText("Suspender");
        btnSuspender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuspenderActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblInicio)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(24, 24, 24)
                            .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
                            .addComponent(btnSuspender))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(lblInicio1)
                                .addComponent(lblInicio2)
                                .addComponent(lblInicio3)
                                .addComponent(lblInicio4))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtNombre)
                                .addComponent(txtApelliP)
                                .addComponent(txtApelliM, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                                .addComponent(cmbCedula, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblInicio)
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblInicio4)
                    .addComponent(cmbCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblInicio1)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblInicio2)
                    .addComponent(txtApelliP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblInicio3)
                    .addComponent(txtApelliM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSuspender)
                    .addComponent(btnCancelar))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSuspenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuspenderActionPerformed
        suspenderParticipante();
    }//GEN-LAST:event_btnSuspenderActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        FrmAdminOptions frm = new FrmAdminOptions(userId, encryptedPassword);
        frm.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void cmbCedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCedulaActionPerformed
        // TODO add your handling code here:
        cargarTBParticipantes();
    }//GEN-LAST:event_cmbCedulaActionPerformed

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
            java.util.logging.Logger.getLogger(FrmSuspenderParticipante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmSuspenderParticipante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmSuspenderParticipante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmSuspenderParticipante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmSuspenderParticipante("","").setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnSuspender;
    private javax.swing.JComboBox cmbCedula;
    private javax.swing.JLabel lblInicio;
    private javax.swing.JLabel lblInicio1;
    private javax.swing.JLabel lblInicio2;
    private javax.swing.JLabel lblInicio3;
    private javax.swing.JLabel lblInicio4;
    private javax.swing.JTextField txtApelliM;
    private javax.swing.JTextField txtApelliP;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
