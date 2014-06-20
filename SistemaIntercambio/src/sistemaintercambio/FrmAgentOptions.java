
package sistemaintercambio;

import DAO.SesionDAO;
import Factory.DAOFactory;
import javax.swing.JOptionPane;

public class FrmAgentOptions extends javax.swing.JFrame {

    String encryptedPassword, userId;
    
    public FrmAgentOptions(String pUserId, String pEncryptedPassword) {
        initComponents();
        setLocationRelativeTo(null);
        
        encryptedPassword = pEncryptedPassword;
        userId = pUserId;
    }
    
    private void iniciarSesion(){
        
        DAOFactory sqlserverFactory = DAOFactory.getDAOFactory(DAOFactory.SQLSERVER);
        SesionDAO sesionDAO = sqlserverFactory.getSesionDAO();
        int sesionID = sesionDAO.createSesion(userId);
        
        if(sesionID != -1)
            JOptionPane.showMessageDialog(this, "Sesion "+sesionID+" creada exitosamente");
        else
        {
            JOptionPane.showMessageDialog(this, "Hubo un problema al crear la sesion");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton6 = new javax.swing.JButton();
        lblInicio = new javax.swing.JLabel();
        btnCambiarPassword = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        btnRetirar = new javax.swing.JButton();
        btnDepositar = new javax.swing.JButton();
        btnRegistrarParticipante = new javax.swing.JButton();

        jButton6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton6.setText("Iniciar Sesion Negociacion");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblInicio.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblInicio.setText("Bienvenido Agente");

        btnCambiarPassword.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnCambiarPassword.setText("Cambiar Contraseña");
        btnCambiarPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCambiarPasswordActionPerformed(evt);
            }
        });

        btnSalir.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.setToolTipText("");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        btnRetirar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnRetirar.setText("Retirar");
        btnRetirar.setToolTipText("");

        btnDepositar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnDepositar.setText("Depositar");
        btnDepositar.setToolTipText("");
        btnDepositar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDepositarActionPerformed(evt);
            }
        });

        btnRegistrarParticipante.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnRegistrarParticipante.setText("Registrar Participante");
        btnRegistrarParticipante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarParticipanteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblInicio)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 13, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnCambiarPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
                                    .addComponent(btnDepositar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnRetirar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnRegistrarParticipante, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(btnSalir))
                        .addGap(22, 22, 22))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblInicio)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCambiarPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRegistrarParticipante, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDepositar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRetirar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCambiarPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCambiarPasswordActionPerformed
        // TODO add your handling code here:
        FrmCambiarPassword frm = new FrmCambiarPassword(userId, encryptedPassword,false);
        frm.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnCambiarPasswordActionPerformed

    private void btnRegistrarParticipanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarParticipanteActionPerformed
        // TODO add your handling code here:
        FrmInsertarParticipante frm = new FrmInsertarParticipante(userId, encryptedPassword);
        frm.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnRegistrarParticipanteActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        FrmLogin frm = new FrmLogin();
        frm.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnDepositarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDepositarActionPerformed
        // TODO add your handling code here:
        FrmDepositarDinero frm = new FrmDepositarDinero(userId, encryptedPassword);
        frm.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnDepositarActionPerformed

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
            java.util.logging.Logger.getLogger(FrmAgentOptions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmAgentOptions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmAgentOptions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmAgentOptions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmAgentOptions("","").setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCambiarPassword;
    private javax.swing.JButton btnDepositar;
    private javax.swing.JButton btnRegistrarParticipante;
    private javax.swing.JButton btnRetirar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel lblInicio;
    // End of variables declaration//GEN-END:variables
}
