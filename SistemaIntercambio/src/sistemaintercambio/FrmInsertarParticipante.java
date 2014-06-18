
package sistemaintercambio;

import DAO.ParticipanteDAO;
import Factory.DAOFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.swing.JOptionPane;

public class FrmInsertarParticipante extends javax.swing.JFrame {

    String encryptedPassword, userId;
    
    public FrmInsertarParticipante(String pUserId, String pEncryptedPassword) {
        initComponents();
        setLocationRelativeTo(null);
        
        encryptedPassword = pEncryptedPassword;
        userId = pUserId;
    }
    
    private void insertParticipante()
    {
        if (txtNombre.getText().trim().length() != 0 && txtCedula.getText().trim().length() != 0 
                && txtApelliP.getText().trim().length() != 0 && txtApelliM.getText().trim().length() != 0
                && String.valueOf(pfPassword.getPassword()).trim().length() != 0
                && txtEmail.getText().trim().length() != 0 && txtTelef.getText().trim().length() != 0
                && calFechaNac.getDate() != null && txtDireccion.getText().trim().length() != 0)
        {
            DAOFactory sqlserverFactory = DAOFactory.getDAOFactory(DAOFactory.SQLSERVER);
            ParticipanteDAO participanteDAO = sqlserverFactory.getParticipanteDAO();
            boolean result = participanteDAO.insertarParticipante(txtCedula.getText(), txtNombre.getText(), txtApelliP.getText(), 
                                                txtApelliM.getText(), String.valueOf(pfPassword.getPassword()),
                                                txtEmail.getText(), txtTelef.getText(), txtDireccion.getText(),
                                                calFechaNac.getDate());
            if(result)
                JOptionPane.showMessageDialog(null, "Participante insertado correctamente!");
            else
                JOptionPane.showMessageDialog(null, "Hubo un problema al insertar el participante."); 
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Rellene todos los espacios correctamente"); 
        }
    }
    
    private String encryptPassword(String pPassword){
        
        String generatedPassword = null;
        try {
            // Create MessageDigest instance for MD5
            MessageDigest md = MessageDigest.getInstance("MD5");
            //Add password bytes to digest
            md.update(pPassword.getBytes());
            //Get the hash's bytes
            byte[] bytes = md.digest();
            //This bytes[] has bytes in decimal format;
            //Convert it to hexadecimal format
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++)
            {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            //Get complete hashed password in hex format
            generatedPassword = sb.toString();
        }
        catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }
        
        return generatedPassword;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pfOldPassword = new javax.swing.JPasswordField();
        lblInicio = new javax.swing.JLabel();
        pfPassword = new javax.swing.JPasswordField();
        lblInicio1 = new javax.swing.JLabel();
        lblInicio2 = new javax.swing.JLabel();
        lblInicio3 = new javax.swing.JLabel();
        lblInicio4 = new javax.swing.JLabel();
        lblInicio5 = new javax.swing.JLabel();
        lblInicio6 = new javax.swing.JLabel();
        pfPasswordR = new javax.swing.JPasswordField();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        txtNombre = new javax.swing.JTextField();
        txtApelliP = new javax.swing.JTextField();
        txtApelliM = new javax.swing.JTextField();
        txtCedula = new javax.swing.JTextField();
        txtTelef = new javax.swing.JTextField();
        lblInicio7 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        lblInicio8 = new javax.swing.JLabel();
        lblInicio9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDireccion = new javax.swing.JTextArea();
        lblInicio10 = new javax.swing.JLabel();
        calFechaNac = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblInicio.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblInicio.setText("Insertar Agente");

        lblInicio1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblInicio1.setText("Nombre:");

        lblInicio2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblInicio2.setText("Primer Apellido:");

        lblInicio3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblInicio3.setText("Telefono:");

        lblInicio4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblInicio4.setText("Cédula:");

        lblInicio5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblInicio5.setText("Contraseña:");

        lblInicio6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblInicio6.setText("Repita Contraseña:");

