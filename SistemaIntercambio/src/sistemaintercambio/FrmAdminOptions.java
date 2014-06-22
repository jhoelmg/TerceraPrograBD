
package sistemaintercambio;

import DAO.SesionDAO;
import Factory.DAOFactory;
import javax.swing.JOptionPane;
import sistemaintercambio.FrmCambiarPassword;
import sistemaintercambio.FrmFinalizarSesion;
import sistemaintercambio.FrmInsertarAgente;
import sistemaintercambio.FrmLogin;
import sistemaintercambio.FrmSuspenderParticipante;

public class FrmAdminOptions extends javax.swing.JFrame {

    String encryptedPassword, userId;
    
    public FrmAdminOptions(String pUserId, String pEncryptedPassword) {
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
        btnSuspenderParticipante = new javax.swing.JButton();
        btnCambiarPassword = new javax.swing.JButton();
        btnListarPizarra = new javax.swing.JButton();
        btnFinalizarSesion = new javax.swing.JButton();
        btnIniciarSesion = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        btnVerTransacciones = new javax.swing.JButton();
        btnVerEstadisticas = new javax.swing.JButton();
        btnCrearAgente = new javax.swing.JButton();
        btnListarUsuarios = new javax.swing.JButton();

        jButton6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton6.setText("Iniciar Sesion Negociacion");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblInicio.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblInicio.setText("Bienvenido Administrador");

        btnSuspenderParticipante.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnSuspenderParticipante.setText("Suspender Participante");
        btnSuspenderParticipante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuspenderParticipanteActionPerformed(evt);
            }
        });

        btnCambiarPassword.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnCambiarPassword.setText("Cambiar Contraseña");
        btnCambiarPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCambiarPasswordActionPerformed(evt);
            }
        });

        btnListarPizarra.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnListarPizarra.setText("Listar Pizarra");
        btnListarPizarra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarPizarraActionPerformed(evt);
            }
        });

        btnFinalizarSesion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnFinalizarSesion.setText("Finalizar Sesion Negociacion");
        btnFinalizarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizarSesionActionPerformed(evt);
            }
        });

        btnIniciarSesion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnIniciarSesion.setText("Iniciar Sesion Negociacion");
        btnIniciarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarSesionActionPerformed(evt);
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

        btnVerTransacciones.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnVerTransacciones.setText("Ver Transferencias");
        btnVerTransacciones.setToolTipText("");
        btnVerTransacciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerTransaccionesActionPerformed(evt);
            }
        });

        btnVerEstadisticas.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnVerEstadisticas.setText("Ver Estadisticas");
        btnVerEstadisticas.setToolTipText("");
        btnVerEstadisticas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerEstadisticasActionPerformed(evt);
            }
        });

        btnCrearAgente.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnCrearAgente.setText("Crear Agente");
        btnCrearAgente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearAgenteActionPerformed(evt);
            }
        });

        btnListarUsuarios.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnListarUsuarios.setText("Listar Usuarios");
        btnListarUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarUsuariosActionPerformed(evt);
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
                        .addGap(0, 16, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnListarPizarra, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnCrearAgente, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnListarUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnSalir))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnCambiarPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnFinalizarSesion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnVerEstadisticas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnSuspenderParticipante, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnIniciarSesion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnVerTransacciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(22, 22, 22))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblInicio)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSuspenderParticipante, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCambiarPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnIniciarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFinalizarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVerTransacciones, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVerEstadisticas, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnListarPizarra, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCrearAgente, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnListarUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCambiarPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCambiarPasswordActionPerformed
        // TODO add your handling code here:
        FrmCambiarPassword frm = new FrmCambiarPassword(userId, encryptedPassword,true);
        frm.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnCambiarPasswordActionPerformed

    private void btnCrearAgenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearAgenteActionPerformed
        // TODO add your handling code here:
        FrmInsertarAgente frm = new FrmInsertarAgente(userId, encryptedPassword);
        frm.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnCrearAgenteActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        FrmLogin frm = new FrmLogin();
        frm.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnSuspenderParticipanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuspenderParticipanteActionPerformed
        // TODO add your handling code here:
        FrmSuspenderParticipante frm = new FrmSuspenderParticipante(userId, encryptedPassword);
        frm.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnSuspenderParticipanteActionPerformed

    private void btnIniciarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarSesionActionPerformed
        iniciarSesion();
    }//GEN-LAST:event_btnIniciarSesionActionPerformed

    private void btnFinalizarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarSesionActionPerformed
        // TODO add your handling code here:
        FrmFinalizarSesion frm = new FrmFinalizarSesion(userId, encryptedPassword);
        frm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnFinalizarSesionActionPerformed

    private void btnVerEstadisticasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerEstadisticasActionPerformed
        // TODO add your handling code here:
        FrmVerEstadisticas fmr = new FrmVerEstadisticas(userId, encryptedPassword);
        fmr.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_btnVerEstadisticasActionPerformed

    private void btnVerTransaccionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerTransaccionesActionPerformed
        // TODO add your handling code here:
        FmrVerTranferencias frm = new FmrVerTranferencias(userId, encryptedPassword);
        frm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnVerTransaccionesActionPerformed

    private void btnListarPizarraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarPizarraActionPerformed
        // TODO add your handling code here:
        FrmListarPizarra frm = new FrmListarPizarra(userId, encryptedPassword);
        frm.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_btnListarPizarraActionPerformed

    private void btnListarUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarUsuariosActionPerformed
        // TODO add your handling code here:
        FrmListarUsuarios frm  = new FrmListarUsuarios(userId, encryptedPassword);
        frm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnListarUsuariosActionPerformed

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
            java.util.logging.Logger.getLogger(FrmAdminOptions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmAdminOptions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmAdminOptions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmAdminOptions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmAdminOptions("","").setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCambiarPassword;
    private javax.swing.JButton btnCrearAgente;
    private javax.swing.JButton btnFinalizarSesion;
    private javax.swing.JButton btnIniciarSesion;
    private javax.swing.JButton btnListarPizarra;
    private javax.swing.JButton btnListarUsuarios;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnSuspenderParticipante;
    private javax.swing.JButton btnVerEstadisticas;
    private javax.swing.JButton btnVerTransacciones;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel lblInicio;
    // End of variables declaration//GEN-END:variables
}
