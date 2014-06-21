
package sistemaintercambio;

import DAO.SesionDAO;
import Factory.DAOFactory;
import javax.swing.JOptionPane;
import sistemaintercambio.FrmCambiarPassword;
import sistemaintercambio.FrmFinalizarSesion;
import sistemaintercambio.FrmInsertarAgente;
import sistemaintercambio.FrmLogin;
import sistemaintercambio.FrmSuspenderParticipante;

public class FrmParticiOptions extends javax.swing.JFrame {

    String encryptedPassword, userId;
    
    public FrmParticiOptions(String pUserId, String pEncryptedPassword) {
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
        btnUltimasNegociaciones = new javax.swing.JButton();
        btnListarOfertas = new javax.swing.JButton();
        btnBuscarOferta = new javax.swing.JButton();
        btnRealizarOferta = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();

        jButton6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton6.setText("Iniciar Sesion Negociacion");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblInicio.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblInicio.setText("Bienvenido Participante");

        btnUltimasNegociaciones.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnUltimasNegociaciones.setText("Ultimas Negociaciones");

        btnListarOfertas.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnListarOfertas.setText("Listar Ofertas");
        btnListarOfertas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarOfertasActionPerformed(evt);
            }
        });

        btnBuscarOferta.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnBuscarOferta.setText("Buscar Oferta");
        btnBuscarOferta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarOfertaActionPerformed(evt);
            }
        });

        btnRealizarOferta.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnRealizarOferta.setText("Realizar Oferta");
        btnRealizarOferta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRealizarOfertaActionPerformed(evt);
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
                        .addGap(0, 15, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnSalir)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnListarOfertas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnBuscarOferta, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnRealizarOferta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnUltimasNegociaciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(23, 23, 23))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblInicio)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUltimasNegociaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnListarOfertas, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRealizarOferta, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarOferta, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnListarOfertasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarOfertasActionPerformed
      
    }//GEN-LAST:event_btnListarOfertasActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        FrmLogin frm = new FrmLogin();
        frm.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnRealizarOfertaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRealizarOfertaActionPerformed
        FrmRealizarOferta frm = new FrmRealizarOferta(userId, encryptedPassword);
        frm.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnRealizarOfertaActionPerformed

    private void btnBuscarOfertaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarOfertaActionPerformed
        FrmBuscarOferta frm = new FrmBuscarOferta(userId, encryptedPassword);
        frm.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnBuscarOfertaActionPerformed

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
            java.util.logging.Logger.getLogger(FrmParticiOptions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmParticiOptions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmParticiOptions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmParticiOptions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmParticiOptions("","").setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarOferta;
    private javax.swing.JButton btnListarOfertas;
    private javax.swing.JButton btnRealizarOferta;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnUltimasNegociaciones;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel lblInicio;
    // End of variables declaration//GEN-END:variables
}