        btnAceptar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        txtCedula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCedulaKeyTyped(evt);
            }
        });

        txtTelef.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefKeyTyped(evt);
            }
        });

        lblInicio7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblInicio7.setText("Segundo Apellido:");

        lblInicio8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblInicio8.setText("Email:");

        lblInicio9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblInicio9.setText("Fecha Nacimiento:");

        txtDireccion.setColumns(20);
        txtDireccion.setRows(5);
        jScrollPane1.setViewportView(txtDireccion);

        lblInicio10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblInicio10.setText("Direccion:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(23, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblInicio1)
                            .addComponent(lblInicio)
                            .addComponent(lblInicio2)
                            .addComponent(lblInicio3)
                            .addComponent(lblInicio4)
                            .addComponent(lblInicio5)
                            .addComponent(lblInicio6)
                            .addComponent(lblInicio8)
                            .addComponent(lblInicio7)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btnCancelar)
                                .addComponent(lblInicio9))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lblInicio10)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(pfPassword, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                    .addComponent(pfPasswordR, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtApelliP, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                    .addComponent(txtApelliM, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                    .addComponent(txtCedula, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                    .addComponent(txtTelef, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                    .addComponent(btnAceptar)
                    .addComponent(jScrollPane1)
                    .addComponent(calFechaNac, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblInicio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblInicio1)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblInicio2)
                    .addComponent(txtApelliP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtApelliM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblInicio7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblInicio4)
                    .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pfPassword, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblInicio5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblInicio6)
                    .addComponent(pfPasswordR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTelef, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblInicio3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblInicio8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblInicio9)
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblInicio10)
                                .addGap(30, 139, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnAceptar)
                                    .addComponent(btnCancelar))
                                .addContainerGap())))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(calFechaNac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        // TODO add your handling code here:
        String encryptedPasswordC = encryptPassword(String.valueOf(pfPassword.getPassword()));
        String encryptedPasswordCR = encryptPassword(String.valueOf(pfPasswordR.getPassword()));

        if(!encryptedPasswordC.equals(encryptedPasswordCR))
        {
            JOptionPane.showMessageDialog(this, "La contraseña no coincide en los dos espacios");
        }
        else
        {
            insertParticipante();
        }
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        FrmAgentOptions frm = new FrmAgentOptions(userId, encryptedPassword);
        frm.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtCedulaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCedulaKeyTyped
        // TODO add your handling code here:
        char caracter = evt.getKeyChar();  
        if((caracter<'0' || caracter>'9')){
           evt.consume();
        }
        if(txtCedula.getText().trim().length() > 8)
            evt.consume();
    }//GEN-LAST:event_txtCedulaKeyTyped

    private void txtTelefKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefKeyTyped
        // TODO add your handling code here:
        char caracter = evt.getKeyChar();  
        if((caracter<'0' || caracter>'9')){
           evt.consume();
        }
        if(txtTelef.getText().trim().length() > 7)
            evt.consume();
    }//GEN-LAST:event_txtTelefKeyTyped

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
            java.util.logging.Logger.getLogger(FrmInsertarParticipante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmInsertarParticipante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmInsertarParticipante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmInsertarParticipante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmInsertarParticipante("","").setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private com.toedter.calendar.JDateChooser calFechaNac;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblInicio;
    private javax.swing.JLabel lblInicio1;
    private javax.swing.JLabel lblInicio10;
    private javax.swing.JLabel lblInicio2;
    private javax.swing.JLabel lblInicio3;
    private javax.swing.JLabel lblInicio4;
    private javax.swing.JLabel lblInicio5;
    private javax.swing.JLabel lblInicio6;
    private javax.swing.JLabel lblInicio7;
    private javax.swing.JLabel lblInicio8;
    private javax.swing.JLabel lblInicio9;
    private javax.swing.JPasswordField pfOldPassword;
    private javax.swing.JPasswordField pfPassword;
    private javax.swing.JPasswordField pfPasswordR;
    private javax.swing.JTextField txtApelliM;
    private javax.swing.JTextField txtApelliP;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextArea txtDireccion;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelef;
    // End of variables declaration//GEN-END:variables
}
