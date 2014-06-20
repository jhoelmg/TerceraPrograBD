
package sistemaintercambio;

import DAO.CuentaDAO;
import Factory.DAOFactory;
import javax.swing.JOptionPane;


public class FrmDepositarDinero extends javax.swing.JFrame {

    String encryptedPassword, userId;
    
    public FrmDepositarDinero(String pUserId, String pEncryptedPassword) {
        initComponents();
        setLocationRelativeTo(null);
        
        encryptedPassword = pEncryptedPassword;
        userId = pUserId;
    }
    
    private void depositar(){
        double monto;
        String moneda;
        if(txtCedula.getText().trim().length() != 0 || txtMonto.getText().trim().length() != 0){
            if(rbtnColones.isSelected() || rbtnDolares.isSelected()){
                if(rbtnColones.isSelected())
                    moneda = "c";
                else
                    moneda = "d";
                try{
                    monto = Double.parseDouble(txtMonto.getText());
                    DAOFactory sqlserverFactory = DAOFactory.getDAOFactory(DAOFactory.SQLSERVER);
                    CuentaDAO cuentaDAO = sqlserverFactory.getCuentaDAO();
                    boolean result = cuentaDAO.depositar(txtCedula.getText(), userId, String.valueOf(monto), moneda);
                    if(result)
                        JOptionPane.showMessageDialog(null, "Deposito correctamente efectuado");
                    else
                        JOptionPane.showMessageDialog(null, "Hubo un problema al efectuar el deposito"); 
                }
                catch(Exception e){
                    JOptionPane.showMessageDialog(this, "Digite un monto valido por favor");
                }
            }
            else
                JOptionPane.showMessageDialog(this, "Seleccione la moneda de la cuenta donde quiere depositar");
        }
        else
            JOptionPane.showMessageDialog(this, "Por favor llene todos los espacios solicitados");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        radioGroupMoneda = new javax.swing.ButtonGroup();
        lblInicio = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        btnDepositar = new javax.swing.JButton();
        txtCedula = new javax.swing.JTextField();
        lblInicio4 = new javax.swing.JLabel();
        txtMonto = new javax.swing.JTextField();
        lblInicio5 = new javax.swing.JLabel();
        rbtnDolares = new javax.swing.JRadioButton();
        rbtnColones = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblInicio.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblInicio.setText("Depositar");

        btnCancelar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setToolTipText("");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnDepositar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnDepositar.setText("Depositar");
        btnDepositar.setToolTipText("");
        btnDepositar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDepositarActionPerformed(evt);
            }
        });

        txtCedula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCedulaKeyTyped(evt);
            }
        });

        lblInicio4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblInicio4.setText("Cédula:");

        lblInicio5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblInicio5.setText("Monto:");

        radioGroupMoneda.add(rbtnDolares);
        rbtnDolares.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rbtnDolares.setText("Dolares");

        radioGroupMoneda.add(rbtnColones);
        rbtnColones.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rbtnColones.setText("Colones");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblInicio))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(rbtnDolares)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(rbtnColones))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnDepositar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblInicio4)
                                .addGap(18, 18, 18)
                                .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblInicio5)
                                .addGap(18, 18, 18)
                                .addComponent(txtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblInicio)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblInicio4)
                    .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblInicio5)
                    .addComponent(txtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbtnColones)
                    .addComponent(rbtnDolares))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDepositar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        FrmAgentOptions frm = new FrmAgentOptions(userId, encryptedPassword);
        frm.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnDepositarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDepositarActionPerformed
        // TODO add your handling code here:
        depositar();
    }//GEN-LAST:event_btnDepositarActionPerformed

    private void txtCedulaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCedulaKeyTyped
        // TODO add your handling code here:
        char caracter = evt.getKeyChar();
        if((caracter<'0' || caracter>'9')){
            evt.consume();
        }
        if(txtCedula.getText().trim().length() > 8)
        evt.consume();
    }//GEN-LAST:event_txtCedulaKeyTyped

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
            java.util.logging.Logger.getLogger(FrmDepositarDinero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmDepositarDinero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmDepositarDinero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmDepositarDinero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmDepositarDinero("","").setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnDepositar;
    private javax.swing.JLabel lblInicio;
    private javax.swing.JLabel lblInicio4;
    private javax.swing.JLabel lblInicio5;
    private javax.swing.ButtonGroup radioGroupMoneda;
    private javax.swing.JRadioButton rbtnColones;
    private javax.swing.JRadioButton rbtnDolares;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtMonto;
    // End of variables declaration//GEN-END:variables
}
